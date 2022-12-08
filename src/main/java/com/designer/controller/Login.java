package com.designer.controller;

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
import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("done0===============================");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession();
		PrintWriter out = res.getWriter();
		String login = req.getParameter("login");
//		System.out.println("done0.5===========================");

		if ("designerlogin".equals(login)) {
//			System.out.println("done1=====================================");
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

			/*************************** 2.開始查詢資料 *****************************************/

			DesignerService designerSvc = new DesignerService();
//			System.out.println("done1.5=====================================================");
			DesignerVO designerlogin = designerSvc.logindesigner(designerAccount, designerPassword);
			
			
			if (designerlogin == null) {
//				errorMsgs.add("帳號或密碼錯誤，請重新輸入");
//				System.out.println("done1.8=================================================");
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert('User or password incorrect');");
//				out.println("location='index.jsp';");
//				out.println("</script>");
				// res.sendRedirect(req.getContextPath() + "/front-end/designer/index.jsp");
				
				
				//
				out.println("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
						+ "/front-end/designer/index.jsp'>");// redirects after 1 seconds
				out.println("<script> alert('帳號或密碼錯誤，請重新登入!');</script>");
				//out.println("<script><p style='color:red;'>帳號或密碼錯誤，請重新登入!</p></script>");
				return;
			}
			// Send the use back to the form, if there were errors
			// 測試alert
//			if (!errorMsgs.isEmpty()) {
//				HttpSession session = req.getSession();
//				session.setAttribute("errorFlag", "帳號或密碼錯誤，請重新輸入");
//				//req.setAttribute("errorFlag", "帳號或密碼錯誤，請重新輸入");
//				res.sendRedirect(req.getContextPath() + "/front-end/designer/index.jsp");
//				// RequestDispatcher failureView =
//				// req.getRequestDispatcher("/front-end/designer/index.jsp");
//				// failureView.forward(req, res);
//				return;// 程式中斷
//			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("designerlogin", designerlogin); // 資料庫取出的empVO物件,存入req
////			System.out.println("done2===========================================");
//			String url = "/front-end/designer/designerMainPage.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
////			System.out.println("done3=======================================");
//			successView.forward(req, res);
			
			
			
			
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			//req.setAttribute("designerlogin", designerlogin); // 資料庫取出的empVO物件,存入req
//			System.out.println("done2===========================================");
			session.setAttribute("designerlogin", designerlogin);
			String url = "/front-end/designer/designerMainPage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
//			System.out.println("done3=======================================");
			successView.forward(req, res);

		}

	}

}
