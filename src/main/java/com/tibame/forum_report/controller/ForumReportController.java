package com.tibame.forum_report.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tibame.forum_report.model.ForumReportService;

@RestController
@RequestMapping({ "/front-end/forum", "/back-end/forum" })
public class ForumReportController {

	@Autowired
	ForumReportService forumReportService;

	@PostMapping("addReport")
	public String addReport(Model model, @RequestParam("postNo") Integer postNo,
			@RequestParam(required = false, value = "replyNo") Integer replyNo,
			@RequestParam("informant") Integer informant, @RequestParam("reportReason") String reportReason,
			@RequestParam("topicNo") Integer topicNo, @RequestParam("page") Integer page) {

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

	@PostMapping("updateReport")
	public String updateReport(Model model, @RequestParam("reviewer") Integer reviewer,
			@RequestParam("reviewResult") String reviewResult, @RequestParam("postNo") Integer postNo,
			@RequestParam("replyNo") Integer replyNo, @RequestParam("listname") String listname) {

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