package com.tibame.forum;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/front-end/forum/posts.do")
public class PostController {

	@Autowired
	ForumPostService forumPostService;

	@Autowired
	ForumTopicService forumTopicService;

	@Autowired
	ForumReplyService forumReplyService;

	@GetMapping("")
	public String handlerMethod(Model model, @RequestParam("postNo") Integer postNo,
			@RequestParam("topicNo") Integer topicNo, @RequestParam("page") Integer page) {

		ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);
		model.addAttribute("forumPostVO", forumPostVO);
		// 用postNo取得該篇發文的PostVO，存入attribute

		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		model.addAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該篇發文所屬討論區的TopicVO，存入attribute

		List<ForumReplyVO> forumReplyVOList = forumReplyService.getReplyByReplyTo(postNo);
		model.addAttribute("forumReplyVOList", forumReplyVOList);
		// 以postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的所有回應ReplyVO，存入attribute

		ForumJedisDAO jedis = new ForumJedisDAO();
		jedis.setZset(postNo.toString());
		model.addAttribute("view", jedis.getZset(postNo.toString()));
		jedis.close();
		// 取得該篇文章存於Redis的瀏覽次數

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

		return "/front-end/forum/posts.jsp";
	}
}