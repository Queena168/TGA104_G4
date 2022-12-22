package com.forum;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.AdminService;
import com.admin.model.AdminVO;
import com.forum_topic.model.ForumTopicService;
import com.forum_topic.model.ForumTopicVO;

@WebServlet("/back-end/forum/adminTopic.do")
public class AdminForumTopic extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		ForumTopicService forumTopicService = new ForumTopicService();
		List<ForumTopicVO> forumTopicVOList = forumTopicService.getAll();
		request.setAttribute("forumTopicVOList", forumTopicVOList);
		// 取得所有討論區TopicVO，存入attribute
		
		AdminService adminService = new AdminService();
		List<AdminVO> adminVOList = adminService.getAll();
		request.setAttribute("adminVOList", adminVOList);
		
		RequestDispatcher successView = request.getRequestDispatcher("/back-end/forum/Admin-Forum-ForumMaintain.jsp");
		successView.forward(request, response);
	}
}
