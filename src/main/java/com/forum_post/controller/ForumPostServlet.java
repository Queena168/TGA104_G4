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

//		// 透過文章編號找
//		if ("getPostByPostNo".equals(action)) {
//			List<String> errorMessages = new LinkedList<String>();
//			request.setAttribute("errorMessages", errorMessages);
//
//			/************************ 1 ************************/
//			String str = request.getParameter("postNo");
//			if (str.trim().length() == 0) {
//				errorMessages.add("文章編號未輸入");
//			}
//
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//
//			Integer postNo = null;
//			try {
//				postNo = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMessages.add("文章編號格式不正確");
//			}
//
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//
//			/************************ 2 ************************/
//
//			ForumPostService forumPostService = new ForumPostService();
//			ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);
//			if (forumPostVO == null) {
//				errorMessages.add("查無資料");
//			}
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//
//			/************************ 3 ************************/
//			request.setAttribute("forumPostVO", forumPostVO);
//			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getPostByPostNo.jsp");
//			successView.forward(request, response);
//
//		}
//
//		// 透過會員編號找
//		if ("getPostByMemberNo".equals(action)) {
//			List<String> errorMessages = new LinkedList<String>();
//			request.setAttribute("errorMessages", errorMessages);
//
//			/************************ 1 ************************/
//			String str = request.getParameter("memberNo");
//			if ((str.trim()).length() == 0) {
//				errorMessages.add("會員編號未輸入");
//			}
//
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//
//			Integer memberNo = null;
//			try {
//				memberNo = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMessages.add("會員編號格式不正確");
//			}
//
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//			/************************ 2 ************************/
//
//			ForumPostService forumPostService = new ForumPostService();
//			List<ForumPostVO> list = forumPostService.getPostByMemberNo(memberNo);
//			if (list.isEmpty()) {
//				errorMessages.add("查無資料");
//			}
//			if (!errorMessages.isEmpty()) {
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
//				failureView.forward(request, response);
//				return;
//			}
//
//			/************************ 3 ************************/
//			request.setAttribute("list", list);
//			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getMultiplePosts.jsp");
//			successView.forward(request, response);
//
//		}
//
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

//
//		// 刪除
//		if ("deleteFromAll".equals(action)) {
//			List<String> errorMessages = new LinkedList<String>();
//			request.setAttribute("errorMessages", errorMessages);
//
//			/************************ 1 ************************/
//			Integer postNo = Integer.valueOf(request.getParameter("postNo"));
//
//			/************************ 2 ************************/
//
//			ForumPostService forumPostService = new ForumPostService();
//			try {
//				forumPostService.deletePost(postNo);
//
//				/************************ 3 ************************/
//				RequestDispatcher successView = request.getRequestDispatcher("/forumpost/listAllPosts.jsp");
//				errorMessages.add("刪除成功");
//				successView.forward(request, response);
//			} catch (SQLException e) {
//				errorMessages.add("有FK無法刪除");
//				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/listAllPosts.jsp");
//				failureView.forward(request, response);
//			}
//		}
//
		// ============================ 修改 ============================
		if ("update".equals(action)) {
			/************************ 1 ************************/
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo);
				return;
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo);
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.updatePost(title, content, postNo);
			/************************ 3 ************************/
			response.sendRedirect("posts.do?topicNo=" + topicNo + "&postNo=" + postNo);
		}

		// ============================ 新增 ============================
		if ("insert".equals(action)) {

			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				response.sendRedirect("posting.do?topicNo=" + topicNo);
				return;
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
				response.sendRedirect("posting.do?topicNo=" + topicNo);
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.addPost(memberNo, topicNo, title, content);
			/************************ 3 ************************/
			response.sendRedirect("topic.do?topicNo=" + topicNo);
		}
	}
}
