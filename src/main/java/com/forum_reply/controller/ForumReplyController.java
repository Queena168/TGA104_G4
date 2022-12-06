package com.forum_reply.controller;

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

import com.forum_reply.model.ForumReplyVO;
import com.forum_reply.model.ForumReplyService;

@WebServlet("/front-end/forum/forumreply/forumreply.do")
public class ForumReplyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// 透過回應編號找
		if ("getReplyByReplyNo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("replyNo");
			if (str.trim().length() == 0) {
				errorMessages.add("回編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			Integer replyNo = null;
			try {
				replyNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMessages.add("回應編號格式不正確");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumReplyService forumReplyService = new ForumReplyService();
			ForumReplyVO forumReplyVO = forumReplyService.getReplyByReplyNo(replyNo);
			if (forumReplyVO == null) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("forumReplyVO", forumReplyVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumreply/getReplyByReplyNo.jsp");
			successView.forward(request, response);

		}

		// 透過會員編號找
		if ("getReplyByMemberNo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("memberNo");
			if ((str.trim()).length() == 0) {
				errorMessages.add("會員編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			Integer memberNo = null;
			try {
				memberNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMessages.add("會員編號格式不正確");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}
			/************************ 2 ************************/

			ForumReplyService forumReplyService = new ForumReplyService();
			List<ForumReplyVO> list = forumReplyService.getReplyByMemberNo(memberNo);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumreply/getMultipleReplies.jsp");
			successView.forward(request, response);

		}

		// 透過對應文章編號找
		if ("getReplyByReplyTo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("replyTo");
			if ((str.trim()).length() == 0) {
				errorMessages.add("對應文章編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			Integer replyTo = null;
			try {
				replyTo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMessages.add("對應文章編號格式不正確");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumReplyService forumReplyService = new ForumReplyService();
			List<ForumReplyVO> list = forumReplyService.getReplyByReplyTo(replyTo);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumreply/getMultipleReplies.jsp");
			successView.forward(request, response);

		}

		// 透過回應內容找
		if ("getReplyByContent".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("content");
			if ((str.trim()).length() == 0) {
				errorMessages.add("回應內容未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumReplyService forumReplyService = new ForumReplyService();
			List<ForumReplyVO> list = forumReplyService.getReplyByContent(str);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/selectForumReply.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumreply/getMultipleReplies.jsp");
			successView.forward(request, response);

		}

		// 刪除
		if ("deleteFromAll".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));

			/************************ 2 ************************/

			ForumReplyService forumReplyervice = new ForumReplyService();
			try {
				forumReplyervice.deleteReply(replyNo);

				/************************ 3 ************************/
				RequestDispatcher successView = request.getRequestDispatcher("/forumReply/listAllReplies.jsp");
				errorMessages.add("刪除成功");
				successView.forward(request, response);
			} catch (SQLException e) {
				errorMessages.add("有FK無法刪除");
				RequestDispatcher failureView = request.getRequestDispatcher("/forumReply/listAllReplies.jsp");
				failureView.forward(request, response);
			}

		}

		// 修改
		if ("updateFromAll".equals(action)) {

			/************************ 1 ************************/
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));

			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			ForumReplyVO forumReplyVO = forumReplyService.getReplyByReplyNo(replyNo);

			/************************ 3 ************************/
			request.setAttribute("forumReplyVO", forumReplyVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumReply/updateByReplyNo.jsp");
			successView.forward(request, response);
		}

		if ("update".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));

			String content = request.getParameter("content");
			if (content.trim().length() == 0) {
				errorMessages.add("請輸入回應內容");
			}

			ForumReplyService forumReplyService = new ForumReplyService();
			ForumReplyVO forumReplyVO = forumReplyService.getReplyByReplyNo(replyNo);

			forumReplyVO.setReplyNo(replyNo);
			forumReplyVO.setContent(content);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumReplyVO", forumReplyVO);
				RequestDispatcher failureView = request.getRequestDispatcher("/forumreply/updateByReplyNo.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			forumReplyService.updateReply(content, replyNo);
			/************************ 3 ************************/
			forumReplyVO = forumReplyService.getReplyByReplyNo(replyNo);
			request.setAttribute("forumReplyVO", forumReplyVO);
			RequestDispatcher successViewe = request.getRequestDispatcher("/forumreply/getReplyByReplyNo.jsp");
			successViewe.forward(request, response);
		}

		// 新增
		if ("insert".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer replyTo = Integer.valueOf(request.getParameter("replyTo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String content = request.getParameter("content");
			if (content.trim().length() == 0) {
				errorMessages.add("請輸入回應內容");
			}

			ForumReplyVO forumReplyVO = new ForumReplyVO();
			forumReplyVO.setMemberNo(memberNo);
			forumReplyVO.setReplyTo(replyTo);
			forumReplyVO.setContent(content);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumReplyVO", forumReplyVO);
				response.sendRedirect(request.getContextPath()+"/front-end/forum/posts.jsp?topicNo="+topicNo+"&postNo="+replyTo);
//				RequestDispatcher failureView = request.getRequestDispatcher("/front-end/forum/posts.jsp?topicNo=" + topicNo + "&postNo=" + replyTo);
//				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			ForumReplyService forumReplyService = new ForumReplyService();
			forumReplyService.addReply(memberNo, replyTo, content);
			/************************ 3 ************************/
			response.sendRedirect(request.getContextPath()+"/front-end/forum/posts.jsp?topicNo="+topicNo+"&postNo="+replyTo);
//			RequestDispatcher successViewe = request.getRequestDispatcher("/front-end/forum/posts.jsp?topicNo=" + topicNo + "&postNo=" + replyTo);
//			successViewe.forward(request, response);
		}

	}
}
