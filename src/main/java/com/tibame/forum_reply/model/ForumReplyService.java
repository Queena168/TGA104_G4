package com.tibame.forum_reply.model;

import java.util.List;

public class ForumReplyService {

	private ForumReplyDAO_interface dao;

	public ForumReplyService() {
		dao = new ForumReplyDAO();
	}

	public ForumReplyVO addReply(Integer memberNo, Integer replyTo, String content) {
		ForumReplyVO forumReplyVO = new ForumReplyVO();
		forumReplyVO.setMemberNo(memberNo);
		forumReplyVO.setReplyTo(replyTo);
		forumReplyVO.setContent(content);
		dao.insert(forumReplyVO);

		return forumReplyVO;
	}

	public ForumReplyVO updateReply(String content, Integer replyNo) {
		ForumReplyVO forumReplyVO = new ForumReplyVO();
		forumReplyVO.setContent(content);
		forumReplyVO.setReplyNo(replyNo);
		dao.update(forumReplyVO);

		return forumReplyVO;
	}

	public ForumReplyVO getLastReplyTimeByReplyTo(Integer replyTo) {
		return dao.findLastReplyTimeByReplyTo(replyTo);
	}

	public Integer getReplyCountByReplyTo(Integer replyTo) {
		return dao.findReplyCountByReplyTo(replyTo);
	}

	public List<ForumReplyVO> getReplyByReplyTo(Integer replyTo) {
		return dao.findByReplyTo(replyTo);
	}

	public List<ForumReplyVO> getAll() {
		return dao.getAll();
	}
}
