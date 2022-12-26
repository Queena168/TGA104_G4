package com.tibame.admin.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.admin.model.AdminDAO;
import com.tibame.admin.model.AdminVO;

@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		doPost(req, res);
//	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		
		/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		
		// 確認輸入參數符合格式且不為空值
		String adminEmail = req.getParameter("adminEmail");
		if (adminEmail == null || adminEmail.trim().length() == 0) {
			errorMsgs.add("管理員信箱: 請勿空白");
		}
		String adminPassword = req.getParameter("adminPassword");
		String adminPasswordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (adminPassword == null || adminPassword.trim().length() == 0) {
			errorMsgs.add("管理員密碼: 請勿空白");
		} else if(!adminPassword.trim().matches(adminPasswordReg)) { //以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
		}
		
		AdminVO adminVO = new AdminVO();
		adminVO.setAdminEmail(adminEmail);
		adminVO.setAdminPassword(adminPassword);
		
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("adminVO", adminVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/adminLogin/admin-login.jsp");
			failureView.forward(req, res);
			return; //程式中斷
		}
		
		// 判斷輸入的帳號密碼是否符合資料庫同一筆資料
		AdminDAO adminDAO = new AdminDAO();
//		System.out.println("adminVO.getAdminEmail" + adminVO.getAdminEmail());
//		System.out.println("adminDAO.adminLogin(adminVO)"+ adminDAO.adminLogin(adminVO));
		adminVO = adminDAO.adminLogin(adminVO);
		if(adminVO.getAdminNo()==null) { // 數入的帳密不正確，做以下工作
			errorMsgs.add("帳號密碼有誤，請重新輸入"); // 畫面顯示錯誤訊息
			req.setAttribute("adminVO", adminVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/adminLogin/admin-login.jsp");
			failureView.forward(req, res);
		} else {  // 帳號密碼正確，做以下工作
			HttpSession session = req.getSession();
			session.setAttribute("adminVO", adminVO); // 在session內做已經登入過的標識
			res.sendRedirect(req.getContextPath()+"/back-end/admin/index.jsp"); // 成功登入index.jsp
			
		}
		
		
	}

}
