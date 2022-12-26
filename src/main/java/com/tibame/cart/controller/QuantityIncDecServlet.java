package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.cart.model.Cart;

/**
 * Servlet implementation class QuantityIncDecServlet
 */

public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = res.getWriter();){
			String action = req.getParameter("action");
			Integer id = Integer.parseInt(req.getParameter("id"));
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>)req.getSession().getAttribute("cart_list");
			
			if(action != null && id>=1) {
				if(action.equals("inc")) {
					for(Cart c:cart_list) {
						if(c.getProductNo() == id) {
							Integer quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							res.sendRedirect("/TGA104_G4/ShowCart"); // cart.jsp
						}
					}
				}
				
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getProductNo() == id && c.getQuantity()>1) {
							Integer quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}
					res.sendRedirect("/TGA104_G4/ShowCart"); // cart.jsp
				}
			}else {
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp"); // cart.jsp
			}
			
		}
	}

}
