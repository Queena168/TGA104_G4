package com.forum_post.model;

import java.sql.SQLException;
import java.util.List;

public interface ForumPostDAO_interface {
	public void insert(ForumPostVO forumPostVO);

	public void update(ForumPostVO forumPostVO);
	
//	public void updateView(Integer view, Integer postNo);

	public void delete(Integer postNo) throws SQLException;

	public ForumPostVO findByPostNo(Integer postNo);
	
	public ForumPostVO findLastPostTimeByTopicNo(Integer topicNo);

	public List<ForumPostVO> findByMemberNo(Integer memberNo);

	public List<ForumPostVO> findPostByTopicNo(Integer topicNo);
	
//	public List<ForumPostVO> findByTitle(String title);
	
//	public List<ForumPostVO> findByContent(String content);
	
	public List<ForumPostVO> findByKeyword(String keyword);
	
	public List<ForumPostVO> getAll();
}