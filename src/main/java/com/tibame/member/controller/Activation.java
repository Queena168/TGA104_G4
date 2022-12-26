package com.tibame.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.member.model.MemberService;


@WebServlet("/front-end/Activation")
public class Activation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Activation() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
		Boolean activaction = true;
		
		MemberService memberSvc = new MemberService();
		memberSvc.updateActivaction(memberNo, activaction);
		
		RequestDispatcher successView = req.getRequestDispatcher("/front-end/index.html");
		successView.forward(req, res);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
