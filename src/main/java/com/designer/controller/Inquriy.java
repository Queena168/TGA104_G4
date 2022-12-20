package com.designer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/inquiry")
public class Inquriy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session = req.getSession();
	
		//String action = req.getParameter("action");
		//System.out.println("done0=============================================");
//		if ("designerinfo".equals(action)) {
//
//			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//			String str = req.getParameter("designerNo");
//
//			Integer designerNo = null;
//			try {
//				designerNo = Integer.valueOf(str);
//				//System.out.println(designerNo);
//			} catch (Exception e) {
//				
//			}
//
//			/*************************** 2.開始查詢資料 *****************************************/
//			DesignerService designerSvc = new DesignerService();
//			//System.out.println("done1.5=====================================================");
//			DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("designerVO", designerVO); // 資料庫取出的empVO物件,存入req
//			//System.out.println("done2===========================================");
//			String url = "/front-end/designer/listOneDesignerINFO.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
//			//System.out.println("done3=======================================");
//			successView.forward(req, res);
//
//		}
		
		
		//==============================================================
		String inquiry = req.getParameter("inquiry");
		if("inquiry".equals(inquiry)) {
			System.out.println("有進來inquiry.java");
			session.getAttribute("designerExpertiseVO");
			Integer designerNo  = Integer.valueOf(req.getParameter("designerNo").trim());			
//			String str = req.getParameter("designerNo");
//			Integer designerNo = null;
//			try {
//				designerNo = Integer.valueOf(str);
//				System.out.println(designerNo);
//			} catch (Exception e) {
//				
//			}
//			
//			/*************************** 2.開始查詢資料 *****************************************/
//			MemberService memberSvc = new MemberService();
//			MemberVO memberVO = memberSvc.getOneMember(memberNo);
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("memberVO", memberVO); 
			//System.out.println("done1=========================");
			DesignerService designerSvc = new DesignerService();
			DesignerVO designerVO = designerSvc.getOneDesignerinfo(designerNo);
			session.setAttribute("designerVO",designerVO);
			String url = "/front-end/designer/inquiryPage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
			//System.out.println("done2=========================");
		}

	}

}
