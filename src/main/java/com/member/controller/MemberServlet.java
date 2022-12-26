package com.member.controller;

import java.io.IOException;
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

import com.member.model.MailService;
import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet(value = { "/front-end/member/MemberServlet", "/front-end/member/MemberSignup" })
@MultipartConfig
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("portfolio_GetByNo".equals(action)) { // 來自/front-end/member/index.jsp點擊設計師資料的請求

			/*************************** 1.接收請求參數 **********************/
			String str = req.getParameter("memberNo");
			Integer memberNo = Integer.valueOf(str);
			/*************************** 2.查詢資料 *****************************************/
			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getOneMember(memberNo);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/memberPorfile.jsp");
			successView.forward(req, res);
		}

		if ("memberSignup".equals(action)) { // 來自/front-end/member/signup.jsp 點擊註冊的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String memberAccount = req.getParameter("memberAccount");
			if (memberAccount == null || memberAccount.trim().length() == 0) {
				errorMsgs.add("會員帳號(信箱) 請勿空白");
			}
			MemberService checkUsed = new MemberService();
			Boolean used = checkUsed.accountUsed(memberAccount);
			if (used == true) {
				errorMsgs.add("帳號已存在");
			}

//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/signup.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷
//			}

			String memberPassword = req.getParameter("memberPassword");
			String memberPasswordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memberPassword == null || memberPassword.trim().length() == 0) {
				errorMsgs.add("會員密碼 請勿空白");
			} else if (!memberPassword.trim().matches(memberPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
			}
			String confirmedPassword = req.getParameter("confirmedPassword");
			if (!confirmedPassword.equals(memberPassword)) {
				errorMsgs.add("密碼與確認密碼不一致 請重新輸入");
			}
			String memberName = req.getParameter("memberName");
			if (memberName == null || memberName.trim().length() == 0) {
				errorMsgs.add("會員名稱 請勿空白");
			}
			String nickName = req.getParameter("nickName");
			if (nickName == null || nickName.trim().length() == 0) {
				errorMsgs.add("會員暱稱 請勿空白");
			}
			String gender = req.getParameter("gender");
			if (gender == null || gender.trim().length() == 0) {
				errorMsgs.add("會員性別 請勿空白");
			}
			String strBirthDate = req.getParameter("birthDate");
			java.sql.Date birthDate = java.sql.Date.valueOf(strBirthDate); // string to java.sql.Date
			
			String valistr = req.getParameter("valistr");
			HttpSession session = req.getSession();
	        session.getAttribute(valistr);
//			String valistrin = (String) session.getAttribute(valistr);
			String valistrin = req.getParameter("valistr");
//			System.out.println("Servlet valistr: " + valistr);
//			System.out.println("Servlet valistrin: " + valistrin);
			
			if (!valistr.equals(valistrin)) {
				errorMsgs.add("驗證碼錯誤 請重新輸入");
			}
			
			Boolean activaction = false;

			MemberVO memberVO = new MemberVO();
			memberVO.setMemberAccount(memberAccount);
			memberVO.setMemberPassword(memberPassword);
			memberVO.setMemberName(memberName);
			memberVO.setNickName(nickName);
			memberVO.setGender(gender);
			memberVO.setBirthDate(birthDate);
			memberVO.setActivaction(activaction);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/member/signup.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			MemberService memberSvc = new MemberService();
			memberVO = memberSvc.addMember(memberAccount, memberPassword, memberName, nickName, gender, birthDate,
					activaction);
			MailService mail = new MailService();
			String subject = "【會員註冊通知信】";
			String messageText = "<h2>Hello! " + memberName + "</h2>" +"<br> <p> 請點擊以下連結啟用帳號</p>" + 
					 "<a href='http://localhost:8081/TGA104_G4/front-end/index.html'>MatDesign首頁</a><br>";
			mail.sendMail(memberAccount, subject, messageText);
			
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/signupSuccess.jsp");
			successView.forward(req, res);
		}

	}

}
