package com.tibame.portfolio.controller;

import java.io.IOException;
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

import com.tibame.designer.model.DesignerVO;
import com.tibame.designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/front-end/designer_protfolio/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		PrintWriter out = res.getWriter();
		String login = req.getParameter("login");


		if ("designerlogin".equals(login)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String designerAccount = req.getParameter("account").trim();
			String designerPassword = req.getParameter("password").trim();
			if (designerAccount == null || (designerAccount.trim()).length() == 0) {
				errorMsgs.add("請輸入帳號");
			}
			if (designerPassword == null || (designerPassword.trim()).length() == 0) {
				errorMsgs.add("請輸入密碼");
			}
			
			DesignerVO designerVO = new DesignerVO();
			designerVO.setDesignerAccount(designerAccount);
			designerVO.setDesignerPassword(designerPassword);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("designerVO", designerVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/designer_protfolio/login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/

			DesignerService designerSvc = new DesignerService();
			designerVO = designerSvc.logindesigner(designerAccount,designerPassword);
		
			if (designerVO == null) {
				errorMsgs.add("帳號或密碼錯誤，請重新登入!");
				req.setAttribute("designerVO", designerVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/designer_protfolio/login.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("designerlogin", designerlogin); // 資料庫取出的empVO物件,存入req
////			System.out.println("done2===========================================");
//			String url = "/front-end/designer/designerMainPage.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
////			System.out.println("done3=======================================");
//			successView.forward(req, res);
			
			
			
			//System.out.println("TEST0.0"+designerVO.toString());
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			designerVO=designerSvc.getOneDesigner(designerVO.getDesignerNo());
			HttpSession session=req.getSession();
			session.setAttribute("designerVO", designerVO);
			String url = "/front-end/designer_protfolio/index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 designerMainPage.jsp
			successView.forward(req, res);
		

		}

	}

}
