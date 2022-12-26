package com.tibame.forum_post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_post.model.ForumPostVO;
import com.tibame.forum_topic.model.ForumTopicService;

@WebServlet("/front-end/forum/forumpost.do")
public class ForumPostServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		Map<String, String> message = new HashMap<String, String>();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();

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
			String content = request.getParameter("content");

			if (content.trim().length() == 0 && title.trim().length() == 0
					|| content.equals("<p><br></p>") && title.trim().length() == 0) {
				message.put("error", "請輸入標題及文章內容");
				writer.write(gson.toJson(message));
				return;
			}

			if (title.trim().length() == 0) {
				message.put("error", "請輸入標題");
				writer.write(gson.toJson(message));
				return;
			}

			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				message.put("error", "請輸入文章內容");
				writer.write(gson.toJson(message));
				return;
			}

			if (title.length() > 50) {
				message.put("error", "標題請勿超過50個字");
				writer.write(gson.toJson(message));
				return;
			}
			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.updatePost(title, content, postNo);
			message.put("updatesuccess", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=1");
			writer.write(gson.toJson(message));
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {
			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			if (content.trim().length() == 0 && title.trim().length() == 0
					|| content.equals("<p><br></p>") && title.trim().length() == 0) {
				message.put("error", "請輸入標題及文章內容");
				writer.write(gson.toJson(message));
				return;
			}

			if (title.trim().length() == 0) {
				message.put("error", "請輸入標題");
				writer.write(gson.toJson(message));
				return;
			}

			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				message.put("error", "請輸入文章內容");
				writer.write(gson.toJson(message));
				return;
			}

			if (title.length() > 50) {
				message.put("error", "標題請勿超過50個字");
				writer.write(gson.toJson(message));
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.addPost(memberNo, topicNo, title, content);
			message.put("success", "topic.do?topicNo=" + topicNo + "&page=1");
			writer.write(gson.toJson(message));
		}
	}
}