package com.designerOrder.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designerOrder.Service.DesignerOrderService;
import com.designerOrder.model.DesignerOrderVO;

@WebServlet("/AddQuotation")
public class AddQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("designerOrderVO");
		String action =  req.getParameter("action");
			
		if("insertquotation".equals(action)) {
			
			String str = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			
			
			//PrintWriter out = res.getWriter()n
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			req.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/designer/addQuotation.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		//================================================================
		
		
		
		if("updatequotation".equals(action)) {
			
			String str = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			
			
			//PrintWriter out = res.getWriter()n
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			req.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/designer/addQuotation.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
