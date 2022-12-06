package com.forum_topic.model;

public class ForumTopicVO {
	private Integer topicNo;
	private String topicName;
	private java.sql.Date startDate;
	private java.sql.Date modificationDate;
	private Integer adminNo;

	public Integer getTopicNo() {
		return topicNo;
	}

	public void setTopicNo(Integer topicNo) {
		this.topicNo = topicNo;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(java.sql.Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Integer getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}

	@Override
	public String toString() {
		return "ForumTopicVO [topicNo=" + topicNo + ", topicName=" + topicName + ", startDate=" + startDate
				+ ", modificationDate=" + modificationDate + ", adminNo=" + adminNo + "]";
	}

}