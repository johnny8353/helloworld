//package com.zte.mcrm.framework.common.run;
//
//import java.io.IOException;
//import java.io.InputStream;
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
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//import org.xml.sax.SAXException;
//
//import com.zte.mcrm.system.business.workflow.service.IThreadService;
///**
// * 类 编 号：
// * 类 名 称：StartupServlet.java
// * 内容摘要：服务器启动类
// * 1、 线程的控制
// * 完成日期：2016-3-23
// * 编码作者：JohnnyHuang
// */
//public class StartupServlet  extends HttpServlet{
//	/**
//	 * 名 称：
//	 * 编码作者：JohnnyHuang
//	 */
//	private static final long serialVersionUID = 1L;
//	protected Log log = LogFactory.getLog(getClass());
//	private static Vector<SchedulerObject> schedulers = null;
//	private IThreadService iThreadService;
//	@Override
//	public void init()  throws ServletException{
//		iThreadService = (IThreadService) getBean("threadService");
//		System.out.println("ZTE服务器启动=========init");
//		log.info(this.getClass().getName() + " init()");
//		inithread();
//	}
//	
//	public void inithread() throws ServletException{
//		// 检验是否重入（不应该出现重入）
//		if (schedulers != null)
//		{
//			String msg = "!!!!!!!! re-enter StartupServlet !!!!!!!!";
//			log.info(this.getClass().getName() + msg);
//			throw new ServletException(msg);
//		}
//
//		schedulers = new Vector<SchedulerObject>();
//		//载入排队、活动、挂起的线程
//		//
//		SchedulerObject schedulerObject = new SchedulerObject();
//		schedulerObject.setType("com.zte.mcrm.system.common.run.system.TestCaseThread");
//		schedulerObject.setName("SendMailFull");
//		schedulerObject.setDesc("每天八点执行测试用例并发送邮件");
//		schedulerObject.setPeriod(300);//<!-- 唤醒周期，即隔多久启动一次线程任务，单位:秒,1h：3600 1d：86400-->
//		schedulerObject.setOffset(0);
//		schedulerObject.setTid("83135756");
//		schedulerObject.setStartDate("2015-03-23 08:00:00");
//		schedulerObject.setSuspend("false");//<!-- 线程是否挂起，true:挂起，即线程不执行；false:不挂起，即按既定的时间周期执行线程 -->
//		schedulers.add(schedulerObject);
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
//			log.debug(so.toString());
//			try
//			{
//				if (!so.getSuspend())
//				{
//					Class threadClass = Class.forName(so.getType());
//					BaseSchedulerThread bst = (BaseSchedulerThread) threadClass.newInstance();
//					so.setThread(bst);
//					bst.setSchedule(so.getPeriod(), so.getOffset(),so.getStartDate());
//					bst.setSchedule(so.getTid(), so.getName());
//					if (bSuspend || so.getSuspend())
//						bst.suspendSchedule();
//					else{
//						//定时工作开始，修改 排队中的状态为 活动；活动中的不用修改
//						bst.start();
//					}
//		
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
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
//			throws ServletException, IOException {
//		System.out.println("ZTE=========service");
//		
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("ZTE服务器停止=========destroy");
//		log.info(this.getClass().getName() + ".destroy()");
//
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//			BaseSchedulerThread bst = so.getThread();
//			if (bst != null)
//				bst.notifyStop();
//			so.setThread(null);
//			//未完成的线程，修改状态为 错误 -服务器停止引发的错误
//		}
//	}
//	
//	/**
//	 * 
//	 * @Description: TODO 根据名称获取线程对象
//	 * @param @param name
//	 * @param @return   
//	 * @return SchedulerObject  
//	 * @throws
//	 * @author JohnnyHuang
//	 * @date 2016-3-23
//	 */
//	public static SchedulerObject getSchdulerObject(String name)
//	{
//		for (int i = 0; i < schedulers.size(); i++)
//		{
//			SchedulerObject so = schedulers.get(i);
//			if (so.getTid().equalsIgnoreCase(name))
//				return so;
//		}
//		return null;
//	}
//
//	public static Vector<SchedulerObject> getSchedulers() {
//		return schedulers;
//	}
//	
//    /**
//     * 获取bean实例
//     * 业务描述：XXX 
//     * 作          者：JohnnyHuang 黄福强
//     * 完成日期：2015-7-24
//     * @param beanId
//     * @return
//     */
//    protected Object getBean(String beanId)
//    {
//		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();  
//		return wac.getBean(beanId);
//    }
//}
