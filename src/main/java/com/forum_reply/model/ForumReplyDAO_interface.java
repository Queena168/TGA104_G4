package com.forum_reply.model;

import java.sql.SQLException;
import java.util.List;

import com.forum_post.model.ForumPostVO;

public interface ForumReplyDAO_interface {
	public void insert(ForumReplyVO forumReplyVO);

	public void update(ForumReplyVO forumReplyVO);

//	public void updatView(Integer view, Integer replyNo);

	public void delete(Integer replyNo) throws SQLException;

	public ForumReplyVO findByReplyNo(Integer replyNo);
	
	public ForumReplyVO findLastReplyTimeByReplyTo(Integer replyTo);
	
	public Integer findReplyCountByReplyTo(Integer replyTo);

	public List<ForumReplyVO> findByReplyTo(Integer replyTo);

	public List<ForumReplyVO> findByMemberNo(Integer memberNo);

	public List<ForumReplyVO> findByContent(String content);

	public List<ForumReplyVO> getAll();
}