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

@WebServlet("/forumtopic/forumtopic.do")
public class ForumTopicController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// 透過討論區編號找
		if ("getTopicByTopicNo".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("topicNo");
			if (str.trim().length() == 0) {
				errorMessages.add("討論區編號未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/selectForumTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			Integer topicNo = null;
			try {
				topicNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMessages.add("討論區編號格式不正確");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/selectForumTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/

			ForumTopicService forumTopicService = new ForumTopicService();
			ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
			if (forumTopicVO == null) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/selectForumTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("forumTopicVO", forumTopicVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumtopic/getTopicByTopicNo.jsp");
			successView.forward(request, response);

		}

		// 透過討論區名稱找
		if ("getTopicByTopicName".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			String str = request.getParameter("topicName");
			if ((str.trim()).length() == 0) {
				errorMessages.add("討論區名稱未輸入");
			}

			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/selectForumTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			List<ForumTopicVO> list = forumTopicService.getTopicByTopicName(str);
			if (list.isEmpty()) {
				errorMessages.add("查無資料");
			}
			if (!errorMessages.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/selectForumTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 3 ************************/
			request.setAttribute("list", list);
			RequestDispatcher successView = request.getRequestDispatcher("/forumtopic/getMultipleTopics.jsp");
			successView.forward(request, response);

		}

		// 刪除
		if ("deleteFromAll".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			/************************ 2 ************************/

			ForumTopicService forumTopicService = new ForumTopicService();
			try {
				forumTopicService.deleteTopic(topicNo);

				/************************ 3 ************************/
				RequestDispatcher successView = request.getRequestDispatcher("/forumtopic/listAllTopics.jsp");
				errorMessages.add("刪除成功");
				successView.forward(request, response);
			} catch (SQLException e) {
				errorMessages.add("有FK無法刪除");
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/listAllTopics.jsp");
				failureView.forward(request, response);
			}

		}

		// 修改
		if ("updateFromAll".equals(action)) {

			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));

			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);

			/************************ 3 ************************/
			request.setAttribute("forumTopicVO", forumTopicVO);
			RequestDispatcher successView = request.getRequestDispatcher("/forumtopic/updateByTopicNo.jsp");
			successView.forward(request, response);
		}
		if ("update".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));

			String topicName = request.getParameter("topicName");
			if (topicName.trim().length() == 0) {
				errorMessages.add("請輸入討論區名稱");
			}

			ForumTopicService forumTopicService = new ForumTopicService();
			ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
			forumTopicVO.setTopicNo(topicNo);
			forumTopicVO.setAdminNo(adminNo);
			forumTopicVO.setTopicName(topicName);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumTopicVO", forumTopicVO);
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/updateByTopicNo.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			forumTopicService.updateTopic(topicName, adminNo, topicNo);
			/************************ 3 ************************/
			forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
			request.setAttribute("forumTopicVO", forumTopicVO);
			RequestDispatcher successViewe = request.getRequestDispatcher("/forumtopic/getTopicByTopicNo.jsp");
			successViewe.forward(request, response);
		}

		// 新增
		if ("insert".equals(action)) {
			List<String> errorMessages = new LinkedList<String>();
			request.setAttribute("errorMessages", errorMessages);

			/************************ 1 ************************/
			Integer adminNo = Integer.valueOf(request.getParameter("adminNo"));

			String topicName = request.getParameter("topicName");
			if (topicName.trim().length() == 0) {
				errorMessages.add("請輸入討論區名稱");
			}

			ForumTopicVO forumTopicVO = new ForumTopicVO();
			forumTopicVO.setAdminNo(adminNo);
			forumTopicVO.setTopicName(topicName);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("forumTopicVO", forumTopicVO);
				RequestDispatcher failureView = request.getRequestDispatcher("/forumtopic/addTopic.jsp");
				failureView.forward(request, response);
				return;
			}

			/************************ 2 ************************/
			ForumTopicService forumTopicService = new ForumTopicService();
			forumTopicService.addTopic(topicName, adminNo);
			/************************ 3 ************************/
			RequestDispatcher successViewe = request.getRequestDispatcher("/forumtopic/listAllTopics.jsp");
			successViewe.forward(request, response);
		}

	}
}
