package com.chat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/back-end/chattest/intochatServlet")
public class intochatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public intochatServlet() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("adminEmail");
		
		req.setAttribute("userName", userName);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/back-end/chattest/chat.jsp");
		dispatcher.forward(req, res);
	
	}

}
