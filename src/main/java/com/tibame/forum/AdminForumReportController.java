package com.tibame.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibame.forum_report.model.ForumReportService;
import com.tibame.forum_report.model.ForumReportVO;

@Controller
public class AdminForumReportController {

	@Autowired
	ForumReportService forumReportService;

	@RequestMapping("/back-end/forum/adminForumReport.do")
	public String handlerMethod(Model model, String listname, Integer page) {

		List<ForumReportVO> forumReportVOList = new ArrayList<ForumReportVO>();
		try {
			if (listname.equals("all")) {
				forumReportVOList = forumReportService.getAll();
			} else if (listname.equals("done")) {
				forumReportVOList = forumReportService.getReportByReportStatus("已處理");
			} else if (listname.equals("undone")) {
				forumReportVOList = forumReportService.getReportByReportStatus("未處理");
			}
		} catch (NullPointerException e) {
			forumReportVOList = forumReportService.getAll();
			listname = "all"; // 第一次進來無query string，設定listname = "all";
		}

		model.addAttribute("forumReportVOList", forumReportVOList);
		model.addAttribute("listname", listname);
		// 將取得的ReportVOList & listname 存入attribute

		// =====資料分頁=====
		if (page == null) {
			page = 1;
		}

		if (!forumReportVOList.isEmpty()) {
			int rowsPerPage = 5;
			int pageStart = Pagination.pagination(forumReportVOList, page, rowsPerPage)[0];
			int totalPage = Pagination.pagination(forumReportVOList, page, rowsPerPage)[1];
			model.addAttribute("pageStart", pageStart);
			model.addAttribute("pageEnd", pageStart + rowsPerPage - 1);
			model.addAttribute("totalPage", totalPage);
		} else {
			model.addAttribute("totalPage", 1);
		}
		// 宣告每頁5筆資料，從query string得到page，呼叫分頁方法pagination()，傳入參數為1.要分頁的list 2.目前頁數page
		// 3.每頁幾筆資料，得到陣列[0]=該分頁內資料起始索引，陣列[1]=總頁數，存入attribute

		return "/back-end/forum/adminForumReport.jsp?page=" + page + "&listname=" + listname;
	}
}