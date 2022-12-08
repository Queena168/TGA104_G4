package com.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_post.model.ForumPostService;
import com.forum_post.model.ForumPostVO;
import com.forum_topic.model.ForumTopicService;
import com.forum_topic.model.ForumTopicVO;

import redis.clients.jedis.Jedis;

@WebServlet("/front-end/forum/forumIndex.do")
public class ForumIndex extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ForumTopicService forumTopicService = new ForumTopicService();
		List<ForumTopicVO> forumTopicVOList = forumTopicService.getAll();
		request.setAttribute("forumTopicVOList", forumTopicVOList);
		// 取得所有討論區TopicVO，存入attribute

		ForumPostService forumPostService = new ForumPostService();
		List<ForumPostVO> forumPostVOList = new ArrayList<ForumPostVO>();

		for (ForumTopicVO a : forumTopicVOList) {
			forumPostVOList.add(forumPostService.getLastPostTimeByTopicNo(a.getTopicNo()));
		}
		request.setAttribute("forumPostVOList", forumPostVOList);
		// 從TopicVO中得到topicNo作為參數，用ForumPostService呼叫方法取得每個討論區的最新一篇文章，存入attribute

//		Map<String, String> map = new HashMap<String, String>();
//
//		Jedis jedis = new Jedis("localhost", 6379);
//		for (ForumPostVO a : forumPostService.getAll()) {
//			String view;
//			if (jedis.get("postNo:" + a.getPostNo() + ":view") == null) {
//				view = "0";
//			} else {
//				view = jedis.get("postNo:" + a.getPostNo() + ":view");
//			}
//			map.put(a.getPostNo().toString(), view);
//		}
//		jedis.close();


		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/forumIndex.jsp");
		successView.forward(request, response);
	}
}
