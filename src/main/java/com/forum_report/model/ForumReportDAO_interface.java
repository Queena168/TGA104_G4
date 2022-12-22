package com.forum_report.model;

import java.util.List;

public interface ForumReportDAO_interface {
	
	public void insert(ForumReportVO forumReportVO);
	
	public void updateByPostNo(ForumReportVO forumReportVO);
	
	public void updateByReplyNo(ForumReportVO forumReportVO);
	
	public List<ForumReportVO> findByReportStatus(String reportStatus);
	
	public List<ForumReportVO> getAll();
}