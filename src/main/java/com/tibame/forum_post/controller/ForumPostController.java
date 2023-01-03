package com.tibame.forum_post.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_post.model.ForumPostVO;
import com.tibame.forum_topic.model.ForumTopicService;

@RestController
@RequestMapping("/front-end/forum")
public class ForumPostController {

	@Autowired
	ForumPostService forumPostService;

	@Autowired
	ForumTopicService forumTopicService;

	@PostMapping("search")
	public String search(Model model, HttpSession session, @RequestParam("keyword") String keyword) {
		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (keyword.trim().length() == 0) {
			message.put("error", "請輸入文字");
			return gson.toJson(message);
		}

		List<ForumPostVO> resultList = forumPostService.getPostByKeyword(keyword);
		List<String> topicNameList = new ArrayList<String>();
		if (!resultList.isEmpty()) {
			for (ForumPostVO a : resultList) {
				topicNameList.add(forumTopicService.getTopicByTopicNo(a.getTopicNo()).getTopicName());
			}
		}

		session.setAttribute("resultList", resultList);
		session.setAttribute("topicNameList", topicNameList);
		message.put("success", "searchResult.jsp");
		return gson.toJson(message);
	}

	@PostMapping("addPost")
	public String addPost(Model model, @RequestParam("memberNo") Integer memberNo,
			@RequestParam("topicNo") Integer topicNo, @RequestParam("title") String title,
			@RequestParam("content") String content) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		if (content.trim().length() == 0 && title.trim().length() == 0
				|| content.equals("<p><br></p>") && title.trim().length() == 0) {
			message.put("error", "請輸入標題及文章內容");
			return gson.toJson(message);
		}

		if (title.trim().length() == 0) {
			message.put("error", "請輸入標題");
			return gson.toJson(message);
		}

		if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
			message.put("error", "請輸入文章內容");
			return gson.toJson(message);
		}

		if (title.trim().length() > 50) {
			message.put("error", "標題請勿超過50個字");
			return gson.toJson(message);
		}

		forumPostService.addPost(memberNo, topicNo, title, content);
		message.put("success", "topic.do?topicNo=" + topicNo + "&page=1");
		return gson.toJson(message);
	}

	@PostMapping("updatePost")
	public String updatePost(Model model, @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("postNo") Integer postNo, @RequestParam("topicNo") Integer topicNo) {

		Map<String, String> message = new HashMap<String, String>();
		Gson gson = new Gson();

		// ============================ 修改 ============================

		if (content.trim().length() == 0 && title.trim().length() == 0
				|| content.equals("<p><br></p>") && title.trim().length() == 0) {
			message.put("error", "請輸入標題及文章內容");
			return gson.toJson(message);
		}

		if (title.trim().length() == 0) {
			message.put("error", "請輸入標題");
			return gson.toJson(message);
		}

		if (content.trim().length() == 0 || content.equals("<p><br></p>")) {
			message.put("error", "請輸入文章內容");
			return gson.toJson(message);
		}

		if (title.length() > 50) {
			message.put("error", "標題請勿超過50個字");
			return gson.toJson(message);
		}

		forumPostService.updatePost(title, content, postNo);
		message.put("updatesuccess", "posts.do?topicNo=" + topicNo + "&postNo=" + postNo + "&page=1");
		return gson.toJson(message);
	}
}