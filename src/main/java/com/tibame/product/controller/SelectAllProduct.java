package com.tibame.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.product.model.ProductService;
import com.tibame.product.model.ProductVO;


@WebServlet("/SelectAllProduct")
public class SelectAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@Autowired
//	ProductService productService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ProductService productService = new ProductService();
		List<ProductVO> list = productService.getAll();
		
		req.setAttribute("list", list);
		
		String url = "/back-end/product/listAllProduct.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listAllProductType.jsp
		successView.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
