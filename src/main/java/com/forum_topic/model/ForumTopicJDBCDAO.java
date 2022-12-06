package com.forum_topic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumTopicJDBCDAO implements ForumTopicDAO_interface {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/db04?serverTimezone=Asia/Taipei";
	final String USER = "root";
	final String PASSWORD = "password";

	private static final String INSERT_STATEMENT = "INSERT INTO ForumTopic (topicName, adminNo) VALUES (?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE ForumTopic SET topicName = ?, adminNo = ?, modificationDate = now() WHERE topicNo = ?";
	private static final String DELETE_STATEMENT = "DELETE FROM ForumTopic WHERE topicNo = ?";
	private static final String FINDBYTOPICNO_STATEMENT = "SELECT topicNo, topicName, startDate, modificationDate, adminNo FROM ForumTopic WHERE topicNo = ?";
	private static final String FINDBYTOPICNAME_STATEMENT = "SELECT topicNo, topicName, startDate, modificationDate, adminNo FROM ForumTopic WHERE topicName LIKE ?";
	private static final String GETALL_STATEMENT = "SELECT topicNo, topicName, startDate, modificationDate, adminNo FROM ForumTopic ORDER BY startDate";

	@Override
	public void insert(ForumTopicVO forumTopicVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(INSERT_STATEMENT)) {
			ps.setString(1, forumTopicVO.getTopicName());
			ps.setInt(2, forumTopicVO.getAdminNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ForumTopicVO forumTopicVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(UPDATE_STATEMENT)) {
			ps.setString(1, forumTopicVO.getTopicName());
			ps.setInt(2, forumTopicVO.getAdminNo());
			ps.setInt(3, forumTopicVO.getTopicNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer topicNo) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(DELETE_STATEMENT)) {
			ps.setInt(1, topicNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumTopicVO findByTopicNo(Integer topicNo) {
		ForumTopicVO forumTopicVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYTOPICNO_STATEMENT)) {
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
	public List<ForumTopicVO> findByTopicName(String topicName) {
		List<ForumTopicVO> list = new ArrayList<ForumTopicVO>();
		ForumTopicVO forumTopicVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYTOPICNAME_STATEMENT)) {
			ps.setString(1, "%" + topicName + "%");
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

	@Override
	public List<ForumTopicVO> getAll() {
		List<ForumTopicVO> list = new ArrayList<ForumTopicVO>();
		ForumTopicVO forumTopicVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(GETALL_STATEMENT)) {
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

	public static void main(String[] args) {
		ForumTopicJDBCDAO dao = new ForumTopicJDBCDAO();

//		//INSERT
//		ForumTopicVO forumTopicVO1 = new ForumTopicVO();
//		forumTopicVO1.setTopicName("哈哈");
//		forumTopicVO1.setAdminNo(4);
//		dao.insert(forumTopicVO1);
//		
//		//UPDATE
//		ForumTopicVO forumTopicVO2 = new ForumTopicVO();
//		forumTopicVO2.setTopicName("嗚嗚嗚嗚");
//		forumTopicVO2.setAdminNo(5);
//		forumTopicVO2.setTopicNo(2);
//		dao.update(forumTopicVO2);
//		
//		//DELETE
//		dao.delete(4);
//	
//		//FIND BY TOPIC NO
//		ForumTopicVO forumTopicVO3 = dao.findByTopicNo(1);
////		System.out.println(forumTopicVO3);
////		System.out.println(forumTopicVO3.getTopicNo());
////		System.out.println(forumTopicVO3.getTopicName());
////		System.out.println(forumTopicVO3.getStartDate());
////		System.out.println(forumTopicVO3.getModificationDate());
////		System.out.println(forumTopicVO3.getAdminNo());
//		System.out.println("=====================");
//		
//		//FIND BY TOPIC NAME
//		List<ForumTopicVO> list1 = dao.findByTopicName("設計");
//		for(ForumTopicVO aForumTopicVO : list1) {
//			System.out.println(aForumTopicVO);
////			System.out.println(aForumTopicVO.getTopicNo());
////			System.out.println(aForumTopicVO.getTopicName());
////			System.out.println(aForumTopicVO.getStartDate());
////			System.out.println(aForumTopicVO.getModificationDate());
////			System.out.println(aForumTopicVO.getAdminNo());
//			System.out.println("=====================");
//		}
//	
//		//GET ALL
//		List<ForumTopicVO> list2 = dao.getAll();
//		for(ForumTopicVO aForumTopicVO : list2) {
//			System.out.println(aForumTopicVO);
////			System.out.println(aForumTopicVO.getTopicNo());
////			System.out.println(aForumTopicVO.getTopicName());
////			System.out.println(aForumTopicVO.getStartDate());
////			System.out.println(aForumTopicVO.getModificationDate());
////			System.out.println(aForumTopicVO.getAdminNo());
//			System.out.println("=====================");
//		}
	}
}
