package com.designer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class DesignerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_designer_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("designerNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("designerNo", "請輸入設計師編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer/select_designer_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer designerNo = null;
			try {
				designerNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("designerNo", "設計師編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer/select_designer_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			DesignerService designerSvc = new DesignerService();
			DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);
			if (designerVO == null) {
				errorMsgs.put("designerNo", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer/select_designer_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/

			req.setAttribute("designerVO", designerVO); // 資料庫取出的empVO物件,存入req
			String url = "/front-end/designer/listOneDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllDesigner.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			DesignerService designerSvc = new DesignerService();
			DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/

			String param = "?designerNo=" + designerVO.getDesignerNo() + "&designerAccount="
					+ designerVO.getDesignerAccount() + "&designerPassword=" + designerVO.getDesignerPassword()
					+ "&designerName=" + designerVO.getDesignerName() + "&designerCompany="
					+ designerVO.getDesignerCompany() + "&designerPic=" + designerVO.getDesignerPic()
					+ "&approvalStatus=" + designerVO.getApprovalStatus() + "&approvalTime="
					+ designerVO.getApprovalTime() + "&approver=" + designerVO.getApprover() + "&designerStatus="
					+ designerVO.getDesignerStatus();
			String url = "/front-end/designer/update_designer_input.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_designer_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer designerNo = Integer.valueOf(req.getParameter("designerNo").trim());

			String designerAccount = req.getParameter("designerAccount");/* .trim() */
			if (designerAccount == null || designerAccount.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			}

			String designerName = req.getParameter("designerName").trim();
			String designerNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (designerName == null || designerName.trim().length() == 0) {
				errorMsgs.add("設計師姓名: 請勿空白");
			} else if (!designerName.trim().matches(designerNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("設計師姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			
			}
		

			String designerPassword = req.getParameter("designerPassword").trim();
			if (designerPassword == null || designerPassword.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			
			}

			String designerCompany = req.getParameter("designerCompany").trim();
			if (designerCompany == null || designerCompany.trim().length() == 0) {
				errorMsgs.add("公司請勿空白");
				
			}	
			
			
			     Part part= req.getPart("designerPic");			
				 InputStream in=part.getInputStream();
				 byte[] designerPic=new byte[in.available()];
				 in.read(designerPic);
				 //System.out.println(in.read(designerPic));
				 in.read(designerPic);
				 in.close();
				
			 
             
			
			

			/*************************** 2.開始修改資料 *****************************************/
			if((in.read(designerPic))==-1)	 {
				 DesignerService designerSvc = new DesignerService();
					DesignerVO designerVO = designerSvc.updateDesignerNOPic(designerNo, designerAccount, designerPassword,
							designerName, designerCompany/*,designerPic ,approvalStatus, approvalTime, approver, designerStatus */);
					

					/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
					req.setAttribute("designerVO", designerVO); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/front-end/designer/listOneDesigner.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneDesigner.jsp
					successView.forward(req, res);
					
			}else {
				
				 DesignerService designerSvc = new DesignerService();
					DesignerVO designerVO = designerSvc.updateDesigner(designerNo, designerAccount, designerPassword,
							designerName, designerCompany,designerPic /*,approvalStatus, approvalTime, approver, designerStatus */);					
				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("designerVO", designerVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/front-end/designer/listOneDesigner.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneDesigner.jsp
				successView.forward(req, res);
			}
		   

		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String designerName = req.getParameter("designerName");
			String designerNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (designerName == null || designerName.trim().length() == 0) {
				errorMsgs.put("designerName", "設計師姓名: 請勿空白");
			} else if (!designerName.trim().matches(designerNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("designerName", "設計師姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String designerAccount = req.getParameter("designerAccount").trim();
			if (designerAccount == null || designerAccount.trim().length() == 0) {
				errorMsgs.put("designerAccount", "帳號請勿空白");
			}

			String designerPassword = req.getParameter("designerPassword").trim();
			if (designerPassword == null || designerPassword.trim().length() == 0) {
				errorMsgs.put("designerPassword", "密碼請勿空白");
			}

			String designerCompany = req.getParameter("designerCompany").trim();
			if (designerCompany == null || designerCompany.trim().length() == 0) {
				errorMsgs.put("designerCompany", "公司請勿空白");
			}

			// byte[] designerPic =
			// req.getPart("designerPic").getInputStream().readAllBytes();
			
			 Part part= req.getPart("designerPic");
             InputStream in=part.getInputStream();
			 byte[] designerPic=new byte[in.available()];
			 in.read(designerPic);
			 in.close();

			String approvalStatus = req.getParameter("approvalStatus").trim();
			if (approvalStatus == null || approvalStatus.trim().length() == 0) {
				errorMsgs.put("approvalStatus", "狀態請勿空白");
			}

			java.sql.Date approvalTime = null;
			try {
				approvalTime = java.sql.Date.valueOf(req.getParameter("approvalTime").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("approvalTime", "請輸入日期");
			}

			Integer approver = Integer.valueOf(req.getParameter("approver").trim());

			if (approver == null) {
				errorMsgs.put("approver", "審核者請勿空白");
			}

			Boolean designerStatus = Boolean.parseBoolean(req.getParameter("designer").trim());

			/*************************** 2.開始新增資料 ***************************************/
			DesignerService designerSvc = new DesignerService();
			designerSvc.addDesigner(designerAccount, designerPassword, designerNameReg,
					designerCompany , designerPic , approvalStatus, approvalTime, approver, designerStatus);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/designer/listAllDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllDesigner.jsp
			successView.forward(req, res);
		}

		if ("insertdesigner".equals(action)) { // 來自addDesigner.jsp的請求
			System.out.println("請求收到================================");
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			System.out.println("有執行1--------------------------------------");
			String designerAccount = req.getParameter("designerAccount").trim();
			if (designerAccount == null || designerAccount.trim().length() == 0) {
				System.out.println("有執行2--------------------------------------");
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

			 Part part= req.getPart("designerPic");
             InputStream in=part.getInputStream();
			 byte[] designerPic=new byte[in.available()];
			 in.read(designerPic);
			 in.close();
			 
				String phone = req.getParameter("phone").trim();
				String phoneReg = "^[0][9][0-9]{8}$";
				if(phone == null || phone.trim().length() ==0) {
					errorMsgs.add("請勿空白，請填寫手機號碼，以利我們團隊方便聯繫到您");
				}else if(!phone.trim().matches(phoneReg)){
					errorMsgs.add("請填寫正確手機號碼格式");
				}
				
				String designerDetail=null;
				try {
					 designerDetail =req.getParameter("designerDetail").trim();
					
				}catch (NullPointerException e) {
					errorMsgs.add("請填寫您的簡介，好讓客戶對您有好感覺");
				}
			 
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/designer/addDesigner.jsp");
					failureView.forward(req, res);
					return;
				}	 
			

			/*************************** 2.開始新增資料 ***************************************/
			System.out.println("新增開始=================================================");
			DesignerService designerSvc = new DesignerService();
			designerSvc.addDesignerinfo(designerAccount, designerPassword, designerName,
					designerCompany , designerPic,phone, designerDetail);
			System.out.println("新增完成=================================================");
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			System.out.println("轉交開始=================================================");
			String url = "/front-end/designer/listAllDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllDesigner.jsp
			successView.forward(req, res);
			System.out.println("轉交結束=================================================");
		}

		if ("delete".equals(action)) { // 來自listAllDesigner.jsp

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));

			/*************************** 2.開始刪除資料 ***************************************/
			DesignerService designerSvc = new DesignerService();
			designerSvc.deleteDesigner(designerNo);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/designer/listAllDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}

}
