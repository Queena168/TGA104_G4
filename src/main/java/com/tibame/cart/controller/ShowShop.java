package com.tibame.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.cart.model.Cart;
import com.tibame.cart.model.ShopProductService;


@WebServlet("/ShowShop")
public class ShowShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@Autowired
//	private ShopProductService shopProductService;
	
	//外部Server
//	@Override
//	 public void init() throws ServletException {
//	  ServletContext application = this.getServletContext();
//	  ApplicationContext context = (ApplicationContext)
//	    application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//	  this.shopProductService = context.getBean("shopProductService", ShopProductService.class);
//	 }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		ShopProductService shopProductService = new ShopProductService();
		List<Map<String, Object>> list = shopProductService.getAll();
		
		req.setAttribute("list", list); // 顯示所有商品
		
		HttpSession session = req.getSession();
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list"); 
		if(cart_list != null){
			req.setAttribute("cart_list", cart_list); // 一般購物車
		}
		
		String url = "/front-end/cart/shopProduct.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
