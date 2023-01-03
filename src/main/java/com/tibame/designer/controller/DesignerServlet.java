package com.tibame.designer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tibame.designer.model.DesignerExpertiseVO;
import com.tibame.designer.model.DesignerVO;
import com.tibame.designer.service.DesignerExpertiseService;
import com.tibame.designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/check")
public class DesignerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		String action = req.getParameter("action");
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

			Part part = req.getPart("designerPic");
			InputStream in = part.getInputStream();
			byte[] designerPic = new byte[in.available()];
			in.read(designerPic);
			in.read(designerPic);
			in.close();
			
			String  designerDetail = req.getParameter("designerDetail");

			/*************************** 2.開始修改資料 *****************************************/
			if ((in.read(designerPic)) == -1) {
				DesignerService designerSvc = new DesignerService();
				DesignerVO designerVO = designerSvc.updateDesignerNOPic(designerNo, designerAccount, designerPassword,
						designerName,
						designerCompany,designerDetail);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("designerVO", designerVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/front-end/designer/designerMainPage.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneDesigner.jsp
				successView.forward(req, res);

			} else {

				DesignerService designerSvc = new DesignerService();
				DesignerVO designerVO = designerSvc.updateDesigner(designerNo, designerAccount, designerPassword,
						designerName, designerCompany,
						designerPic,designerDetail);
				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("designerVO", designerVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/front-end/designer/updatedesignerINFO.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneDesigner.jsp
				successView.forward(req, res);
			}

		}

		// ====================================================================================
		if ("success".equals(action)) { 
			String strdesignerNo = req.getParameter("designerNo").trim();
			Integer designerNo = Integer.valueOf(strdesignerNo);
            DesignerService designerSvc = new DesignerService();		
            designerSvc.updatedesignersuccess(designerNo);
            String url = "/back-end/designer/listAllDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllDesigner.jsp
			successView.forward(req, res);
		}
		
		if ("fail".equals(action)) { 
			String strdesignerNo = req.getParameter("designerNo").trim();
			Integer designerNo = Integer.valueOf(strdesignerNo);
	        DesignerService designerSvc = new DesignerService();		
	        designerSvc.updatedesignerfail(designerNo);
	        String url = "/back-end/designer/listAllDesigner.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllDesigner.jsp
			successView.forward(req, res);
		}

	}

}
