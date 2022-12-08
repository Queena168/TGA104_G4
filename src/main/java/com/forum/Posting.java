package com.forum;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_topic.model.ForumTopicService;
import com.forum_topic.model.ForumTopicVO;

@WebServlet("/front-end/forum/posting.do")
public class Posting extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
		// 從query string取得topicNo

		ForumTopicService forumTopicService = new ForumTopicService();
		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		request.setAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該討論區的TopicVO，存入attribute

		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/posting.jsp");
		successView.forward(request, response);
	}

}
