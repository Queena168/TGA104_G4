package com.tibame.productorderdetail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.cart.model.ShopProductService;
import com.tibame.productorder.model.ProductOrderService;
import com.tibame.productorder.model.ProductOrderVO;


@WebServlet("/UpdateOrderStatusServlet")
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@Autowired
//	private ProductOrderService productOrderService;	
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("orderStatusUpdate".equals(action)) {
			Integer OrderNo = Integer.valueOf(req.getParameter("orderNo").trim());
			String OrderStatus = req.getParameter("orderStatus");
			OrderStatus = "已發貨";
			ProductOrderVO productOrderVO = new ProductOrderVO();
			productOrderVO.setOrderNo(OrderNo);
			productOrderVO.setOrderStatus(OrderStatus);
			
			ProductOrderService productOrderService = new ProductOrderService();
			productOrderVO = productOrderService.updateOrderStatus(OrderNo, OrderStatus);
		 	List<ProductOrderVO> list = productOrderService.getAll();
		 	req.setAttribute("list", list);	
			String url = "/back-end/productOrder/listAllProductOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}
	}
}
