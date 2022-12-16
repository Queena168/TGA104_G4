package com.forum_topic.model;

import java.sql.SQLException;
import java.util.List;

public interface ForumTopicDAO_interface {
	
	public void insert(ForumTopicVO forumTopicVO);

	public void update(ForumTopicVO forumTopicVO);

	public void delete(Integer topicNo) throws SQLException;

	public ForumTopicVO findByTopicNo(Integer topicNo);
	
	public List<ForumTopicVO> findByTopicName(String TopciName);

	public List<ForumTopicVO> getAll();
}