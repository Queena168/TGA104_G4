package com.tibame.productorder.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.productorder.model.ProductOrderService;
import com.tibame.productorder.model.ProductOrderVO;



@WebServlet("/BackendSelectAllOrder")
public class BackendSelectAllOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductOrderService productOrderService; 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//	 	ProductOrderService productOrderService = new ProductOrderService();
	 	List<ProductOrderVO> list = productOrderService.getAll();
	 	req.setAttribute("list", list);
		String url = "/back-end/productOrder/listAllProductOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listAllProductType.jsp
		successView.forward(req, res);	 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
