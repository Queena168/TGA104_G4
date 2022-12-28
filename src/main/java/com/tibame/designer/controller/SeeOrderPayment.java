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

@WebServlet("/seeOrderPayment")
public class SeeOrderPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("list");
		String strorderNo = req.getParameter("orderNo");
		Integer orderNo = null;
		try {
			orderNo = Integer.valueOf(strorderNo);
		} catch (Exception e) {
			System.out.println("updateOrderPhase之orderNo為空值");
		}

		DesignerOrderPhaseService designerOrderPhaseService = new DesignerOrderPhaseService();
		List<DesignerOrderPhaseVO> list = designerOrderPhaseService.getOrderPhase(orderNo);
		//System.out.println(list.toString());
		session.setAttribute("list", list);
		String url = "/front-end/designer/UpdatelistOneOrderPhase.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
