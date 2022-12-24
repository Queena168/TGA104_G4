package com.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
//		session.removeAttribute("account");
//		session.removeAttribute("memberNo");
		session.setAttribute("account", "ma");
		session.setAttribute("memberNo", 3);

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

		Jedis jedis = new Jedis("localhost", 6379);
		List<ForumPostVO> hotList = new ArrayList<ForumPostVO>();
		List<Integer> viewList = new ArrayList<Integer>();
		for (String a : jedis.zrevrange("viewZset", 0, 4)) {
			hotList.add(forumPostService.getPostByPostNo(Integer.valueOf(a)));
			viewList.add(jedis.zscore("viewZset", a).intValue());
		}
		jedis.close();
		request.setAttribute("hotList", hotList);
		request.setAttribute("viewList", viewList);
		// 取得Redis紀錄瀏覽次數的zset中瀏覽次數最高的1-5篇文章，將文章VO和瀏覽次數分別存到attribute

		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/forumIndex.jsp");
		successView.forward(request, response);
	}
}