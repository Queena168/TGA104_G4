package com.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forum_post.model.ForumPostService;
import com.forum_post.model.ForumPostVO;
import com.forum_reply.model.ForumReplyService;
import com.forum_reply.model.ForumReplyVO;
import com.forum_topic.model.ForumTopicService;
import com.forum_topic.model.ForumTopicVO;

import redis.clients.jedis.Jedis;

@WebServlet("/front-end/forum/topic.do")
public class Topic extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
		// 從query string取得topicNo

		ForumTopicService forumTopicService = new ForumTopicService();
		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		request.setAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該討論區的TopicVO，存入attribute

		ForumPostService forumPostService = new ForumPostService();
		List<ForumPostVO> forumPostVOList = forumPostService.getPostsByTopicNo(topicNo);
		Collections.reverse(forumPostVOList);
		request.setAttribute("forumPostVOList", forumPostVOList);
		// 用topicNo取得該討論區的所有PostVO，存入attribute

		ForumReplyService forumReplyService = new ForumReplyService();
		List<ForumReplyVO> forumReplyVOList = new ArrayList<ForumReplyVO>();
		List<Integer> countList = new ArrayList<Integer>();
		List<Integer> viewList = new ArrayList<Integer>();

		for (ForumPostVO a : forumPostVOList) {
			forumReplyVOList.add(forumReplyService.getLastReplyTimeByReplyTo(a.getPostNo()));
		}
		request.setAttribute("forumReplyVOList", forumReplyVOList);
		// 從PostVO中得到postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的最新一篇回應，存入attribute

		for (ForumPostVO a : forumPostVOList) {
			countList.add(forumReplyService.getReplyCountByReplyTo(a.getPostNo()));
		}
		request.setAttribute("countList", countList);
		// 從PostVO中得到postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的總回應數，存入attribute

		Jedis jedis = new Jedis("localhost", 6379);
		for (ForumPostVO a : forumPostVOList) {
			if (jedis.zscore("viewZset", a.getPostNo().toString()) == null) {
				jedis.zadd("viewZset", 0, a.getPostNo().toString());
			}
			viewList.add(jedis.zscore("viewZset", a.getPostNo().toString()).intValue());
		}
		request.setAttribute("viewList", viewList);
		jedis.close();
		// 從PostVO中得到postNo作為Redis zset的member，取得該member的score，放到list存入attribute
		// 如果該member當下還不存在(例如新發文)，則新增該member/score設為0。

		// =====資料分頁=====
		if (!forumPostVOList.isEmpty()) {
			int rowsPerPage = 5;
			int page;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = 1;
			}
			int pageStart = Pagination.pagination(forumPostVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumPostVOList, page, rowsPerPage)[1];
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageStart + rowsPerPage - 1);
			request.setAttribute("totalPage", totalPage);
		}
		// 宣告每頁10筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/topic.jsp");
		successView.forward(request, response);
	}
}
