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

@WebServlet("/OrderPageBtnController")
public class OrderPageBtnController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		

		// 查看設計師所有訂單

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session = req.getSession();
		session.getAttribute("designerVO");
		String action = req.getParameter("action");
		// ================================================================================
		//顯示所有訂單
		if ("showMyOrder".equals(action)) {
			//Integer	designerNo = Integer.valueOf(req.getParameter("designerNo"));
			String str = req.getParameter("designerNo").trim();
			Integer designerNo=null;
			designerNo=Integer.valueOf(str);
			DesignerOrderService	designerOrderScv = new DesignerOrderService();
			List<DesignerOrderVO> list = designerOrderScv.getAllMyOrder(designerNo);
			session.setAttribute("list", list);
			String url = "/front-end/designer/orderManage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}

		// ===============================================================================
		// 如結案狀態為未結案則取得設計師進行中訂單
		if ("showIngOrder".equals(action)) {
			//Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
			String str = req.getParameter("designerNo").trim();
			Integer designerNo=null;
			designerNo=Integer.valueOf(str);
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			List<DesignerOrderVO> list = designerOrderScv.getAllMyINGOrder(designerNo);
			session.setAttribute("list", list);
			String url = "/front-end/designer/orderManage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}

		// ================================================================================
		// 如結案狀態為結案則取得設計師結案訂單
		if ("showFinishOrder".equals(action)) {
			//System.out.println("有進來");
			//Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
			String str = req.getParameter("designerNo").trim();
			//System.out.println("str:"+str);
			Integer designerNo=null;
			designerNo=Integer.valueOf(str);
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			List<DesignerOrderVO> list = designerOrderScv.getAllMyisFinishOrder(designerNo);
			session.setAttribute("list", list);
			String url = "/front-end/designer/orderManage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		
		
	
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
	}

}
