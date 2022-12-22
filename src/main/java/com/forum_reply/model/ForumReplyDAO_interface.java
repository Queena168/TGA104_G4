package com.forum_reply.model;

import java.util.List;

public interface ForumReplyDAO_interface {

	public void insert(ForumReplyVO forumReplyVO);

	public void update(ForumReplyVO forumReplyVO);

	public ForumReplyVO findLastReplyTimeByReplyTo(Integer replyTo);

	public Integer findReplyCountByReplyTo(Integer replyTo);

	public List<ForumReplyVO> findByReplyTo(Integer replyTo);

	public List<ForumReplyVO> getAll();
}