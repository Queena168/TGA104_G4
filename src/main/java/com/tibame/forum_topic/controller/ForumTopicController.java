package com.tibame.forum_topic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tibame.forum_topic.model.ForumTopicService;

@Controller
@RequestMapping("/back-end/forum")
public class ForumTopicController {

	@Autowired
	ForumTopicService forumTopicService;

	@ResponseBody
	@PostMapping("/addTopic")
	public String addTopic(Model model, String topicName, Integer adminNo) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (topicName.trim().length() == 0) {
			message.put("error", "請輸入名稱");
			return gson.toJson(message);
		}

		if (topicName.length() > 20) {
			message.put("error", "名稱請勿超過20字");
			return gson.toJson(message);
		}
		forumTopicService.addTopic(topicName, adminNo);
		message.put("success", "adminForumTopic.do");
		return gson.toJson(message);
	}

	@ResponseBody
	@PostMapping("/updateTopic")
	public String updateTopic(Model model, String topicName, Integer adminNo, Integer topicNo) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (topicName.trim().length() == 0) {
			message.put("error", "請輸入名稱");
			return gson.toJson(message);
		}

		if (topicName.length() > 20) {
			message.put("error", "名稱請勿超過20字");
			return gson.toJson(message);
		}

		forumTopicService.updateTopic(topicName, adminNo, topicNo);
		message.put("success", "adminForumTopic.do");
		return gson.toJson(message);
	}
}