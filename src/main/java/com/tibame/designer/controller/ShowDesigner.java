package com.tibame.designer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerExpertiseVO;
import com.tibame.designer.model.ExpertiseVO;
import com.tibame.designer.service.DesignerExpertiseService;
import com.tibame.designer.service.ExpertiseService;
@WebServlet("/ShowDesignerPage")
public class ShowDesigner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		// ====================================================================================
		// 設計師與專長多對多的表格查詢
		ExpertiseService expertiseSvc =new ExpertiseService();
		List<ExpertiseVO> expertoseVOlist = expertiseSvc.getAll();
		DesignerExpertiseService designerExpertiseScv = new DesignerExpertiseService();
		Set<DesignerExpertiseVO> set = designerExpertiseScv.getAll();
		//System.out.println("showdesignerexpertise之designerExpertiseScv被執行");
		HttpSession session = req.getSession();
		session.setAttribute("expertoseVOlist", expertoseVOlist);
		System.out.println(expertoseVOlist.toString());
		session.setAttribute("set", set);
		String url = "/front-end/designer/findDesigner.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
	}

}
