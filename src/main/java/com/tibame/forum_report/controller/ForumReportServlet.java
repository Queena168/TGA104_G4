package com.tibame.forum_report.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tibame.forum_report.model.ForumReportService;

@WebServlet(name = "forumreport.do", urlPatterns = { "/front-end/forum/forumreport.do",
		"/back-end/forum/forumreport.do" })
public class ForumReportServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		Map<String, String> message = new HashMap<String, String>();
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();

		// ============================ 處理檢舉 ============================
		if ("update".equals(action)) {
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));
			Integer replyNo = Integer.valueOf(request.getParameter("replyNo"));
			Integer reviewer = Integer.valueOf(request.getParameter("reviewer"));
			String listname = request.getParameter("listname");
			String reviewResult = request.getParameter("reviewResult");

			if ((reviewResult.trim()).length() == 0) {
				message.put("error", "請選擇");
				writer.write(gson.toJson(message));
				return;
			}

			ForumReportService forumReportService = new ForumReportService();
			if (replyNo == 0) {
				forumReportService.updateReportStatusByPostNo(reviewer, reviewResult, postNo);
			} else if (postNo == 0) {
				forumReportService.updateReportStatusByReplyNo(reviewer, reviewResult, replyNo);
			}
			message.put("success", "adminReport.do?listname=" + listname);
			writer.write(gson.toJson(message));
		}

		// ============================ 新增檢舉 ============================
		if ("insertReport".equals(action)) {
			/************************ 1 ************************/
			Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
			Integer informant = Integer.valueOf(request.getParameter("informant"));
			Integer postNo = Integer.valueOf(request.getParameter("postNo"));
			Integer page = Integer.valueOf(request.getParameter("page"));
			String reportReason = request.getParameter("reportReason");

			if (reportReason.trim().length() == 0) {
				message.put("error", "請輸入檢舉內容");
				writer.write(gson.toJson(message));
				return;
			}

			if (reportReason.length() > 50) {
				message.put("error", "請勿超過50字");
				writer.write(gson.toJson(message));
				return;
			}

			Integer replyNo;
			/************************ 2 ************************/
			ForumReportService forumReportService = new ForumReportService();
			if (request.getParameter("replyNo").trim().length() == 0) {
				forumReportService.addReport(postNo, null, informant, reportReason);
			} else {
				replyNo = Integer.valueOf(request.getParameter("replyNo"));
				forumReportService.addReport(null, replyNo, informant, reportReason);
			}
			message.put("success", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=" + page);
			writer.write(gson.toJson(message));
		}
	}
}