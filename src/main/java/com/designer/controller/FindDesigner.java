package com.designer.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designerExpertise.Service.DesignerExpertiseService;
import com.designerExpertise.model.DesignerExpertiseVO;

@WebServlet("/FindDesigner")
public class FindDesigner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ====================================================================================
//		// 設計師與專長多對多的表格查詢
////Integer designerNo = Integer.valueOf(req.getParameter("designerNo"));
//		DesignerExpertiseService designerExpertiseScv = new DesignerExpertiseService();
//		Set<DesignerExpertiseVO> set = designerExpertiseScv.;
////DesignerExpertiseVO designerExpertiseVO=designerExpertiseScv.getMyExpertises(designerNo);
//		HttpSession session = req.getSession();
//		session.setAttribute("set", set);
////session.setAttribute("designerExpertiseVO", designerExpertiseVO);
//		System.out.println("DesignerServlet.java----set內容" + set);
////System.out.println("DesignerServlet.java----designerExpertiseVO內容"+designerExpertiseVO.toString());
//		String url = "/front-end/designer/findDesigner.jsp";
//		RequestDispatcher successView = req.getRequestDispatcher(url);
//		successView.forward(req, res);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);

	}

}
