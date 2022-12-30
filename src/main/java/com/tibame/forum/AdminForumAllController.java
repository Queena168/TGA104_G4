package com.tibame.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.forum_post.model.ForumPostService;
import com.tibame.forum_reply.model.ForumReplyService;

@Controller
public class AdminForumAllController {

	@Autowired
	ForumPostService forumPostService;

	@Autowired
	ForumReplyService forumReplyService;

	@RequestMapping("/back-end/forum/adminForumAll.do")
	public String handlerMethod(Model model, String listname, Integer page) {

		List forumVOList = new ArrayList<>();
		try {
			if (listname.equals("post")) {
				forumVOList = forumPostService.getAll();
			} else if (listname.equals("reply")) {
				forumVOList = forumReplyService.getAll();
			}
		} catch (NullPointerException e) {
			forumVOList = forumPostService.getAll();
			listname = "post";
		}
		// 從query string取得listname，決定要呼叫的方法
		// 第一次進來無query string，設定listname = "post";

		model.addAttribute("forumVOList", forumVOList);
		model.addAttribute("listname", listname);
		// 將取得的VOList & listname 存入attribute

		// =====資料分頁=====
		if (page == null) {
			page = 1;
		}

		if (!forumVOList.isEmpty()) {
			int rowsPerPage = 5;
			int pageStart = Pagination.pagination(forumVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumVOList, page, rowsPerPage)[1];
			model.addAttribute("pageStart", pageStart);
			model.addAttribute("pageEnd", pageStart + rowsPerPage - 1);
			model.addAttribute("totalPage", totalPage);
		} else {
			model.addAttribute("totalPage", 1);
		}
		// 宣告每頁5筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		return "/back-end/forum/adminForumAll.jsp?page=" + page + "&listname=" + listname;
	}
}