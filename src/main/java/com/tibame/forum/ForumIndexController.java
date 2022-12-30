package com.tibame.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_post.model.ForumPostVO;
import com.tibame.forum_topic.model.ForumTopicService;
import com.tibame.forum_topic.model.ForumTopicVO;

@Controller
@RequestMapping("/front-end/forum/forumIndex.do")
public class ForumIndexController {

	@Autowired
	ForumTopicService forumTopicService;

	@Autowired
	ForumPostService forumPostService;

//	@Autowired
//	ForumJedisService forumJedisService;

	@GetMapping("")
	public String handlerMethod(Model model) {

		List<ForumTopicVO> forumTopicVOList = forumTopicService.getAll();
		model.addAttribute("forumTopicVOList", forumTopicVOList);
		// 取得所有討論區TopicVO，存入attribute

		List<ForumPostVO> forumPostVOList = new ArrayList<ForumPostVO>();
		for (ForumTopicVO a : forumTopicVOList) {
			forumPostVOList.add(forumPostService.getLastPostTimeByTopicNo(a.getTopicNo()));
		}
		model.addAttribute("forumPostVOList", forumPostVOList);
		// 從TopicVO中得到topicNo作為參數，用ForumPostService呼叫方法取得每個討論區的最新一篇文章，存入attribute

		List<ForumPostVO> hotList = new ArrayList<ForumPostVO>();
		List<Integer> viewList = new ArrayList<Integer>();

		ForumJedis jedis = new ForumJedis();
		for (String a : jedis.getTop5()) {
			hotList.add(forumPostService.getPostByPostNo(Integer.valueOf(a)));
			viewList.add(jedis.getZset(a));
		}
		jedis.close();
		model.addAttribute("hotList", hotList);
		model.addAttribute("viewList", viewList);
		// 取得Redis紀錄瀏覽次數的zset中瀏覽次數最高的1-5篇文章，將文章VO和瀏覽次數分別存到attribute

		return "/front-end/forum/forumIndex.jsp";
	}
}