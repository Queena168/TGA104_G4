package com.tibame.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.cart.model.Cart;
import com.tibame.cart.model.ShopProductService;


@WebServlet("/ShowShop")
public class ShowShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ShopProductService shopProductService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<Map<String, Object>> list = shopProductService.getAll();
		
		req.setAttribute("list", list);
		
		HttpSession session = req.getSession();
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list"); 
		if(cart_list != null){
			req.setAttribute("cart_list", cart_list);
		}
		
		String url = "/front-end/cart/shopProduct.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
