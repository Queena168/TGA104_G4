package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.model.Cart;
import com.cart.model.User;
import com.cart.model.UserJDBCDAO;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp"); //login.jsp
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = res.getWriter()){
			String email = req.getParameter("login-email"); //from login.jsp name=login-email
			String password = req.getParameter("login-password"); //from login.jsp name=login-password
			
			UserJDBCDAO userJDBCDAO = new UserJDBCDAO();
			User user = userJDBCDAO.userLogin(email, password); 
			if(user != null ) {
				req.getSession().setAttribute("auth", user);
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp"); // cart.jsp 登入後導到購物區
			}else {
				out.println("user login failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		}
    }
