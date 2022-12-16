package com.forum_topic.model;

import java.sql.SQLException;
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

	public void deleteTopic(Integer topicNo) throws SQLException {
		dao.delete(topicNo);
	}

	public ForumTopicVO getTopicByTopicNo(Integer topicNo) {
		return dao.findByTopicNo(topicNo);
	}

	public List<ForumTopicVO> getTopicByTopicName(String topicName) {
		return dao.findByTopicName(topicName);
	}

	public List<ForumTopicVO> getAll() {
		return dao.getAll();
	}
}