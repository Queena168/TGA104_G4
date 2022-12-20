package com.designer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designer.model.DesignerOrderVO;
import com.designer.service.DesignerOrderService;

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
		String action = req.getParameter("action");
		Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
		//PrintWriter out = res.getWriter();
		DesignerOrderService designerOrderScv=new DesignerOrderService();
		List<DesignerOrderVO> list= designerOrderScv.getAllMyOrder(designerNo);
		//System.out.println(list);
		session.setAttribute("list", list);
		String url = "/front-end/designer/orderManage.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		successView.forward(req, res);

		//================================================================================
		//查看設計師所有訂單
		if("showMyOrder".equals(action)) {
			designerNo = Integer.valueOf(req.getParameter("designerNo"));
			//PrintWriter out = res.getWriter();
			designerOrderScv=new DesignerOrderService();
			list= designerOrderScv.getAllMyOrder(designerNo);
			//System.out.println(list);
			session.setAttribute("list", list);
			url = "/front-end/designer/orderManage.jsp";
			successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
	
		//===============================================================================
		//如結案狀態為未結案則取得設計師進行中訂單，如結案狀態為結案則取得設計師結案訂單
		if("showFinishOrder".equals(action)) {
			designerNo = Integer.valueOf(req.getParameter("designerNo"));
			//PrintWriter out = res.getWriter();
			designerOrderScv=new DesignerOrderService();
			list= designerOrderScv.getAllMyisFinishOrder(designerNo);
			//System.out.println(list);
			session.setAttribute("list", list);
			url = "/front-end/designer/orderManage.jsp";
			successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}

	}

}
