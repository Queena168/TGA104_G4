package com.forum_reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_reply.model.ForumReplyService;
import com.google.gson.Gson;

@WebServlet("/front-end/forum/forumreply.do")
public class ForumReplyServlet extends HttpServlet {

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
			/************************ 1 ************************/
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));
			Integer replyTo = Integer.valueOf(request.getParameter("postNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer page = Integer.valueOf(request.getParameter("page"));
			String content = request.getParameter("content");

			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				message.put("error", "請輸入文章內容");
				writer.write(gson.toJson(message));
				return;
			}

			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			forumReplyService.updateReply(content, replyNo);
			message.put("updatesuccess", "posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + page);
			writer.write(gson.toJson(message));
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {
			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer replyTo = Integer.valueOf(request.getParameter("postNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer totalPage = Integer.valueOf(request.getParameter("totalPage"));
			String content = request.getParameter("content");

			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				message.put("error", "請輸入文章內容");
				writer.write(gson.toJson(message));
				return;
			}
			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			forumReplyService.addReply(memberNo, replyTo, content);
			message.put("success", "posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + totalPage);
			writer.write(gson.toJson(message));
		}
	}
}