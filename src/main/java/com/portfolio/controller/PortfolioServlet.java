package com.portfolio.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.model.PortfolioService;
import com.portfolio.model.PortfolioVO;

@WebServlet("/back-end/designer_portfolio/PortfolioServlet")
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
		res.setContentType("image/jpg, image/png, image/jpeg, image/gif");
		
		if("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
			
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
		
	}

}
