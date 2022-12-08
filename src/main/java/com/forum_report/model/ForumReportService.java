package com.forum_report.model;

import java.util.List;

public class ForumReportService {

	private ForumReportDAO_interface dao;

	public ForumReportService() {
		dao = new ForumReportJDBCDAO();
	}

	public ForumReportVO addReport(Integer postNo, Integer replyNo, Integer informant, String reportReason) {
	ForumReportVO forumReportVO = new ForumReportVO();
	forumReportVO.setPostNo(postNo);
	forumReportVO.setReplyNo(replyNo);
	forumReportVO.setInformant(informant);
	forumReportVO.setReportReason(reportReason);
	
	dao.insertReport(forumReportVO);
	return forumReportVO;
}

//	public ForumReportVO addPostToReport(Integer postNo, Integer informant, String reportReason) {
//	ForumReportVO forumReportVO = new ForumReportVO();
//	forumReportVO.setPostNo(postNo);
//	forumReportVO.setInformant(informant);
//	forumReportVO.setReportReason(reportReason);
//	
//	dao.insertPostReport(forumReportVO);
//	return forumReportVO;
//}

//	public ForumReportVO addReplyToReport(Integer replyNo, Integer informant, String reportReason) {
//		ForumReportVO forumReportVO = new ForumReportVO();
//		forumReportVO.setReplyNo(replyNo);
//		forumReportVO.setInformant(informant);
//		forumReportVO.setReportReason(reportReason);
//		
//		dao.insertReplyReport(forumReportVO);
//		return forumReportVO;
//	}

	public ForumReportVO updateReportStatusAndReviewResult(Integer reviewer, String reportStatus, String reviewResult,
			Integer reportNo) {
		ForumReportVO forumReportVO = new ForumReportVO();
		forumReportVO.setReviewer(reviewer);
		forumReportVO.setReportStatus(reportStatus);
		forumReportVO.setReviewResult(reviewResult);
		forumReportVO.setReportNo(reportNo);

		dao.updateStatus(forumReportVO);
		return forumReportVO;
	}

	public void deleteReport(Integer reportNo) {
		dao.delete(reportNo);
	}

	public ForumReportVO getReportByReportNo(Integer reportNo) {
		return dao.findByReportNo(reportNo);
	}

	public List<ForumReportVO> getReportByReportStatus(String reportStatus) {
		return dao.findByReportStatus(reportStatus);
	}

	public List<ForumReportVO> getReportByReviewResult(String reviewResult) {
		return dao.findByReviewResult(reviewResult);
	}

	public List<ForumReportVO> getAll() {
		return dao.getAll();
	}
	
//	//test
//	public static void main(String[] args) {
//		ForumReportService forumReportService = new ForumReportService();
//		forumReportService.addReport(null, 2, 1, "hahah");
//	}
}
