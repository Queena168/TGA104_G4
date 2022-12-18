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
		jedis.zincrby("viewZset", 1, postNo.toString());
		request.setAttribute("view", (jedis.zscore("viewZset", postNo.toString()).intValue()));
		jedis.close();
		// 用Redis zset紀錄瀏覽次數，key為"viewZset"，member為postNo，score為瀏覽次數，每次進入頁面score自動增加1
		// 再取出該member的score存入attribute

		// =====資料分頁=====
		if (!forumReplyVOList.isEmpty()) {
			int rowsPerPage = 5;
			int page;
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = 1;
			}
			int pageStart = Pagination.pagination(forumReplyVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumReplyVOList, page, rowsPerPage)[1];
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageStart + rowsPerPage - 1);
			request.setAttribute("totalPage", totalPage);
		}
		// 宣告每頁10筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		RequestDispatcher successView = request.getRequestDispatcher("/front-end/forum/posts.jsp");
		successView.forward(request, response);
	}
}
