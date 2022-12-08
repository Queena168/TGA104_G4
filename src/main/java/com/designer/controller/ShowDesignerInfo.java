package com.designer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/ShowDesignerInfo")
public class ShowDesignerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		String action = req.getParameter("action");
		System.out.println("done1=============================================");
		if ("designerinfo".equals(action)) {

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("designerNo");

			Integer designerNo = null;
			try {
				designerNo = Integer.valueOf(str);
				System.out.println(designerNo);
			} catch (Exception e) {
				
			}

			/*************************** 2.開始查詢資料 *****************************************/
			DesignerService designerSvc = new DesignerService();
			System.out.println("done1.5=====================================================");
			DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("designerVO", designerVO); // 資料庫取出的empVO物件,存入req
			System.out.println("done2===========================================");
			String url = "/front-end/designer/listOneDesignerINFO.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			System.out.println("done3=======================================");
			successView.forward(req, res);

		}

	}

}
