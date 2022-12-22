package com.chat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.designer.model.DesignerJNDIDAO;
import com.designer.model.DesignerVO;
import com.member.model.MemberDAO;
import com.member.model.MemberVO;

@WebServlet("/front-end/chat/intochatServlet")
public class intochatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public intochatServlet() {
        super();
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	doPost(req, res);
    }

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if(req.getParameter("memberNo") != null) {     //true=會員身份進入聊天室
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));

			MemberDAO dao = new MemberDAO();
			MemberVO memberVO = dao.findByPrimaryKey(memberNo);
			String userName = memberVO.getMemberName();
//			System.out.println("userName : " + userName);	
			
			req.setAttribute("userName", userName);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/chat/chatRoom.jsp");
			dispatcher.forward(req, res);
			
		} else {  // false=設計師身份進入聊天室
			Integer designerNo = Integer.valueOf(req.getParameter("designerNo")) ;
			
			DesignerJNDIDAO dao = new DesignerJNDIDAO();
			DesignerVO designerVO = dao.findByPrimaryKey(designerNo);
			String userName = designerVO.getDesignerName();
			
			req.setAttribute("userName", userName);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/chat/chatRoom.jsp");
			dispatcher.forward(req, res);
			
			
		}
		
		
		
	}

}
