package com.forum_post.model;

import java.sql.SQLException;
import java.util.List;

public class ForumPostService {

	private ForumPostDAO_interface dao;

	public ForumPostService() {
		dao = new ForumPostJDBCDAO();
	}

	public ForumPostVO addPost(Integer memberNo, Integer topicNo, String title, String content) {
		ForumPostVO forumPostVO = new ForumPostVO();

		forumPostVO.setMemberNo(memberNo);
		forumPostVO.setTopicNo(topicNo);
		forumPostVO.setTitle(title);
		forumPostVO.setContent(content);
		dao.insert(forumPostVO);

		return forumPostVO;
	}

	public ForumPostVO updatePost(String title, String content, Integer postNo) {
		ForumPostVO forumPostVO = new ForumPostVO();

		forumPostVO.setTitle(title);
		forumPostVO.setContent(content);
		forumPostVO.setPostNo(postNo);
		dao.update(forumPostVO);
		return forumPostVO;
	}

	public void updatePostView(Integer view, Integer postNo) {
		dao.updateView(view, postNo);
	}

	public void deletePost(Integer postNo) throws SQLException {
		dao.delete(postNo);
	}

	public ForumPostVO getPostByPostNo(Integer postNo) {
		return dao.findByPostNo(postNo);
	}

	public ForumPostVO getLastPostTimeByTopicNo(Integer topicNo) {
		return dao.findLastPostTimeByTopicNo(topicNo);
	}
	
	public List<ForumPostVO> getPostsByTopicNo(Integer topicNo) {
		return dao.findPostByTopicNo(topicNo);
	}

	public List<ForumPostVO> getPostByMemberNo(Integer memberNo) {
		return dao.findByMemberNo(memberNo);
	}
	
	public List<ForumPostVO> getPostByKeyword(String keyword) {
	return dao.findByKeyword(keyword);
}

//	public List<ForumPostVO> getPostByTitle(String title) {
//		return dao.findByTitle(title);
//	}
//
//	public List<ForumPostVO> getPostByContent(String content) {
//		return dao.findByContent(content);
//	}

	public List<ForumPostVO> getAll() {
		return dao.getAll();
	}

}
