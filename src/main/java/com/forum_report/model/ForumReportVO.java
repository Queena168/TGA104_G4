package com.forum_report.model;

public class ForumReportVO {
	private Integer reportNo;
	private Integer postNo;
	private Integer replyNo;
	private Integer informant;
	private Integer reviewer;
	private String reportReason;
	private java.util.Date reportTime;
	private String reportStatus;
	private java.util.Date reviewTime;
	private String reviewResult;

	public Integer getReportNo() {
		return reportNo;
	}

	public void setReportNo(Integer reportNo) {
		this.reportNo = reportNo;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public Integer getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}

	public Integer getInformant() {
		return informant;
	}

	public void setInformant(Integer informant) {
		this.informant = informant;
	}

	public Integer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Integer reviewer) {
		this.reviewer = reviewer;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public java.util.Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(java.util.Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public java.util.Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(java.util.Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	@Override
	public String toString() {
		return "ForumReportVO [reportNo=" + reportNo + ", postNo=" + postNo + ", replyNo=" + replyNo + ", informant="
				+ informant + ", reviewer=" + reviewer + ", reportReason=" + reportReason + ", reportTime=" + reportTime
				+ ", reportStatus=" + reportStatus + ", reviewTime=" + reviewTime + ", reviewResult=" + reviewResult
				+ "]";
	}
}