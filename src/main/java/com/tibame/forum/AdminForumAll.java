package com.tibame.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_reply.model.ForumReplyService;

@WebServlet("/back-end/forum/adminForumAll.do")
public class AdminForumAll extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ForumPostService forumPostService = new ForumPostService();
		ForumReplyService forumReplyService = new ForumReplyService();

		String listname = request.getParameter("listname");
		// 從query string 取得 listname

		List forumVOList = new ArrayList<>();
		try {
			if (listname.equals("post")) {
				forumVOList = forumPostService.getAll();
			} else if (listname.equals("reply")) {
				forumVOList = forumReplyService.getAll();
			}
		} catch (NullPointerException e) {
			forumVOList = forumPostService.getAll();
			listname = "post"; // 第一次進來無query string，設定listname = "post";
		}
		request.setAttribute("forumVOList", forumVOList);
		request.setAttribute("listname", listname);
		// 將取得的VOList & listname 存入attribute

		// =====資料分頁=====
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
		// 宣告每頁5筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		RequestDispatcher successView = request.getRequestDispatcher(
				"/back-end/forum/adminForumAll.jsp?page=" + page + "&listname=" + listname);
		successView.forward(request, response);
	}
}