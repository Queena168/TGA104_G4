package com.tibame.forum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_post.model.ForumPostVO;
import com.tibame.forum_reply.model.ForumReplyService;
import com.tibame.forum_reply.model.ForumReplyVO;
import com.tibame.forum_topic.model.ForumTopicService;
import com.tibame.forum_topic.model.ForumTopicVO;

@Controller
@RequestMapping("/front-end/forum/topic.do")
public class TopicController {

	@Autowired
	ForumTopicService forumTopicService;

	@Autowired
	ForumPostService forumPostService;

	@Autowired
	ForumReplyService forumReplyService;

	@Autowired
	ForumJedisService forumJedisService;

	@GetMapping("")
	public String handlerMethod(Model model, @RequestParam("topicNo") Integer topicNo,
			@RequestParam("page") Integer page) {

		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		model.addAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該討論區的TopicVO，存入attribute

		List<ForumPostVO> forumPostVOList = forumPostService.getPostsByTopicNo(topicNo);
		Collections.reverse(forumPostVOList);
		model.addAttribute("forumPostVOList", forumPostVOList);
		// 用topicNo取得該討論區的所有PostVO，存入attribute

		List<ForumReplyVO> forumReplyVOList = new ArrayList<ForumReplyVO>();
		List<Integer> countList = new ArrayList<Integer>();
		List<Integer> viewList = new ArrayList<Integer>();

		for (ForumPostVO a : forumPostVOList) {
			forumReplyVOList.add(forumReplyService.getLastReplyTimeByReplyTo(a.getPostNo()));
		}
		model.addAttribute("forumReplyVOList", forumReplyVOList);
		// 從PostVO中得到postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的最新一篇回應，存入attribute

		for (ForumPostVO a : forumPostVOList) {
			countList.add(forumReplyService.getReplyCountByReplyTo(a.getPostNo()));
		}
		model.addAttribute("countList", countList);
		// 從PostVO中得到postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的總回應數，存入attribute

		for (ForumPostVO a : forumPostVOList) {
			viewList.add(forumJedisService.getZset(a.getPostNo().toString()).intValue());
		}
		model.addAttribute("viewList", viewList);
		forumJedisService.close();
		// 取得存於Redis的各文章瀏覽次數

		// =====資料分頁=====
		if (page == null) {
			page = 1;
		}

		if (!forumReplyVOList.isEmpty()) {
			int rowsPerPage = 5;
			int pageStart = Pagination.pagination(forumReplyVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumReplyVOList, page, rowsPerPage)[1];
			model.addAttribute("pageStart", pageStart);
			model.addAttribute("pageEnd", pageStart + rowsPerPage - 1);
			model.addAttribute("totalPage", totalPage);
		} else {
			model.addAttribute("totalPage", 1);
		}
		// 宣告每頁5筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		return "/front-end/forum/topic.jsp";
	}
}