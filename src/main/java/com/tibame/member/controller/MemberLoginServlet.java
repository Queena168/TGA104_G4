package com.tibame.member.controller;

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

import com.tibame.member.model.MemberDAO;
import com.tibame.member.model.MemberVO;

@WebServlet("/front-end/member/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		// 確認輸入參數符合格式且不為空值
		String memberAccount = req.getParameter("email");
		if (memberAccount == null || memberAccount.trim().length() == 0) {
			errorMsgs.add("帳號信箱: 請勿空白");
		}
		String memberPassword = req.getParameter("password");
		String memberPasswordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if (memberPassword == null || memberPassword.trim().length() == 0) {
			errorMsgs.add("密碼: 請勿空白");
		} else if (!memberPassword.trim().matches(memberPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
		}

		MemberVO memberVO = new MemberVO();
		memberVO.setMemberAccount(memberAccount);
		memberVO.setMemberPassword(memberPassword);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
			RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/login.jsp");
			failureView.forward(req, res);
			return; // 程式中斷
		}

		// 判斷輸入的帳號密碼是否符合資料庫同一筆資料
		MemberDAO dao = new MemberDAO();
		memberVO = dao.memberLogin(memberVO);
		if(memberVO.getMemberNo()==null) { // 數入的帳密不正確，做以下工作
			errorMsgs.add("帳號密碼有誤，請重新輸入"); // 畫面顯示錯誤訊息
			req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
			RequestDispatcher failureView = req
					.getRequestDispatcher("/front-end/member/login.jsp");
			failureView.forward(req, res);
		} else {  // 帳號密碼正確，做以下工作
			if(memberVO.getActivaction()==false) {
				errorMsgs.add("帳號未啟用 請至信箱點擊啟用帳號"); // 畫面顯示錯誤訊息
				req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/member/login.jsp");
				failureView.forward(req, res);
			}else {
				HttpSession session = req.getSession();
				session.setAttribute("memberVO", memberVO); // 在session內做已經登入過的標識
				res.sendRedirect(req.getContextPath()+"/front-end/member/index.jsp"); // 成功登入index.jsp
			}
		}
		
		
	}

}
