package com.tibame.designer.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerExpertiseVO;
import com.tibame.designer.service.DesignerExpertiseService;

@WebServlet("/designerExpertise")
public class DesignerExpertiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		//HttpSession session = req.getSession();
		//session.getAttribute("designerVO");
		Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
		//PrintWriter out = res.getWriter();
		DesignerExpertiseService designerExpertiseScv=new DesignerExpertiseService();
		List<DesignerExpertiseVO> list= designerExpertiseScv.getMyExpertise(designerNo);
		DesignerExpertiseVO designerExpertiseVO = designerExpertiseScv.getMyExpertises(designerNo);
		HttpSession session = req.getSession();
		session.setAttribute("designerExpertiseVO", designerExpertiseVO);
		System.out.println("DesignerExpertiseServlet收到的list內容"+list);
		req.setAttribute("listXX", list);
		String url = "/front-end/designer/listOneDesignerINFO.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
		successView.forward(req, res);

	}
	
	


}
