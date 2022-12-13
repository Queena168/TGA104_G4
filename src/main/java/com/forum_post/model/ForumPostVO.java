package com.forum_post.model;

public class ForumPostVO {
	private Integer postNo;
	private Integer memberNo;
	private Integer topicNo;
	private String title;
	private String content;
	private java.util.Date postTime;
	private java.util.Date modificationTime;
	private String nickName;
	private String reviewResult;

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getTopicNo() {
		return topicNo;
	}

	public void setTopicNo(Integer topicNo) {
		this.topicNo = topicNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getPostTime() {
		return postTime;
	}

	public void setPostTime(java.util.Date postTime) {
		this.postTime = postTime;
	}

	public java.util.Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(java.util.Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	@Override
	public String toString() {
		return "ForumPostVO [postNo=" + postNo + ", memberNo=" + memberNo + ", topicNo=" + topicNo + ", title=" + title
				+ ", content=" + content + ", postTime=" + postTime + ", modificationTime=" + modificationTime
				+ ", nickName=" + nickName + ", reviewResult=" + reviewResult + "]";
	}
}