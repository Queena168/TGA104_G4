package com.tibame.forum_topic.model;

import java.util.List;

public class ForumTopicService {
	private ForumTopicDAO_interface dao;

	public ForumTopicService() {
		dao = new ForumTopicDAO();
	}

	public ForumTopicVO addTopic(String topicName, Integer adminNo) {
		ForumTopicVO forumtopicVO = new ForumTopicVO();
		forumtopicVO.setTopicName(topicName);
		forumtopicVO.setAdminNo(adminNo);
		dao.insert(forumtopicVO);
		return forumtopicVO;
	}

	public ForumTopicVO updateTopic(String topicName, Integer adminNo, Integer topicNo) {
		ForumTopicVO forumtopicVO = new ForumTopicVO();
		forumtopicVO.setTopicName(topicName);
		forumtopicVO.setAdminNo(adminNo);
		forumtopicVO.setTopicNo(topicNo);
		dao.update(forumtopicVO);
		return forumtopicVO;
	}

	public ForumTopicVO getTopicByTopicNo(Integer topicNo) {
		return dao.findByTopicNo(topicNo);
	}

	public List<ForumTopicVO> getAll() {
		return dao.getAll();
	}
}