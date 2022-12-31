package com.tibame.designer.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderPhaseService;
import com.tibame.designer.service.DesignerOrderService;

@WebServlet("/ShowOneOrderDetail")
public class ShowOneOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		if("getMyOrder".equals(action)) {
			//Integer designerOrderNo=Integer.valueOf(req.getParameter("orderNo"));
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String str = req.getParameter("orderNo").trim();
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
			
			}
	
			HttpSession session =  req.getSession();
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			DesignerOrderPhaseService designerOrderPhaseService = new DesignerOrderPhaseService();
			List<DesignerOrderPhaseVO> list = designerOrderPhaseService.getOrderPhase(designerOrderNo);
			System.out.println("list內容:"+list.toString());
			session.setAttribute("list", list);
			session.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/designer/listOneOrder.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		
		//===================================================================================
	
		
		
	
	}

}
