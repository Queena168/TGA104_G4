package com.tibame.forum_report.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tibame.forum_report.model.ForumReportService;

@Controller
@RequestMapping({ "/front-end/forum", "/back-end/forum" })
public class ForumReportController {

	@Autowired
	ForumReportService forumReportService;

	@ResponseBody
	@PostMapping("addReport")
	public String addReport(Model model, Integer postNo, Integer replyNo, Integer informant, String reportReason,
			Integer topicNo, Integer page) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (reportReason.trim().length() == 0) {
			message.put("error", "請輸入檢舉內容");
			return gson.toJson(message);
		}
		if (reportReason.length() > 50) {
			message.put("error", "請勿超過50字");
			return gson.toJson(message);
		}
		if (replyNo == null) {
			forumReportService.addReport(postNo, null, informant, reportReason);
		} else {
			forumReportService.addReport(null, replyNo, informant, reportReason);
		}
		message.put("success", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=" + page);
		return gson.toJson(message);
	}

	@ResponseBody
	@PostMapping("updateReport")
	public String updateReport(Model model, Integer reviewer, String reviewResult, Integer postNo, Integer replyNo,
			String listname) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if ((reviewResult.trim()).length() == 0) {
			message.put("error", "請選擇");
			return gson.toJson(message);
		}

		if (replyNo == 0) {
			forumReportService.updateReportStatusByPostNo(reviewer, reviewResult, postNo);
		} else if (postNo == 0) {
			forumReportService.updateReportStatusByReplyNo(reviewer, reviewResult, replyNo);
		}
		message.put("success", "adminForumReport.do?listname=" + listname);
		return gson.toJson(message);
	}
}