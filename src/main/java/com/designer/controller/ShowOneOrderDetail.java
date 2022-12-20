package com.designer.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designer.model.DesignerOrderVO;
import com.designer.service.DesignerOrderService;

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
			String str = req.getParameter("orderNo");
			//System.out.println("DesinerOrderServlet執行");
			if (str == null || (str.trim()).length() == 0) {
				
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {

				return;// 程式中斷
			}

			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
             
				return;// 程式中斷
			}	
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			req.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/designer/listOneOrder.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		
		//===================================================================================
		
		
		if("getmemberMyOrder".equals(action)) {
			//Integer designerOrderNo=Integer.valueOf(req.getParameter("orderNo"));
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			String str = req.getParameter("orderNo");
			//System.out.println("DesinerOrderServlet執行");
			if (str == null || (str.trim()).length() == 0) {
				
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {

				return;// 程式中斷
			}

			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
             
				return;// 程式中斷
			}	
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			req.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/member/listOneOrder.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
	
	}

}
