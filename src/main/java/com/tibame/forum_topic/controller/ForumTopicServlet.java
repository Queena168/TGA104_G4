package com.tibame.forum_topic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tibame.forum_topic.model.ForumTopicService;

@WebServlet("/back-end/forum/forumtopic.do")
public class ForumTopicServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		Map<String, String> message = new HashMap<String, String>();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();

		// ============================ 修改 ============================
		if ("update".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));
			String topicName = request.getParameter("topicName");

			if (topicName.trim().length() == 0) {
				message.put("error", "請輸入名稱");
				writer.write(gson.toJson(message));
				return;
			}

			if (topicName.length() > 20) {
				message.put("error", "名稱請勿超過20字");
				writer.write(gson.toJson(message));
				return;
			}
			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			forumTopicService.updateTopic(topicName, adminNo, topicNo);
			/************************ 3 ************************/
			message.put("success", "adminTopic.do");
			writer.write(gson.toJson(message));
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {
			/************************ 1 ************************/
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));
			String topicName = request.getParameter("topicName");

			if (topicName.trim().length() == 0) {
				message.put("error", "請輸入名稱");
				writer.write(gson.toJson(message));
				return;
			}

			if (topicName.length() > 20) {
				message.put("error", "名稱請勿超過20字");
				writer.write(gson.toJson(message));
				return;
			}
			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			forumTopicService.addTopic(topicName, adminNo);
			/************************ 3 ************************/
			message.put("success", "adminTopic.do");
			writer.write(gson.toJson(message));
		}
	}
}