//package com.zte.mcrm.framework.common.run;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//import java.util.Vector;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.digester.Digester;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.xml.sax.SAXException;
//
///**
// * 用于管理所有的调度线程。
// * <p>
// * 
// * 启动本 servlet 创建相应的一组 Thread，此后通过 doPost 或 doCommand 调用来对各个
// * Thread 进行管理（挂起、恢复、重启、强制唤醒）。<br>
// * 每个 Thread 自己周期性唤醒工作再睡眠。
// * <p>
// * 
// * 所管理的线程由 mcrm-config.xml 来配置，控制命令包括：<br>
// * <li>suspend threadname
// * <li>resume threadname
// * <li>wakeup threadname
// * <li>wakeup threadname param-string
// * <li>restart threadname
// * <li>list
// */
//public class SchedulerServlet extends HttpServlet
//{
//
//	/**
//	 * serialVersionUID
//	 */
//	private static final long serialVersionUID = -1424001126731049196L;
//
//	protected Log log = LogFactory.getLog(getClass());
//	
//	private static final String className = "com.zte.mcrm.framework.common.run.SchedulerServlet";
//
//	private static final String separator="/";
//	private static Vector<SchedulerObject> schedulers = null;
//
//	private static String realPath = "";
//
//	/**
//	 * 
//	 * 业务描述：XXX 
//	 * 作          者：JohnnyHuang 黄福强
//	 * 完成日期：2015-1-21
//	 * @param so
//	 */
//	public void addScheduler(SchedulerObject so)
//	{
//		schedulers.add(so);
//	}
//
//	public static Vector<SchedulerObject> getSchedulers() {
//		return schedulers;
//	}
//
//	/**
//	 * 系统启动时初始化配置
//	 */
//	@Override
//	public void init() throws ServletException
//	{
//
//		log.info(this.getClass().getName() + " init()");
//
//		// 检验是否重入（不应该出现重入）
//		if (schedulers != null)
//		{
//			String msg = "!!!!!!!! re-enter SchedulerServlet !!!!!!!!";
//			log.info(this.getClass().getName() + msg);
//			throw new ServletException(msg);
//		}
//
//		// 从mcrm-config.xml 中解析调度线程的配置情况
//		schedulers = new Vector<SchedulerObject>();
//
//		Digester digester = new Digester();
//		digester.push(this);
//		digester.setDebug(0);
//		digester.setValidating(false);
//
//		digester.addObjectCreate(SchedulerObject.SCHEDULER_TASK_TAG, "com.zte.mcrm.framework.common.run.SchedulerObject", "className");
//		digester.addSetNext(SchedulerObject.SCHEDULER_TASK_TAG, "addScheduler", "com.zte.mcrm.framework.common.run.SchedulerObject");
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_NAME_TAG, "setName", 0);
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_TYPE_TAG, "setType", 0);
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_PERIOD_TAG, "setPeriod", 0);
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_OFFSET_TAG, "setOffset", 0);
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_SUSPEND_TAG, "setSuspend", 0);
//		digester.addCallMethod(SchedulerObject.SCHEDULER_TASK_TAG+separator+SchedulerObject.SCHEDULER_DESC_TAG, "setDesc", 0);
//        //载入配置任务信息
//		InputStream input = getServletContext().getResourceAsStream("/WEB-INF/mcrm-config.xml");
//		realPath = getServletContext().getRealPath("WEB-INF");
//
//		try
//		{
//			digester.parse(input);
//			input.close();
//		}
//		catch (SAXException e)
//		{
//			throw new ServletException(e.getMessage());
//		}
//		catch (IOException e)
//		{
//			throw new ServletException(e.getMessage());
//		}
//
//		// 从 web.xml 中决定调度线程是否处于挂起状态
//		boolean bSuspend = false;
//		String strSuspend = getServletConfig().getInitParameter("suspend");
//		if (strSuspend != null)
//		{
//			if (strSuspend.trim().equalsIgnoreCase("true"))
//				bSuspend = true;
//		}
//
//		// 加载所有需要的调度线程
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//
//			try
//			{
//				if (!so.getSuspend())
//				{
//					Class threadClass = Class.forName(so.getType());
//					BaseSchedulerThread bst = (BaseSchedulerThread) threadClass.newInstance();
//					so.setThread(bst);
//					bst.setSchedule(so.getPeriod(), so.getOffset(),"","");
//					bst.setConfigPath(realPath);// 设置绝对路径
//					if (bSuspend || so.getSuspend())
//						bst.suspendSchedule();
//					bst.start();
//				}
//			}
//			catch (ClassNotFoundException e)
//			{
//				log.error(this.getClass().getName() + " can not found class [" + so.getType() + "]");
//			}
//			catch (Exception e)
//			{
//				log.error(this.getClass().getName() + " " + e.getMessage());
//				throw new ServletException(e);
//			}
//
//			log.info(this.getClass().getName() + so.toString());
//		}
//	}
//
//	@Override
//	public void destroy()
//	{
//		log.info(this.getClass().getName() + ".destroy()");
//
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//			BaseSchedulerThread bst = so.getThread();
//			if (bst != null)
//				bst.notifyStop();
//			so.setThread(null);
//		}
//	}
//
//	@Override
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
//	{
//		log.info(this.getClass().getName() + ".doGet()");
//		doPost(request, response);
//	}
//
//	@Override
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
//	{
//		log.info(this.getClass().getName() + ".doPost()");
//		PrintWriter out = response.getWriter();
//
//		// 检查是否来自于指定 IP 地址的机器
//		String ip = getServletConfig().getInitParameter("IP");
//		if (ip != null && ip.length() > 0)
//		{
//
//			boolean permit = false;
//
//			String remote_addr = request.getRemoteAddr();
//
//			try
//			{
//				StringTokenizer st = new StringTokenizer(ip, ", ");
//
//				for (;;)
//				{
//					String ip1 = st.nextToken();
//					if (ip1.equals(remote_addr))
//					{
//						permit = true;
//						throw new Exception("permit");
//					}
//				}
//			}
//			catch (Exception e)
//			{
//			}
//
//			if (!permit)
//			{
//				out.print("地址 " + remote_addr + " 被拒绝");
//				return;
//			}
//		}
//
//		String command = request.getParameter("command");
//		out.print(doCommand(command));
//	}
//
//	/**
//	 * 
//	 * 业务描述：XXX 
//	 * 作          者：JohnnyHuang 黄福强
//	 * 完成日期：2015-1-21
//	 * @param name
//	 * @return
//	 */
//	public static SchedulerObject getSchdulerObject(String name)
//	{
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//			if (so.getName().equalsIgnoreCase(name))
//				return so;
//		}
//		return null;
//	}
//
//	/**
//	 * 
//	 * 业务描述：XXX 
//	 * 作          者：JohnnyHuang 黄福强
//	 * 完成日期：2015-1-21
//	 * @param command
//	 * @return
//	 */
//	public static String doCommand(String command)
//	{
//		if (command == null)
//		{
//			System.out.println(className + " no command");
//			return "no command";
//		}
//
//		StringTokenizer st = new StringTokenizer(command);
//		String cmd = null;
//		String name = null;
//		if (st.hasMoreTokens())
//			cmd = st.nextToken();
//		if (cmd == null)
//			return "no command";
//		if (cmd.equalsIgnoreCase("list"))
//		{
//			StringBuffer sb = new StringBuffer();
//			for (int i = 0; i < schedulers.size(); i++)
//			{
//				SchedulerObject so = schedulers.get(i);
//				sb.append(so.getName());
//				sb.append(" ");
//				sb.append(so.getThread() != null ? "[" + so.getPeriod() + "," + so.getOffset() + "]" : "null");
//				sb.append("\r\n");
//			}
//			return sb.toString();
//		}
//
//		if (st.hasMoreTokens())
//			name = st.nextToken();
//		if (name == null)
//			return "no command";
//
//		// 找到指定的调度线程
//		SchedulerObject scheduler = null;
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//			if (!name.equalsIgnoreCase(so.getName()))
//				continue;
//			scheduler = so;
//			break;
//		}
//
//		if (scheduler == null)
//			return "no scheduler";
//		BaseSchedulerThread bst = scheduler.getThread();
//		if (bst == null)
//		{
//			System.out.println(className + " no thread for scheduler - " + scheduler);
//			return "no thread";
//		}
//
//		// 按命令进行处理
//		if (cmd.equalsIgnoreCase("suspend"))
//		{
//			bst.suspendSchedule();
//		}
//		else if (cmd.equalsIgnoreCase("resume"))
//		{
//			bst.resumeSchedule();
//		}
//		else if (cmd.equalsIgnoreCase("wakeup"))
//		{
//			String param = null;
//			if (st.hasMoreTokens())
//				param = st.nextToken();
//			if (param == null)
//				bst.notifyWakeup();
//			else
//				bst.notifyWakeup(param);
//		}
//		else if (cmd.equalsIgnoreCase("restart"))
//		{
//			bst.notifyStop();
//
//			try
//			{
//				Class threadClass = Class.forName(scheduler.getType());
//				bst = (BaseSchedulerThread) threadClass.newInstance();
//				bst.setConfigPath(realPath);// 设置绝对路径
//				bst.start();
//				scheduler.setThread(bst);
//			}
//			catch (Exception e)
//			{
//				System.out.println(className + " " + e.getMessage());
//				scheduler.setThread(null);
//			}
//		}
//
//		return "done";
//	}
//
//	/**
//	 * 
//	 * 业务描述：XXX 
//	 * 作          者：JohnnyHuang 黄福强
//	 * 完成日期：2015-1-21
//	 * @param param
//	 * @return
//	 */
//	protected int getParam(String param)
//	{
//		int nRet = 60 * 60 * 24;
//		String path = "/WEB-INF/schdule.conf";
//		try
//		{
//			java.util.Properties config = new java.util.Properties();
//			java.io.InputStream in = getServletContext().getResourceAsStream(path);
//			config.load(in);
//			in.close();
//			String strValue = config.getProperty(param);
//			nRet = Integer.parseInt(strValue);
//		}
//		catch (Exception e)
//		{
//			System.out.println(className + " License Checker Initiation failed.=" + e);
//			nRet = 60 * 60 * 24;
//		}
//		return nRet;
//	}
//}
