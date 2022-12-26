package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
//@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try(PrintWriter out = res.getWriter()){
			if(req.getSession().getAttribute("auth")!=null) {
				req.getSession().removeAttribute("auth");
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp"); // login.jsp
			}else {
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
			}

		}
	}
}
