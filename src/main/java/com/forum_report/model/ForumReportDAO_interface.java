package com.forum_report.model;

import java.util.List;

public interface ForumReportDAO_interface {
	
	public void insert(ForumReportVO forumReportVO);
	
	public void update(ForumReportVO forumReportVO);
	
	public void delete(Integer reportNo);

	public ForumReportVO findByReportNo(Integer reportNo);
	
	public List<ForumReportVO> findByReportStatus(String reportStatus);
	
	public List<ForumReportVO> findByReviewResult(String reviewResult);

	public List<ForumReportVO> getAll();
}