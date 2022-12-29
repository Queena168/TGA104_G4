package com.tibame.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.forum_topic.model.ForumTopicService;
import com.tibame.forum_topic.model.ForumTopicVO;

@Controller
public class PostingController {

	@Autowired
	ForumTopicService forumTopicService;

	@RequestMapping("/front-end/forum/posting.do")
	public String handlerMethod(Model model, Integer topicNo) {

		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		model.addAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該討論區的TopicVO，存入attribute

		return "/front-end/forum/posting.jsp";
	}
}