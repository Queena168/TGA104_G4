package com.forum;

import java.io.IOException;
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

@WebServlet("/front-end/forum/posts.do")
public class Post extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Integer postNo = Integer.valueOf(request.getParameter("postNo"));
		Integer topicNo = Integer.valueOf(request.getParameter("topicNo"));
		// 從query string取得postNo和topicNo

		ForumPostService forumPostService = new ForumPostService();
		ForumTopicService forumTopicService = new ForumTopicService();

		ForumPostVO forumPostVO = forumPostService.getPostByPostNo(postNo);
		request.setAttribute("forumPostVO", forumPostVO);
		// 用postNo取得該篇發文的PostVO，存入attribute

		ForumTopicVO forumTopicVO = forumTopicService.getTopicByTopicNo(topicNo);
		request.setAttribute("forumTopicVO", forumTopicVO);
		// 用topicNo取得該篇發文所屬討論區的TopicVO，存入attribute

		ForumReplyService forumReplyService = new ForumReplyService();
		List<ForumReplyVO> forumReplyVOList = forumReplyService.getReplyByReplyTo(postNo);
		request.setAttribute("forumReplyVOList", forumReplyVOList);
		// 以postNo作為參數，用ForumReplyService呼叫方法取得每篇文章的所有回應ReplyVO，存入attribute

		Jedis jedis = new Jedis("localhost", 6379);
		jedis.incr("postNo:" + postNo + ":view");
		request.setAttribute("view", jedis.get("postNo:" + postNo + ":view"));
		jedis.close();
		// 用Jedis紀錄瀏覽次數，key為"postNo:" + postNo + ":view"，每進一次頁面value先自動加一，再取出存入attribute

		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/posts.jsp");
		successView.forward(request, response);
	}
}
