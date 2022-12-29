package com.tibame.designer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/SendQuotation")
public class SendQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String saveDirectory = "/images_uploaded";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=Big5");
		res.setContentType("application/pdf");
		HttpSession session = req.getSession();
		session.getAttribute("designerOrderVO");
		PrintWriter out = res.getWriter();
		String action = req.getParameter("action");

		if ("sendquotation".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// Integer designerOrderNo=Integer.valueOf(req.getParameter("orderNo"));

			String strorderno = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(strorderno);
				System.out.println("designerOrderNo:" + designerOrderNo);
			} catch (Exception e) {
				System.err.print("SendQuotation的designerOrderNo為空值");
			}

			String strdesignerno = req.getParameter("designerNo");
			Integer designerNo = null;
			try {
				designerNo = Integer.valueOf(strdesignerno);
				System.out.println("designerNo:" + designerNo);
			} catch (Exception e) {
				System.err.print("SendQuotation的designerNo為空值");
			}

			String strnumber = req.getParameter("quotationAmount");
			Integer quotationAmount = null;
			try {
				quotationAmount = Integer.valueOf(strnumber);
			} catch (Exception e) {
				errorMsgs.add("請輸入報價金額");
			}

			String quotationDetail = req.getParameter("quotationDetail");
			if (quotationDetail == null || quotationDetail.trim().length() == 0) {
				errorMsgs.add("請輸入報價內容");
			}

			// ====================================================================
//			// 取得檔案
//			Part filePart = req.getPart("upfilequotation");
//			// 取得檔案名稱
//			String fileName = filePart.getSubmittedFileName();
//			// 建立 SimpleDateFormat 物件
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//			// 取得當前時間戳
//			long timestamp = new Date().getTime();
//			// 將時間戳格式化為指定的格式
//			String formattedTimestamp = sdf.format(timestamp);
//			// 將檔案名命名為 formattedTimestamp
//			String newFileName = formattedTimestamp + fileName.substring(fileName.lastIndexOf("."));
//			InputStream fileContent  = filePart.getInputStream();
//			FileOutputStream output = new FileOutputStream(newFileName);
//			byte[] quotationAtt = new byte[1024];
//			int read;
//			while ((read = fileContent.read(quotationAtt)) != -1) {
//				output.write(quotationAtt, 0, read);
//				}
//				output.close();
//				fileContent.close();
//				fileContent.read(quotationAtt);
//				fileContent.close();
			
			Part part = req.getPart("upfilequotation");
			//====================================================			
////			PrintWriter out = res.getWriter();
//			//System.out.println("ContentType=" + req.getContentType()); // 測試用
//			String realPath = getServletContext().getRealPath(saveDirectory);
//			System.out.println("realPath=" + realPath); // 測試用
//			File fsaveDirectory = new File(realPath);
////			if (!fsaveDirectory.exists()) 
////				fsaveDirectory.mkdirs(); // 於 ContextPath 之下,自動建立目地目錄
////			Collection<Part> parts = req.getParts(); // Servlet3.0新增了Part介面，讓我們方便的進行檔案上傳處理
////			for (Part part : parts) {
////				String filename = part.getSubmittedFileName();
////				if (filename != null && filename.length() != 0 && part.getContentType() != null) {
//					// 建立 SimpleDateFormat 物件
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//					// 取得當前時間戳
//				    long timestamp = new Date().getTime();
//				    // 將時間戳格式化為指定的格式
//				    String formattedTimestamp = sdf.format(timestamp);
//				    // 將檔名命名為 formattedTimestamp
//				    String filename1 = formattedTimestamp + ".pdf";
//					File f = new File(fsaveDirectory, filename1);
//					// 利用File物件,寫入目地目錄,上傳成功
////					part.write(f.toString());			
			//===================================================
			InputStream in = part.getInputStream();
			byte[] quotationAtt = new byte[in.available()];
			in.read(quotationAtt);
			in.close();
			
			

			// =====================================================================

			DesignerOrderService designerOrderScv = new DesignerOrderService();
			designerOrderScv.updateQuotation(designerOrderNo, quotationAmount, quotationDetail, quotationAtt);
			List<DesignerOrderVO> list = designerOrderScv.getAllMyQuotation(designerNo);
			session.setAttribute("list", list);
			String url = "/front-end/designer/quotationManage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			out.println("<script> alert('檔案以上傳!');</script>");
			successView.forward(req, res);
		}

	}

}
