package designer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import designer.model.DesignerVO;
import designer.service.DesignerService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/inquiry")
public class Inquriy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		HttpSession session = req.getSession();
		session.getAttribute("listXX");
		session.getAttribute("designerExpertiseVO");
	
			System.out.println("有進來inquiry.java");	
			String strdesignerNo = req.getParameter("designerNo").trim();
			Integer designerNo=null;
			designerNo = Integer.valueOf(strdesignerNo);
			System.out.println("designerNo:"+designerNo);
			
			//Integer designerNo  = Integer.valueOf(req.getParameter("designerNo").trim());			
			DesignerService designerSvc = new DesignerService();
			DesignerVO designerVO = designerSvc.getOneDesignerinfo(designerNo);
			session.setAttribute("designerVO",designerVO);
			String url = "/front-end/designer/inquiryPage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		
		
		
		
		
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


	}

}
