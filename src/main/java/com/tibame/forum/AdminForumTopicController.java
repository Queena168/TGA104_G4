package com.tibame.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.admin.model.AdminService;
import com.tibame.admin.model.AdminVO;
import com.tibame.forum_topic.model.ForumTopicService;
import com.tibame.forum_topic.model.ForumTopicVO;

@Controller
public class AdminForumTopicController {

	@Autowired
	ForumTopicService forumTopicService;

	@RequestMapping("/back-end/forum/adminForumTopic.do")
	public String handlerMethod(Model model) {

		List<ForumTopicVO> forumTopicVOList = forumTopicService.getAll();
		model.addAttribute("forumTopicVOList", forumTopicVOList);
		// 取得所有討論區TopicVO，存入attribute

		AdminService adminService = new AdminService();
		List<AdminVO> adminVOList = adminService.getAll();
		model.addAttribute("adminVOList", adminVOList);
		// 取得所有管理員AdminVO，存入attribute

		return "/back-end/forum/adminForumTopic.jsp";
	}
}