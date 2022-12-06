package com.forum_reply.model;

public class ForumReplyVO {
	private Integer replyNo;
	private Integer memberNo;
	private Integer replyTo;
	private String content;
	private java.util.Date replyTime;
	private java.util.Date modificationTime;
	private Integer view;

	public Integer getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Integer replyTo) {
		this.replyTo = replyTo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(java.util.Date replyTime) {
		this.replyTime = replyTime;
	}

	public java.util.Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(java.util.Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "ForumReplyVO [replyNo=" + replyNo + ", memberNo=" + memberNo + ", replyTo=" + replyTo + ", content="
				+ content + ", replyTime=" + replyTime + ", modificationTime=" + modificationTime + ", view=" + view
				+ "]";
	}

}