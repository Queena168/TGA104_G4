package com.tibame.designer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerVO;
import com.tibame.designer.service.DesignerService;

@WebServlet("/DesignerEdit")
public class DesignerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.getAttribute("designerVO");
		Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
		DesignerService designerService = new DesignerService();
		DesignerVO designerVO = designerService.getOneDesigner(designerNo);
		session.setAttribute("designerVO", designerVO); //
		String url = "/front-end/designer/updatedesignerINFO.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		successView.forward(req, res);
		doPost(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

}
