package com.tibame.producttype.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.producttype.model.ProductTypeService;
import com.tibame.producttype.model.ProductTypeVO;

@WebServlet("/back-end/producttype/SelectAllProductType")
public class SelectAllProductType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ProductTypeService productTypeService = new ProductTypeService();
		List<ProductTypeVO> list = productTypeService.getAll();
		
		req.setAttribute("list", list);
		
		String url = "/back-end/producttype/listAllProductType.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listAllProductType.jsp
		successView.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
