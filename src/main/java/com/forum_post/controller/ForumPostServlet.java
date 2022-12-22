package com.forum_post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_post.model.ForumPostService;
import com.forum_post.model.ForumPostVO;
import com.forum_topic.model.ForumTopicService;

@WebServlet("/front-end/forum/forumpost.do")
public class ForumPostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// ============================ 搜尋 ============================
		if ("search".equals(action)) {

			/************************ 1 ************************/
			String str = request.getParameter("keyword");
			if ((str.trim()).length() == 0) {
				response.sendRedirect("forumIndex.do");
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			List<ForumPostVO> resultList = forumPostService.getPostByKeyword(str);

			if (resultList.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/front-end/forum/searchResult.jsp");
				failureView.forward(request, response);
				return;
			}
			/************************ 3 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();

			List<String> topicNameList = new ArrayList<String>();

			for (ForumPostVO a : resultList) {
				topicNameList.add(forumTopicService.getTopicByTopicNo(a.getTopicNo()).getTopicName());
			}

			request.setAttribute("resultList", resultList);
			request.setAttribute("topicNameList", topicNameList);
			RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/searchResult.jsp");
			successView.forward(request, response);
		}

		// ============================ 修改 ============================
		if ("update".equals(action)) {
			/************************ 1 ************************/
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=1");
				return;
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=1");
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.updatePost(title, content, postNo);
			/************************ 3 ************************/
			response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=1");
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {

			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				response.sendRedirect("posting.do?topicNo=" + topicNo + "&page=1");
				return;
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				response.sendRedirect("posting.do?topicNo=" + topicNo + "&page=1");
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.addPost(memberNo, topicNo, title, content);
			/************************ 3 ************************/
			response.sendRedirect("topic.do?topicNo=" + topicNo + "&page=1");
		}
	}
}