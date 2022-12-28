package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.cart.model.Cart;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = res.getWriter()){
			String id = req.getParameter("id");
			if(id!=null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart_list");
				if(cart_list != null) {
					for(Cart c:cart_list) {
						if(c.getProductNo() == Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					res.sendRedirect("ShowCart"); // cart.jsp
				}
			}else {
				res.sendRedirect("ShowCart"); // cart.jsp
			}
		}
	}

}
