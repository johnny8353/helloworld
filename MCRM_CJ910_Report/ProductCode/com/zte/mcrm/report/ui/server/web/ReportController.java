package com.zte.mcrm.report.ui.server.web;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.zte.mcrm.framework.ui.framework.controller.SiebelBaseController;

/**
 * 类 编 号：
 * 类 名 称：ReportController
 * 内容摘要：XXX 
 * 完成日期：2016-2-26
 * 编码作者：JohnnyHuang
 */
@Controller("report")
public class ReportController   extends SiebelBaseController{
	protected Log log = LogFactory.getLog(getClass());
	
	public String doPcCustom(HttpServletRequest request,HttpServletResponse response){
//	    String svgString = request.getParameter("svg");
//	   
//	    String type = request.getParameter("type");
//	    response.setContentType(type);
//	    String filename = new Date().toLocaleString().replace(" ","_")+"."+type.substring(6);
//	    response.setHeader("Content-disposition","attachment;filename=" + filename);
//	    // 构造一个新的转码器，产生JPEG图像
//	    JPEGTranscoder t = new JPEGTranscoder();
//	    // 设置一个转码过程，JPEGTranscoder.KEY_QUALITY设置输出png的画质精度，0-1之间
//	    t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY,new Float(.8));
//	    TranscoderInput input = new TranscoderInput(new StringReader(svgString));
//	    try {
//	    	// 定义单路输出的转码器
//	        TranscoderOutput output = new TranscoderOutput(response.getOutputStream());
//	        // 转换svg文件为png
//	        t.transcode(input, output);
//	        response.getOutputStream().flush();
//	        response.getOutputStream().close();
//	    }catch (Exception e){
//	        try {
//				response.getOutputStream().close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//	        e.printStackTrace();
//	    }
	    return "";
	}
}
