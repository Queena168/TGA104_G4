package com.tibame.portfolio.controller;

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

import com.tibame.portfolio.model.PortfolioService;
import com.tibame.portfolio.model.PortfolioVO;

@WebServlet(urlPatterns = { "/back-end/designer_portfolio/PortfolioServlet",
		"/front-end/designer_protfolio/PortfolioListOne", "/front-end/designer_protfolio/PortfolioUpdate",
		"/front-end/designer_protfolio/UpdatedPortfolio", "/front-end/designer_protfolio/PortfolioByNo",
		"/front-end/designer_protfolio/InsertPortfolio" })
@MultipartConfig()
public class PortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PortfolioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String portfolioNo11 = req.getParameter("portfolioNo");
//		res.setContentType("image/jpg, image/png, image/jpeg, image/gif");

		if ("getOne_For_Display".equals(action)) { // 來自back-end/designer_portfolio/listAllPortfolio.jsp點擊明細的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 **********************/
			String str = req.getParameter("portfolioNo");
			Integer portfolioNo = Integer.valueOf(str);

			/*************************** 2.查詢資料 *****************************************/
			PortfolioService portfolioSvc = new PortfolioService();
			PortfolioVO portfolioVoSelect = portfolioSvc.getOnePortfolio(portfolioNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("portfolioVoSelect", portfolioVoSelect); // 資料庫取出的PortfolioVO物件,存入req
			String url = "/back-end/designer_portfolio/listOnePortfolio.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		if ("portfolio_GetOne".equals(action)) { // 來自/front-end/designer_protfolio/PortfolioListOne.jsp點擊明細的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 **********************/
			String str = req.getParameter("portfolioNo");
			Integer portfolioNo = Integer.valueOf(str);

			/*************************** 2.查詢資料 *****************************************/
			PortfolioService portfolioSvc = new PortfolioService();
			PortfolioVO portfolioVoSelect = portfolioSvc.getOnePortfolio(portfolioNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("portfolioVoSelect", portfolioVoSelect); // 資料庫取出的PortfolioVO物件,存入req
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/portfolioListOne.jsp");
			successView.forward(req, res);

		}

		if ("inputPortfolioName_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			// 檢查參數是否為空白
			String str = req.getParameter("portfolioName");
			if (str == null || (str.trim().length() == 0)) {
				errorMsgs.add("輸入欄位不可空白");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer_protfolio/portfolioSelect.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			str = "%" + str + "%"; // 正確撈出資料
			System.out.println("str:" + str);
			/*************************** 2.開始查詢資料 *****************************************/
			PortfolioService portfolioSelectSvc = new PortfolioService();
			List<PortfolioVO> selectlist = portfolioSelectSvc.selectportfolio(str);
			System.out.println("selectlist:" + selectlist);
			if (selectlist == null) {
				errorMsgs.add("查無符合資料 請重新輸入");
			}
			System.out.println("errorMsgs:" + errorMsgs);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer_protfolio/portfolioSelect.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("selectlist", selectlist);
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/portfolioSelect.jsp");
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自portfolioListOne修改請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 ****************************************/
			Integer portfolioNo = Integer.valueOf(req.getParameter("portfolioNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			PortfolioService updateSvc = new PortfolioService();
			PortfolioVO portfolioUpdate = updateSvc.getOnePortfolio(portfolioNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("portfolioUpdate", portfolioUpdate);
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/portfolioUpdate.jsp");
			successView.forward(req, res);

		}

		if ("update".equals(action)) { // 來自portfolioUpdate.jsp的修改請求
			System.out.println("進來update action");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 ****************************************/
			Integer portfolioNo = Integer.valueOf(req.getParameter("portfolioNo"));

			String portfolioName = req.getParameter("portfolioName");
			if (portfolioName == null || portfolioName.trim().length() == 0) {
				errorMsgs.add("作品名稱請勿空白");
			}

			Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));

			byte[] portfolioPic1 = req.getPart("portfolioPic1").getInputStream().readAllBytes();
			if (portfolioPic1.length == 0) {
				portfolioPic1 = null;
			}
			byte[] portfolioPic2 = req.getPart("portfolioPic2").getInputStream().readAllBytes();
			if (portfolioPic2.length == 0) {
				portfolioPic2 = null;
			}
			byte[] portfolioPic3 = req.getPart("portfolioPic3").getInputStream().readAllBytes();
			if (portfolioPic3.length == 0) {
				portfolioPic3 = null;
			}
			byte[] portfolioPic4 = req.getPart("portfolioPic4").getInputStream().readAllBytes();
			if (portfolioPic4.length == 0) {
				portfolioPic4 = null;
			}

			String description = req.getParameter("description");
			if (description == null || description.trim().length() == 0) {
				errorMsgs.add("作品內文請勿空白");
			}

			String houseAge = req.getParameter("houseAge");
			if (description == null || description.trim().length() == 0) {
				errorMsgs.add("屋齡請勿空白");
			}

			String houseSize = req.getParameter("houseSize");
			if (houseSize == null || houseSize.trim().length() == 0) {
				errorMsgs.add("房屋坪數請勿空白");
			}

			String househouseArea = req.getParameter("houseArea");
			if (househouseArea == null || househouseArea.trim().length() == 0) {
				errorMsgs.add("房屋區域請勿空白");
			}

			PortfolioVO updatePortfolioVO = new PortfolioVO();
			updatePortfolioVO.setPortfolioNo(portfolioNo);
			updatePortfolioVO.setPortfolioName(portfolioName);
			updatePortfolioVO.setDesignerNo(designerNo);
			updatePortfolioVO.setPortfolioPic1(portfolioPic1);
			updatePortfolioVO.setPortfolioPic2(portfolioPic2);
			updatePortfolioVO.setPortfolioPic3(portfolioPic3);
			updatePortfolioVO.setPortfolioPic4(portfolioPic4);
			updatePortfolioVO.setDescription(description);
			updatePortfolioVO.setHouseAge(houseAge);
			updatePortfolioVO.setHouseSize(houseSize);
			updatePortfolioVO.setHouseArea(househouseArea);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("portfolioUpdate", updatePortfolioVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer_protfolio/portfolioUpdate.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			PortfolioService portfolioSvc = new PortfolioService();
			updatePortfolioVO = portfolioSvc.updatePortfolio(portfolioNo, portfolioName, designerNo, portfolioPic1,
					portfolioPic2, portfolioPic3, portfolioPic4, description, houseAge, houseSize, househouseArea);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("portfolioVoSelect", updatePortfolioVO);
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/portfolioListOne.jsp");
			successView.forward(req, res);

		}

		if ("portfolio_GetByNo".equals(action)) { // 來自/front-end/designer_protfolio/index.jsp點擊設計師資料的請求

			/*************************** 1.接收請求參數 **********************/
			String str = req.getParameter("designerNo");
			Integer designerNo = Integer.valueOf(str);
			
			/*************************** 2.查詢資料 *****************************************/
			PortfolioService portfolioSvc = new PortfolioService();
			List<PortfolioVO> portfolioListByNo = portfolioSvc.getAllbyDesign(designerNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("portfolioListByNo", portfolioListByNo);
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/designerPorfile.jsp");
			successView.forward(req, res);

		}

		if ("insert".equals(action)) {
			List<String> insertErrorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("insertErrorMsgs", insertErrorMsgs);
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String portfolioName = req.getParameter("portfolioName");
			if (portfolioName == null || portfolioName.trim().length() == 0) {
				insertErrorMsgs.add("作品名稱請勿空白");
			}

			Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));

			byte[] portfolioPic1 = req.getPart("portfolioPic1").getInputStream().readAllBytes();
			if (portfolioPic1.length == 0) {
				portfolioPic1 = null;
			}
			byte[] portfolioPic2 = req.getPart("portfolioPic2").getInputStream().readAllBytes();
			if (portfolioPic2.length == 0) {
				portfolioPic2 = null;
			}
			byte[] portfolioPic3 = req.getPart("portfolioPic3").getInputStream().readAllBytes();
			if (portfolioPic3.length == 0) {
				portfolioPic3 = null;
			}
			byte[] portfolioPic4 = req.getPart("portfolioPic4").getInputStream().readAllBytes();
			if (portfolioPic4.length == 0) {
				portfolioPic4 = null;
			}

			String description = req.getParameter("description");
			if (description == null || description.trim().length() == 0) {
				insertErrorMsgs.add("作品內文請勿空白");
			}

			String houseAge = req.getParameter("houseAge");
			if (description == null || description.trim().length() == 0) {
				insertErrorMsgs.add("房屋屋齡請勿空白");
			}

			String houseSize = req.getParameter("houseSize");
			if (houseSize == null || houseSize.trim().length() == 0) {
				insertErrorMsgs.add("房屋坪數請勿空白");
			}

			String househouseArea = req.getParameter("houseArea");
			if (househouseArea == null || househouseArea.trim().length() == 0) {
				insertErrorMsgs.add("房屋區域請勿空白");
			}

			PortfolioVO insertPortfolioVO = new PortfolioVO();
			insertPortfolioVO.setPortfolioName(portfolioName);
			insertPortfolioVO.setDesignerNo(designerNo);
			insertPortfolioVO.setPortfolioPic1(portfolioPic1);
			insertPortfolioVO.setPortfolioPic2(portfolioPic2);
			insertPortfolioVO.setPortfolioPic3(portfolioPic3);
			insertPortfolioVO.setPortfolioPic4(portfolioPic4);
			insertPortfolioVO.setDescription(description);
			insertPortfolioVO.setHouseAge(houseAge);
			insertPortfolioVO.setHouseSize(houseSize);
			insertPortfolioVO.setHouseArea(househouseArea);

			if (!insertErrorMsgs.isEmpty()) {
				req.setAttribute("insertPortfolioVO", insertPortfolioVO); // 含有輸入格式錯誤的manager_VO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/designer_protfolio/designerPorfile.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始新增資料 *****************************************/
			PortfolioService portfolioSvc = new PortfolioService();
			insertPortfolioVO = portfolioSvc.addPortfolio(portfolioName, designerNo, portfolioPic1, 
														  portfolioPic2, portfolioPic3, portfolioPic4, description, 
														  houseAge, houseSize, househouseArea);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			RequestDispatcher successView = req
					.getRequestDispatcher("/front-end/designer_protfolio/insertPortfolio.jsp");
			successView.forward(req, res);
			
		}

	}

}
