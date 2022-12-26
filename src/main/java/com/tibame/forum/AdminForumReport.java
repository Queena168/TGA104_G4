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

import com.tibame.forum_report.model.ForumReportService;
import com.tibame.forum_report.model.ForumReportVO;

@WebServlet("/back-end/forum/adminReport.do")
public class AdminForumReport extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ForumReportService forumReportService = new ForumReportService();
		String listname = request.getParameter("listname");
		// 從query string 取得 listname

		List<ForumReportVO> forumReportVOList = new ArrayList<ForumReportVO>();
		try {
			if (listname.equals("all")) {
				forumReportVOList = forumReportService.getAll();
			} else if (listname.equals("done")) {
				forumReportVOList = forumReportService.getReportByReportStatus("已處理");
			} else if (listname.equals("undone")) {
				forumReportVOList = forumReportService.getReportByReportStatus("未處理");
			}
		} catch (NullPointerException e) {
			forumReportVOList = forumReportService.getAll();
			listname = "all"; // 第一次進來無query string，設定listname = "all";
		}

		request.setAttribute("forumReportVOList", forumReportVOList);
		request.setAttribute("listname", listname);
		// 將取得的ReportVOList & listname 存入attribute

		// =====資料分頁=====
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		if (!forumReportVOList.isEmpty()) {
			int rowsPerPage = 5;
			int pageStart = Pagination.pagination(forumReportVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumReportVOList, page, rowsPerPage)[1];
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageStart + rowsPerPage - 1);
			request.setAttribute("totalPage", totalPage);
		} else {
			request.setAttribute("totalPage", 1);
		}
		// 宣告每頁5筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		RequestDispatcher successView = request.getRequestDispatcher(
				"/back-end/forum/Admin-Forum-ForumReportCheck.jsp?page=" + page + "&listname=" + listname);
		successView.forward(request, response);
	}
}