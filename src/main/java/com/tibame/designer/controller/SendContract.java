package com.tibame.designer.controller;

import java.io.IOException;
import java.io.InputStream;
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

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderPhaseService;
import com.tibame.designer.service.DesignerOrderService;
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
		session.getAttribute("designerOrderPhaselist"); 
		String action =  req.getParameter("action");
		
		if("sendcontract".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);			
			String strorderno = req.getParameter("orderNo");
			Integer OrderNo = null;
			try {
				OrderNo = Integer.valueOf(strorderno);
				System.out.println("SendContract的designerOrderNo:"+OrderNo);
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
			Integer totalOrderPhase = Integer.valueOf(req.getParameter("totalOrderPhase").trim());
			//System.out.println("sendcontract之totalOrderPhase:"+totalOrderPhase);
			Integer totalamount = Integer.valueOf(req.getParameter("totalamount").trim());
			//System.out.println("sendcontract之totalamount:"+totalamount);
			
			Part part = req.getPart("upfilecontract");
			//====================================================			
//			PrintWriter out = res.getWriter();
			//System.out.println("ContentType=" + req.getContentType()); // 測試用
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
//					//part.write(f.toString());			
			//===================================================
			InputStream in = part.getInputStream();
			byte[] contractAtt = new byte[in.available()];
			in.read(contractAtt);
			in.close();
			
			

			DesignerOrderService designerOrderScv = new DesignerOrderService();
			
            //1.更新合約資訊--DesignerOrder資料表的contractDetail,contractAtt欄位
			designerOrderScv.updateContract(OrderNo,contractDetail,contractAtt);	
			
			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			//2.新增DesignerOrderPhase資料表的totalOrderPhase,totalamount欄位
			System.out.println("56vu/6=====================================");
			DesignerOrderPhaseVO designerOrderPhaseVO = designerOrderPhaseSvc.insertDesignerOrderPhase(OrderNo, totalOrderPhase, totalamount);
		
			//3.重新抓取合約DesignerOrder資訊
			List<DesignerOrderVO> list= designerOrderScv.getAllMyContract(designerNo);
			//4.重新抓取DesignerOrderPhase資訊
			List<DesignerOrderPhaseVO> listOrderPhase=designerOrderPhaseSvc.getOrderPhase(OrderNo);
			//System.out.println("sendContract的designerOrderPhaseVO內容:"+designerOrderPhaseVO.toString());
			//System.out.println("listOrderPhase內容:"+listOrderPhase.toString());
			//System.out.println("list內容:"+list.toString());
			
            //3.將新抓取合約資訊呈現致導頁
			session.setAttribute("designerOrderPhaseVO", designerOrderPhaseVO);
			session.setAttribute("list", list);		
			session.setAttribute("listOrderPhase", listOrderPhase);
		    String url = "/front-end/designer/contractManage.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); 
		    successView.forward(req, res);
		}
		
	
	}
	


}
