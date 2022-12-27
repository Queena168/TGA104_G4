package com.tibame.designer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.service.DesignerOrderPhaseService;

@WebServlet("/SendOrderPayment")
public class SendOrderPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("list");
		String paymentStatus = req.getParameter("paymentStatus");
		String strorderNo = req.getParameter("orderNo");
		//System.out.println("strorderNo"+strorderNo);
		Integer orderNo=null;
		orderNo = Integer.valueOf(strorderNo);
		DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
		designerOrderPhaseSvc.InsertDesignerOrderPhasePayment(orderNo, paymentStatus);
		List <DesignerOrderPhaseVO> list = designerOrderPhaseSvc.getOrderPhase(orderNo);
		session.setAttribute("list", list);
		String url = "/front-end/designer/listOneOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res); 
		
	}

}
