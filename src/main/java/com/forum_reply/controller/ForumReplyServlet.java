package com.forum_reply.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_reply.model.ForumReplyService;

@WebServlet("/front-end/forum/forumreply.do")
public class ForumReplyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// ============================ 修改 ============================
		if ("update".equals(action)) {
			/************************ 1 ************************/
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));
			Integer replyTo = Integer.valueOf(request.getParameter("postNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer page = Integer.valueOf(request.getParameter("page"));

			String content = request.getParameter("content");

			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + page);
				return;
			}

			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			forumReplyService.updateReply(content, replyNo);
			/************************ 3 ************************/
			response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + page);
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
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + totalPage);
				return;
			}

			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			forumReplyService.addReply(memberNo, replyTo, content);
			/************************ 3 ************************/
			response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + replyTo + "&page=" + totalPage);
		}
	}
}
