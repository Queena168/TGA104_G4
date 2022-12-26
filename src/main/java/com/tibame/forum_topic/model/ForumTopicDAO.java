package com.tibame.forum_topic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ForumTopicDAO implements ForumTopicDAO_interface {

	private static DataSource dataSource = null;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(ForumTopicVO forumTopicVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO ForumTopic (topicName, adminNo) VALUES (?, ?)")) {
			ps.setString(1, forumTopicVO.getTopicName());
			ps.setInt(2, forumTopicVO.getAdminNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ForumTopicVO forumTopicVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE ForumTopic SET topicName = ?, adminNo = ?, modificationDate = now() WHERE topicNo = ?")) {
			ps.setString(1, forumTopicVO.getTopicName());
			ps.setInt(2, forumTopicVO.getAdminNo());
			ps.setInt(3, forumTopicVO.getTopicNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumTopicVO findByTopicNo(Integer topicNo) {
		ForumTopicVO forumTopicVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT topicNo, topicName, startDate, modificationDate, adminNo FROM ForumTopic WHERE topicNo = ?")) {
			ps.setInt(1, topicNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumTopicVO = new ForumTopicVO();
				forumTopicVO.setTopicNo(rs.getInt("topicNo"));
				forumTopicVO.setTopicName(rs.getString("topicName"));
				forumTopicVO.setStartDate(rs.getDate("startDate"));
				forumTopicVO.setModificationDate(rs.getDate("modificationDate"));
				forumTopicVO.setAdminNo(rs.getInt("adminNo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumTopicVO;
	}

	@Override
	public List<ForumTopicVO> getAll() {
		List<ForumTopicVO> list = new ArrayList<ForumTopicVO>();
		ForumTopicVO forumTopicVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT topicNo, topicName, startDate, modificationDate, adminNo FROM ForumTopic ORDER BY startDate")) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumTopicVO = new ForumTopicVO();
				forumTopicVO.setTopicNo(rs.getInt("topicNo"));
				forumTopicVO.setTopicName(rs.getString("topicName"));
				forumTopicVO.setStartDate(rs.getDate("startDate"));
				forumTopicVO.setModificationDate(rs.getDate("modificationDate"));
				forumTopicVO.setAdminNo(rs.getInt("adminNo"));
				list.add(forumTopicVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}