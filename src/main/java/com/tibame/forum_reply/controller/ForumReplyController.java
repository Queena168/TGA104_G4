package com.tibame.forum_reply.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tibame.forum_reply.model.ForumReplyService;

@RestController
@RequestMapping("/front-end/forum")
public class ForumReplyController {

	@Autowired
	ForumReplyService forumReplyService;

	@PostMapping("addReply")
	public String addReply(Model model, @RequestParam("memberNo") Integer memberNo,
			@RequestParam("postNo") Integer postNo, @RequestParam("content") String content,
			@RequestParam("topicNo") Integer topicNo, Integer totalPage) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
			message.put("error", "請輸入文章內容");
			return gson.toJson(message);
		}
		forumReplyService.addReply(memberNo, postNo, content);
		message.put("success", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=" + totalPage);
		return gson.toJson(message);
	}

	@PostMapping("updateReply")
	public String updateReply(Model model, @RequestParam("content") String content,
			@RequestParam("replyNo") Integer replyNo, @RequestParam("topicNo") Integer topicNo,
			@RequestParam("postNo") Integer postNo, Integer page) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
			message.put("error", "請輸入文章內容");
			return gson.toJson(message);
		}

		forumReplyService.updateReply(content, replyNo);
		message.put("updatesuccess", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=" + page);
		return gson.toJson(message);
	}
}