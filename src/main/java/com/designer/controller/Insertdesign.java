package com.designer.controller;

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
import javax.servlet.http.Part;

import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/insertdesign")
public class Insertdesign extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//設計師註冊controller
		
		System.out.println("done0.0========================================");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		// res.setContentType("image/gif");
		
		String action = req.getParameter("action");

		// =======================================================

		if ("insertdesigner".equals(action)) { // 來自addDesigner.jsp的請求
			System.out.println("done0.1========================================");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String designerAccount = req.getParameter("designerAccount").trim();
			DesignerService designerSvc = new DesignerService();
			List<DesignerVO> designerVOlist = designerSvc.getAll();
			for (int i = 0; i < designerVOlist.size(); i++) {
				if (designerVOlist.get(i).getDesignerAccount().equals(designerAccount)) {
					System.out.println(designerVOlist.get(i).getDesignerAccount().equals(designerAccount));
					errorMsgs.add("設計師帳號已重複");
				}
			}
			if (designerAccount == null || designerAccount.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			}

			String designerPassword = req.getParameter("designerPassword").trim();
			if (designerPassword == null || designerPassword.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");

			}

			String designerName = req.getParameter("designerName").trim();
			String designerNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (designerName == null || designerName.trim().length() == 0) {
				errorMsgs.add("設計師姓名: 請勿空白");
			} else if (!designerName.trim().matches(designerNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("設計師姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String designerCompany = req.getParameter("designerCompany").trim();
			if (designerCompany == null || designerCompany.trim().length() == 0) {
				errorMsgs.add("公司請勿空白");
			}

			String phone = req.getParameter("phone").trim();
			String phoneReg = "^[0][9][0-9]{8}$";
			if (phone == null || phone.trim().length() == 0) {
				errorMsgs.add("請勿空白，請填寫手機號碼，以利我們團隊方便聯繫到您");
			} else if (!phone.trim().matches(phoneReg)) {
				errorMsgs.add("請填寫正確手機號碼格式");
			}

			String designerDetail = req.getParameter("designerDetail").trim();
			if (designerDetail == null || designerDetail.trim().length() == 0) {
				errorMsgs.add("請填寫您的簡介，好讓客戶對您有好感覺");
			}

			Part part = req.getPart("designerPic");
			InputStream in = part.getInputStream();
			byte[] designerPic = new byte[in.available()];
			in.read(designerPic);
			System.out.println(in.read(designerPic));
			in.close();

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/designer/addDesigner.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			designerSvc.addDesignerinfo(designerAccount, designerPassword, designerName, designerCompany, designerPic,
					phone, designerDetail);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

			PrintWriter out = res.getWriter();
			out.print("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
					+ "/front-end/designer/index.jsp'>");// redirects after 1 seconds
//					out.print("<script> alert('註冊資料已送出，請等待管理員審核與通知!');</script>");	
			res.getWriter().print("<script>alert('註冊資料已送出，請等待管理員審核與通知!');</script>");
			// res.setHeader("refresh", "1;URL=" + req.getContextPath() +
			// "/front-end/designer/index.jsp");
			// out.print("<script
			// language='javascript'>alert('註冊資料已送出，請等待管理員審核與通知!')</script>");
//					//System.out.println("有直行到=========================3");// 成功轉交 listOneDesigner.jsp
			return;
		}

	}

}
