package com.forum_post.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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

@WebServlet("/front-end/forum/forumpost.do")
public class ForumPostController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// 透過文章編號找
		if ("getPostByPostNo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("postNo");
			if (str.trim().length() == 0) {
				errorMessages.add("文章編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			Integer postNo = null;
			try {
				postNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMessages.add("文章編號格式不正確");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumPostService forumPostService = new ForumPostService();
			ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);
			if (forumPostVO == null) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("forumPostVO", forumPostVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getPostByPostNo.jsp");
			successView.forward(request, response);

		}

		// 透過會員編號找
		if ("getPostByMemberNo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("memberNo");
			if ((str.trim()).length() == 0) {
				errorMessages.add("會員編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
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
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}
			/************************ 2 ************************/

			ForumPostService forumPostService = new ForumPostService();
			List<ForumPostVO> list = forumPostService.getPostByMemberNo(memberNo);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getMultiplePosts.jsp");
			successView.forward(request, response);

		}

		// 透過文章標題找
		if ("getPostByTitle".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("title");
			if ((str.trim()).length() == 0) {
				errorMessages.add("文章標題未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumPostService forumPostService = new ForumPostService();
			List<ForumPostVO> list = forumPostService.getPostByTitle(str);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getMultiplePosts.jsp");
			successView.forward(request, response);

		}

		// 透過文章內容找
		if ("getPostByContent".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("content");
			if ((str.trim()).length() == 0) {
				errorMessages.add("文章內容未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumPostService forumPostService = new ForumPostService();
			List<ForumPostVO> list = forumPostService.getPostByContent(str);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/selectForumPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/getMultiplePosts.jsp");
			successView.forward(request, response);

		}

		// 刪除
		if ("deleteFromAll".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));

			/************************ 2 ************************/

			ForumPostService forumPostService = new ForumPostService();
			try {
				forumPostService.deletePost(postNo);

				/************************ 3 ************************/
				RequestDispatcher successView = request.getRequestDispatcher("/forumpost/listAllPosts.jsp");
				errorMessages.add("刪除成功");
				successView.forward(request, response);
			} catch (SQLException e) {
				errorMessages.add("有FK無法刪除");
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/listAllPosts.jsp");
				failureView.forward(request, response);
			}
		}

		// 修改
		if ("updateFromAll".equals(action)) {

			/************************ 1 ************************/
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);

			/************************ 3 ************************/
			request.setAttribute("forumPostVO", forumPostVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumpost/updateByPostNo.jsp");
			successView.forward(request, response);
		}

		if ("update".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				errorMessages.add("請輸入文章標題");
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0) {
				errorMessages.add("請輸入文章內容");
			}

			ForumPostService forumPostService = new ForumPostService();
			ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);

			forumPostVO.setPostNo(postNo);
			forumPostVO.setTitle(title);
			forumPostVO.setContent(content);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumPostVO", forumPostVO);
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/updateByPostNo.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			forumPostService.updatePost(title, content, postNo);
			/************************ 3 ************************/
			forumPostVO = forumPostService.getPostByPostNo(postNo);
			request.setAttribute("forumPostVO", forumPostVO);
			RequestDispatcher successViewe = request.getRequestDispatcher("/forumpost/getPostByPostNo.jsp");
			successViewe.forward(request, response);
		}

		// 新增
		if ("insert".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer memberNo = Integer.valueOf(request.getParameter("memberNo"));
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			String title = request.getParameter("title");
			if (title.trim().length() == 0) {
				errorMessages.add("請輸入文章標題");
			}

			String content = request.getParameter("content");
			if (content.trim().length() == 0) {
				errorMessages.add("請輸入文章內容");
			}

			ForumPostVO forumPostVO = new ForumPostVO();
			forumPostVO.setMemberNo(memberNo);
			forumPostVO.setTopicNo(topicNo);
			forumPostVO.setTitle(title);
			forumPostVO.setContent(content);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumPostVO", forumPostVO);
				RequestDispatcher failureView = request.getRequestDispatcher("/forumpost/addPost.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			ForumPostService forumPostService = new ForumPostService();
			forumPostService.addPost(memberNo, topicNo, title, content);
			/************************ 3 ************************/
			RequestDispatcher successViewe = request.getRequestDispatcher("/front-end/forum/topic.do?topicNo="+topicNo);
			successViewe.forward(request, response);
		}

	}
}
