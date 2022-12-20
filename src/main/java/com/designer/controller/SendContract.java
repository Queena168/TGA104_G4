package com.designer.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.designer.model.DesignerOrderVO;
import com.designer.service.DesignerOrderService;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/SendContract")
public class SendContract extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String saveDirectory = "/images_uploaded";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=Big5");
		HttpSession session = req.getSession();
		session.getAttribute("designerOrderVO");
		
		
		//=============================================================================
		//檔案上傳
		
		PrintWriter out = res.getWriter();
		System.out.println("ContentType=" + req.getContentType()); // 測試用

		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath=" + realPath); // 測試用

		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄

		Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
		out.write("<h2> Total parts : " + parts.size() + "</h2>");

		for (Part part : parts) {
			String filename = part.getSubmittedFileName();
			if (filename != null && filename.length() != 0 && part.getContentType() != null) {
				out.println("<PRE>");
				out.println("name: " + part.getName());
				out.println("filename: " + filename);
				out.println("ContentType: " + part.getContentType());
				out.println("size: " + part.getSize());

				File f = new File(fsaveDirectory, filename);
				out.println("File: " + f);

				// 利用File物件,寫入目地目錄,上傳成功
				part.write(f.toString());

				// 額外測試 InputStream 與 byte[] (幫將來model的VO預作準備)
				InputStream in = part.getInputStream();
				byte[] buf = new byte[in.available()]; // byte[] buf = in.readAllBytes(); // Java 9 的新方法
				in.read(buf);
				in.close();
				out.println("buffer length: " + buf.length);

				// 額外測試秀圖
				out.println("<br><img src=\"" + req.getContextPath() + saveDirectory + "/" + filename + "\">");
				out.println();
				out.println("</PRE>");

			}

		}
		
		
		
		
		
		
		//=================================================================================
		
		
		
	
		String action =  req.getParameter("action");
		
		if("sendcontract".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);			
			String strorderno = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(strorderno);
				System.out.println("SendContract的designerOrderNo:"+designerOrderNo);
			} catch (Exception e) {
				System.err.print("SendContract的designerOrderNo為空值");
			}
			
			
			String strdesignerno = req.getParameter("designerNo");
			Integer designerNo = null;
			try {
				designerNo = Integer.valueOf(strdesignerno);
				System.out.println("SendContract的designerNo:"+designerNo);
			} catch (Exception e) {
				System.err.print("SendContract的designerNo為空值");
			}
			
			String contractDetail=req.getParameter("contractDetail");
			if(contractDetail==null||contractDetail.trim().length()==0) {
				errorMsgs.add("請輸入合約內容");
			}
			
			

			DesignerOrderService designerOrderScv = new DesignerOrderService();

			designerOrderScv.updateContract(designerOrderNo,contractDetail);
			List<DesignerOrderVO> list= designerOrderScv.getAllMyContract(designerNo);
			
			
			
			req.setAttribute("list", list);			
		    String url = "/front-end/designer/contractManage.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		    out.println("<script> alert('檔案以上傳!');</script>");
		    successView.forward(req, res);
		}
		
	
	}

}
