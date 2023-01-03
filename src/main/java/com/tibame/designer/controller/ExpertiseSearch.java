package com.tibame.designer.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerExpertiseVO;
import com.tibame.designer.service.DesignerExpertiseService;

@WebServlet("/ExpertiseSearch")
public class ExpertiseSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	// 設計師與專長多對多的表格查詢
		
        String strexpertiseNo =req.getParameter("expertiseno").trim();
        System.out.println("ExpertiseSearch.java之expertise:"+strexpertiseNo);
        //Integer expertiseno = req.getpara
        Integer expertiseNo = Integer.valueOf(strexpertiseNo);
       
		DesignerExpertiseService designerExpertiseScv = new DesignerExpertiseService();
		Set <DesignerExpertiseVO> set = designerExpertiseScv.getExpertiseDesigner(expertiseNo);
		HttpSession session = req.getSession();
		session.setAttribute("set", set);
		System.out.println("ExpertiseSearch.java之set內容:"+set.toString());
		String url = "/front-end/designer/findDesigner.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);			
		doPost(req, res);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	
	}

}
