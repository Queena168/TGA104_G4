package com.admin.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.AdminService;
import com.admin.model.AdminVO;

@WebServlet("/AdminServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		res.setContentType("image/jpg, image/png, image/jpeg, image/gif");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("adminNo");
				if (str == null || (str.trim().length() == 0)) {
					errorMsgs.add("請輸入管理員編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/admin/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer adminNo = null;
				try {
					adminNo = Integer.valueOf(str);
				} catch (Exception e){
					errorMsgs.add("管理員編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/admin/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				AdminService adminSvc = new AdminService();
				AdminVO adminVO = adminSvc.getOneAdmin(adminNo);
				if(adminVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/admin/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adminVO", adminVO); // 資料庫取出的AdminVO物件,存入req
				String url = "/back-end/admin/listOneAdmin.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllAdmin.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer adminNo = Integer.valueOf(req.getParameter("adminNo"));
				
				/***************************2.開始查詢資料****************************************/
				AdminService adminSvc = new AdminService();
				AdminVO adminVO = adminSvc.getOneAdmin(adminNo);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("adminVO", adminVO); // 資料庫取出的AdminVO物件,存入req
				String url = "/back-end/admin/updateAdmin.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			
		} 
		
		if ("update".equals(action)) { // 來自updateAdmin.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer adminNo = Integer.valueOf(req.getParameter("adminNo").trim());
				
				String adminEmail = req.getParameter("adminEmail");
				
				String adminPassword = req.getParameter("adminPassword");
				String adminPasswordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (adminPassword == null || adminPassword.trim().length() == 0) {
					errorMsgs.add("管理員密碼: 請勿空白");
				} else if(!adminPassword.trim().matches(adminPasswordReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				 
				String adminName = req.getParameter("adminName");
//				String adminNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (adminName == null || adminName.trim().length() == 0) {
//					errorMsgs.add("管理員姓名: 請勿空白");
//				} else if(!adminName.trim().matches(adminNameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
				
				byte[] adminPic = req.getPart("adminPic").getInputStream().readAllBytes();
				if(adminPic.length==0) {
					adminPic=null;
				}
			
				String adminPrivilege = req.getParameter("adminPrivilege");
//		        String adminPrivilegeReg = "^[(0-9)]{1}$";
//				if (adminPrivilege == null || adminPrivilege.trim().length() == 0) {
//					errorMsgs.add("管理員權限: 請勿空白");
//				} else if (!adminPrivilege.trim().matches(adminPrivilegeReg)) { // 以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("管理員權限: 只能是數字, 且長度必需在1");
//				}
				
				// String createTime轉換成TimeStamp格式
//				Timetamp createTime = Timestamp.valueOf(req.getParameter("createTime"));
			
//				Integer uploader = Integer.valueOf(req.getParameter("uploader").trim());
				
				AdminVO adminVO = new AdminVO();
				adminVO.setAdminNo(adminNo);
				adminVO.setAdminEmail(adminEmail);
				adminVO.setAdminPassword(adminPassword);
				adminVO.setAdminName(adminName);
				adminVO.setAdminPic(adminPic);
				adminVO.setAdminPrivilege(adminPrivilege);
//				adminVO.setCreateTime(createTime);
//				adminVO.setUploader(uploader);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adminVO", adminVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/admin/updateAdmin.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				AdminService adminSvc = new AdminService();
				adminVO = adminSvc.updateAdmin (adminNo, adminEmail, adminPassword, adminName, adminPic, adminPrivilege);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("adminVO", adminVO); // 資料庫取出的AdminVO物件,存入req
				String url = "/back-end/admin/listAllAdmin.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);		
		}
		
		if ("insert".equals(action)) { // 來自addAdmin.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				
				String adminEmail = req.getParameter("adminEmail");
				
				String adminPassword = req.getParameter("adminPassword");
				String adminPasswordReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (adminPassword == null || adminPassword.trim().length() == 0) {
					errorMsgs.add("管理員密碼: 請勿空白");
				} else if(!adminPassword.trim().matches(adminPasswordReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員密碼: 只能是英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				 
				String adminName = req.getParameter("adminName");
				String adminNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (adminName == null || adminName.trim().length() == 0) {
					errorMsgs.add("管理員姓名: 請勿空白");
				} else if(!adminName.trim().matches(adminNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				byte[] adminPic = req.getPart("adminPic").getInputStream().readAllBytes();
				if(adminPic.length==0) {
					adminPic=null;
				}
			
				String adminPrivilege = req.getParameter("adminPrivilege");
	//	        String adminPrivilegeReg = "^[(0-9)]{1}$";
	//			if (adminPrivilege == null || adminPrivilege.trim().length() == 0) {
	//				errorMsgs.add("管理員權限: 請勿空白");
	//			} else if (!adminPrivilege.trim().matches(adminPrivilegeReg)) { // 以下練習正則(規)表示式(regular-expression)
	//				errorMsgs.add("管理員權限: 只能是數字, 且長度必需在1");
	//			}
				
	
				Integer uploader = Integer.valueOf(req.getParameter("uploader").trim());
				
				AdminVO adminVO = new AdminVO();	
				adminVO.setAdminEmail(adminEmail);
				adminVO.setAdminPassword(adminPassword);
				adminVO.setAdminName(adminName);
				adminVO.setAdminPic(adminPic);
				adminVO.setAdminPrivilege(adminPrivilege);
				adminVO.setUploader(uploader);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("adminVO", adminVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/admin/addAdmin.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
			
				/***************************2.開始修改資料*****************************************/
				AdminService adminSvc = new AdminService();
				adminVO = adminSvc.addAdmin(adminEmail, adminPassword, adminName, adminPic, adminPrivilege, uploader);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				String url = "/back-end/admin/listAllAdmin.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);		
		}
		
		if ("delete".equals(action)) { // 來自listAllAdmin.jsp
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數***************************************/
			Integer adminNo = Integer.valueOf(req.getParameter("adminNo"));
			
			/***************************2.開始刪除資料***************************************/
			AdminService adminSvc = new AdminService();
			adminSvc.deleteAdmin(adminNo);
			
			/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
			String url = "/back-end/admin/listAllAdmin.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);		
			
			
		}
		
	}

}
