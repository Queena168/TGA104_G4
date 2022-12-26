package com.tibame.productorderdetail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.productorder.model.ProductOrderService;
import com.tibame.productorder.model.ProductOrderVO;

/**
 * Servlet implementation class UpdateOrderStatusServlet
 */
//@WebServlet("/UpdateOrderStatusServlet")
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("orderStatusUpdate".equals(action)) {
			Integer OrderNo = Integer.valueOf(req.getParameter("orderNo").trim());
			String OrderStatus = req.getParameter("orderStatus");
			ProductOrderVO productOrderVO = new ProductOrderVO();
			productOrderVO.setOrderNo(OrderNo);
			productOrderVO.setOrderStatus(OrderStatus);
			
			ProductOrderService productOrderService = new ProductOrderService();
			productOrderVO = productOrderService.updateOrderStatus(OrderNo, OrderStatus);
			
			req.setAttribute("productOrderVO", productOrderVO); // 資料庫update成功後,正確的productTypeVO物件,存入req
			String url = "/back-end/productOrder/listAllProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交selectProduct_page.jsp
			successView.forward(req, res);
		}
	}

}
