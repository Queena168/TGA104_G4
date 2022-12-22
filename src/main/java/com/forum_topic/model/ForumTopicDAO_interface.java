package com.forum_topic.model;

import java.util.List;

public interface ForumTopicDAO_interface {
	
	public void insert(ForumTopicVO forumTopicVO);

	public void update(ForumTopicVO forumTopicVO);

	public ForumTopicVO findByTopicNo(Integer topicNo);
	
	public List<ForumTopicVO> getAll();
}