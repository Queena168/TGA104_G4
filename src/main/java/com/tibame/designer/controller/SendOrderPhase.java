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

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.service.DesignerOrderPhaseService;

@WebServlet("/SendOrderPhase")
public class SendOrderPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		DesignerOrderPhaseVO total = (DesignerOrderPhaseVO) session.getAttribute("designerOneOrderPhaseVO");		
		System.out.println("SendOrderPhase之designerOneOrderPhaseVO:"+session.getAttribute("designerOneOrderPhaseVO"));
		String constructionStatus = req.getParameter("constructionStatus");
		//String orderPhaseDetail = req.getParameter("orderPhaseDetail");
		String strorderNo = req.getParameter("orderNo");
		Integer orderNo = Integer.valueOf(strorderNo);
		String strtotalOrderPhase = req.getParameter("totalOrderPhase");
		Integer totalOrderPhase = Integer.valueOf(strtotalOrderPhase);
		String strphaseNumber = req.getParameter("phasenumber");
		Integer orderPhase = Integer.valueOf(strphaseNumber);
		Integer totalAmount = total.getTotalAmount();
//		Part part = req.getPart("orderPhaseAtt");
//		InputStream in = part.getInputStream();
//		byte[] orderPhaseAtt = new byte[in.available()];
//		in.read(orderPhaseAtt);
//		in.close();
		DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();		
	   // designerOrderPhaseSvc.insertDesignerOrderPhaseConstruction(orderNo,totalOrderPhase,orderPhase,constructionStatus, orderPhaseDetail,orderPhaseAtt);
	    designerOrderPhaseSvc.insertDesignerOrderPhaseConstruction(orderNo,totalOrderPhase,orderPhase,totalAmount,constructionStatus);
	    List<DesignerOrderPhaseVO> list = designerOrderPhaseSvc.getOrderPhase(orderNo);
		DesignerOrderPhaseVO  designerOneOrderPhaseVO = designerOrderPhaseSvc.getOneOrderPhase(orderNo);
		System.out.println("sendorderphase之designerOrderPhaseVO內容:"+list);
		session.setAttribute("list", list);
		session.setAttribute("designerOneOrderPhaseVO", designerOneOrderPhaseVO);
		String url = "/front-end/designer/listOneOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
	}

}
