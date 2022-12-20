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

@WebServlet("/DesignerQuotationController")
public class DesignerQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("designerVO");
		String action =  req.getParameter("action");
		
		//製作報價單	
		
//		if("insertquotation".equals(action)) {
//			Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
//			//PrintWriter out = res.getWriter()n
//			DesignerOrderService designerOrderScv=new DesignerOrderService();
//			List<DesignerOrderVO> list= designerOrderScv.getAllMyQuotation(designerNo);
//			//System.out.println(list);
//			session.setAttribute("list", list);
//			String url = "/front-end/designer/addQuotatio.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
//			successView.forward(req, res);		
//		}
		
		
		
		Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
		//PrintWriter out = res.getWriter();
		DesignerOrderService designerOrderScv=new DesignerOrderService();
		List<DesignerOrderVO> list= designerOrderScv.getAllMyQuotation(designerNo);
		//System.out.println(list);
		session.setAttribute("list", list);
		String url = "/front-end/designer/quotationManage.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		successView.forward(req, res);
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
