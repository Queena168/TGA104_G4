package com.tibame.designer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderService;

@WebServlet("/FinishedDesignerOrder")
public class FinishedDesignerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String strorderNo = req.getParameter("orderNo");
		Integer orderNo=null;
		orderNo = Integer.valueOf(strorderNo);
		DesignerOrderService designerOrderSvc = new DesignerOrderService();
		designerOrderSvc.updateFinishedStatus(orderNo);
		DesignerOrderVO designerOrderVO = designerOrderSvc.getDesignerOrder(orderNo);
		session.setAttribute("designerOrderVO", designerOrderVO);
		String url = "/front-end/designer/listOneOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res); 	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
