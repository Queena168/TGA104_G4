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

import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderService;

@WebServlet("/DesignerOrder")
public class DesignerOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session = req.getSession();
		session.getAttribute("designerVO");
		Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
		DesignerOrderService designerOrderScv = new DesignerOrderService();
		List<DesignerOrderVO> list = designerOrderScv.getAllMyOrder(designerNo);
		session.setAttribute("list", list);
		String url = "/front-end/designer/orderManage.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		successView.forward(req, res);

	}

}
