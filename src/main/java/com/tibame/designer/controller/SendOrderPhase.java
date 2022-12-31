package com.tibame.designer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.service.DesignerOrderPhaseService;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/SendOrderPhase")
public class SendOrderPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("list");
		String constructionStatus = req.getParameter("constructionStatus");
		System.out.println(constructionStatus);
		String orderPhaseDetail = req.getParameter("orderPhaseDetail");
		String strorderNo = req.getParameter("orderNo");
		System.out.println(strorderNo);
		Integer orderNo = Integer.valueOf(strorderNo);
		String strtotalOrderPhase = req.getParameter("totalOrderPhase");
		Integer totalOrderPhase = Integer.valueOf(strtotalOrderPhase);
		Part part = req.getPart("orderPhaseAtt");
		InputStream in = part.getInputStream();
		byte[] orderPhaseAtt = new byte[in.available()];
		in.read(orderPhaseAtt);
		in.close();
		DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
		
	    designerOrderPhaseSvc.insertDesignerOrderPhaseConstruction(orderNo,totalOrderPhase,constructionStatus, orderPhaseDetail,orderPhaseAtt);
		List<DesignerOrderPhaseVO> list = designerOrderPhaseSvc.getOrderPhase(orderNo);
		System.out.println("sendorderphase之designerOrderPhaseVO內容:"+list);
		session.setAttribute("list", list);
		String url = "/front-end/designer/listOneOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
	}

}
