package com.tibame.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.cart.model.ShopProductService;
import com.tibame.designer.model.DesignerVO;
import com.tibame.designer.service.DesignerService;
import com.tibame.portfolio.model.PortfolioService;
import com.tibame.portfolio.model.PortfolioVO;


@WebServlet("/front-end/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Index() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		PortfolioService portfolioSvc = new PortfolioService();
		DesignerService designerSvc = new DesignerService();
		ShopProductService shopProductService = new ShopProductService();
		
		List<DesignerVO> designerList =  designerSvc.getAll();
		List<PortfolioVO> portfolioList = portfolioSvc.getAll();
		List<Map<String, Object>> productList = shopProductService.getAll();
		
		req.setAttribute("designerList", designerList);
		req.setAttribute("portfolioList", portfolioList);
		req.setAttribute("productList", productList);
		
		RequestDispatcher successView = req.getRequestDispatcher("/front-end/index.jsp");
		successView.forward(req, res);
		
	}

}
