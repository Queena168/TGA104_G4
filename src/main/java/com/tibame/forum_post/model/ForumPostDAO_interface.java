package com.tibame.forum_post.model;

import java.util.List;

public interface ForumPostDAO_interface {

	public void insert(ForumPostVO forumPostVO);

	public void update(ForumPostVO forumPostVO);

	public ForumPostVO findByPostNo(Integer postNo);

	public ForumPostVO findLastPostTimeByTopicNo(Integer topicNo);

	public List<ForumPostVO> findPostByTopicNo(Integer topicNo);

	public List<ForumPostVO> findByKeyword(String keyword);

	public List<ForumPostVO> getAll();
}