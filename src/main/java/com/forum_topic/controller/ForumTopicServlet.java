package com.forum_topic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_topic.model.ForumTopicService;
import com.forum_topic.model.ForumTopicVO;

@WebServlet("/back-end/forum/forumtopic.do")
public class ForumTopicServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		// ============================ 修改 ============================
		if ("update".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));

			String topicName = request.getParameter("topicName");
			if (topicName.trim().length() == 0) {
				System.out.println("illeage");
				response.sendRedirect("adminTopic.do");
				return;
			}
			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			forumTopicService.updateTopic(topicName, adminNo, topicNo);
			/************************ 3 ************************/
			response.sendRedirect("adminTopic.do");
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {
			/************************ 1 ************************/
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));

			String topicName = request.getParameter("topicName");
			if (topicName.trim().length() == 0) {
				System.out.println("illeage");
				response.sendRedirect("adminTopic.do");
				return;
			}
			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			forumTopicService.addTopic(topicName, adminNo);
			/************************ 3 ************************/
			response.sendRedirect("adminTopic.do");
		}
	}
}