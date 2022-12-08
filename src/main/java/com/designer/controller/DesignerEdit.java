package com.designer.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.designer.model.DesignerVO;
import com.designer.service.DesignerService;

@WebServlet("/DesignerEdit")
public class DesignerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession session=req.getSession();  
    session.getAttribute("designerNo");
	DesignerVO designerVO= new DesignerVO();
    DesignerService designerService =new DesignerService();
    designerService.getOneDesigner(designerVO.getDesignerNo());


    req.setAttribute("designerVO", designerVO); // 資料庫取出的empVO物件,存入req
	String url = "/front-end/designer/updatedesignerINFO.jsp";
	RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
	successView.forward(req, res);
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
