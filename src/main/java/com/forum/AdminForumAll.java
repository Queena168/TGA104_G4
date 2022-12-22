package com.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_post.model.ForumPostService;
import com.forum_reply.model.ForumReplyService;

@WebServlet("/back-end/forum/adminAll.do")
public class AdminForumAll extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ForumPostService forumPostService = new ForumPostService();
		ForumReplyService forumReplyService = new ForumReplyService();
		String listname = request.getParameter("listname");
		List forumVOList = new ArrayList<>();
		try {
			if (listname.equals("post")) {
				forumVOList = forumPostService.getAll();
			} else if (listname.equals("reply")) {
				forumVOList = forumReplyService.getAll();
			}
		} catch (NullPointerException e) {
			forumVOList = forumPostService.getAll();
			listname = "post";
		}
		request.setAttribute("forumVOList", forumVOList);
		request.setAttribute("listname", listname);

		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		if (!forumVOList.isEmpty()) {
			int rowsPerPage = 5;
			int pageStart = Pagination.pagination(forumVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumVOList, page, rowsPerPage)[1];
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageStart + rowsPerPage - 1);
			request.setAttribute("totalPage", totalPage);
		} else {
			request.setAttribute("totalPage", 1);
		}

		RequestDispatcher successView = request.getRequestDispatcher(
				"/back-end/forum/Admin-Forum-ForumList.jsp?page=" + page + "&listname=" + listname);
		successView.forward(request, response);
	}
}
