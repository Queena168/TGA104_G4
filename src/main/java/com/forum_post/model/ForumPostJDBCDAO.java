package com.forum_post.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumPostJDBCDAO implements ForumPostDAO_interface {

	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/db04?serverTimezone=Asia/Taipei";
	final String USER = "root";
	final String PASSWORD = "password";

	private static final String INSERT_STATEMENT = "INSERT INTO ForumPost (memberNo, topicNo, title, content) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE ForumPost SET title = ?, content = ?, modificationTime = now() WHERE postNo = ?";
//	private static final String UPDATEVIEW_STATEMENT = "UPDATE ForumPost SET view = ? WHERE postNo = ?";
	private static final String DELETE_STATEMENT = "DELETE FROM ForumPost WHERE postNo = ?";
	
	
	
//	private static final String FINDBYPOSTNO_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost WHERE postNo = ?";
	private static final String FINDBYPOSTNO_STATEMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo WHERE P.postNo = ?";
//	private static final String FINDBYMEMBERNO_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost FORUM_POST WHERE memberNo = ?";
	private static final String FINDBYMEMBERNO_STATEMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo WHERE P.memberNo = ?";
//	private static final String FINDBYKEYWORD_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost WHERE title LIKE ? OR content like ?";
	private static final String FINDBYKEYWORD_STATEMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo WHERE title LIKE ? OR content like ?";
//	private static final String GETALL_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost";
	private static final String GETALL_STATEMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo";
//	private static final String FINDBYPOSTTIME_STATAMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost WHERE topicNo = ? ORDER BY postTime DESC LIMIT 1";
	private static final String FINDBYPOSTTIME_STATAMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo WHERE topicNo = ? ORDER BY postTime DESC LIMIT 1";
//	private static final String FINDPOSTBYTOPICNO_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime FROM ForumPost WHERE topicNo = ?";
	private static final String FINDPOSTBYTOPICNO_STATEMENT = "SELECT DISTINCT P.postNo, P.memberNo, topicNo, title, content, postTime, modificationTime, nickName, reviewResult FROM ForumPost P LEFT JOIN Member M ON P.memberNo = M.memberNo LEFT JOIN ForumReport RP ON P.postNo = RP.postNo WHERE topicNo = ?";


	
//	private static final String FINDBYTITLE_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime, view FROM ForumPost WHERE title LIKE ?";
//	private static final String FINDBYCONTENT_STATEMENT = "SELECT postNo, memberNo, topicNo, title, content, postTime, modificationTime, view FROM ForumPost WHERE content LIKE ?";
	
	@Override
	public void insert(ForumPostVO forumPostVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(INSERT_STATEMENT)) {
			ps.setInt(1, forumPostVO.getMemberNo());
			ps.setInt(2, forumPostVO.getTopicNo());
			ps.setString(3, forumPostVO.getTitle());
			ps.setString(4, forumPostVO.getContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ForumPostVO forumPostVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(UPDATE_STATEMENT)) {
			ps.setString(1, forumPostVO.getTitle());
			ps.setString(2, forumPostVO.getContent());
			ps.setInt(3, forumPostVO.getPostNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public void updateView(Integer view, Integer postNo) {
//		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//				PreparedStatement ps = connection.prepareStatement(UPDATEVIEW_STATEMENT)) {
//			ps.setInt(1, view);
//			ps.setInt(2, postNo);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void delete(Integer postNo) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(DELETE_STATEMENT)) {
			ps.setInt(1, postNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public ForumPostVO findLastPostTimeByTopicNo(Integer topicNo) {
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYPOSTTIME_STATAMENT)) {
			ps.setInt(1, topicNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumPostVO;
	}

	@Override
	public List<ForumPostVO> findPostByTopicNo(Integer topicNo) {
		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDPOSTBYTOPICNO_STATEMENT)) {
			ps.setInt(1, topicNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumPostVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ForumPostVO findByPostNo(Integer postNo) {
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYPOSTNO_STATEMENT)) {
			ps.setInt(1, postNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumPostVO;
	}

	@Override
	public List<ForumPostVO> findByMemberNo(Integer memberNo) {
		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYMEMBERNO_STATEMENT)) {
			ps.setInt(1, memberNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumPostVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumPostVO> findByKeyword(String keyword) {
		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYKEYWORD_STATEMENT)) {
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumPostVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	@Override
//	public List<ForumPostVO> findByTitle(String title) {
//		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
//		ForumPostVO forumPostVO = null;
//		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//				PreparedStatement ps = connection.prepareStatement(FINDBYTITLE_STATEMENT)) {
//			ps.setString(1, "%" + title + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				forumPostVO = new ForumPostVO();
//				forumPostVO.setPostNo(rs.getInt("postNo"));
//				forumPostVO.setMemberNo(rs.getInt("memberNo"));
//				forumPostVO.setTopicNo(rs.getInt("topicNo"));
//				forumPostVO.setTitle(rs.getString("title"));
//				forumPostVO.setContent(rs.getString("content"));
//				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
//				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
//				forumPostVO.setView(rs.getInt("view"));
//				list.add(forumPostVO);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	@Override
//	public List<ForumPostVO> findByContent(String content) {
//		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
//		ForumPostVO forumPostVO = null;
//		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//				PreparedStatement ps = connection.prepareStatement(FINDBYCONTENT_STATEMENT)) {
//			ps.setString(1, "%" + content + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				forumPostVO = new ForumPostVO();
//				forumPostVO.setPostNo(rs.getInt("postNo"));
//				forumPostVO.setMemberNo(rs.getInt("memberNo"));
//				forumPostVO.setTopicNo(rs.getInt("topicNo"));
//				forumPostVO.setTitle(rs.getString("title"));
//				forumPostVO.setContent(rs.getString("content"));
//				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
//				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
//				forumPostVO.setView(rs.getInt("view"));
//				list.add(forumPostVO);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	@Override
	public List<ForumPostVO> getAll() {
		List<ForumPostVO> list = new ArrayList<ForumPostVO>();
		ForumPostVO forumPostVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(GETALL_STATEMENT)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumPostVO = new ForumPostVO();
				forumPostVO.setPostNo(rs.getInt("postNo"));
				forumPostVO.setMemberNo(rs.getInt("memberNo"));
				forumPostVO.setTopicNo(rs.getInt("topicNo"));
				forumPostVO.setTitle(rs.getString("title"));
				forumPostVO.setContent(rs.getString("content"));
				forumPostVO.setPostTime(rs.getTimestamp("postTime"));
				forumPostVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumPostVO.setNickName(rs.getString("nickName"));
				forumPostVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumPostVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	public static void main(String[] args) {
		ForumPostJDBCDAO dao = new ForumPostJDBCDAO();
//
//		// INSERT
//		ForumPostVO forumPostVO1 = new ForumPostVO();
//		forumPostVO1.setMemberNo(1);
//		forumPostVO1.setTopicNo(1);
//		forumPostVO1.setTitle("123");
//		forumPostVO1.setContent("hahahahaha");
//		dao.insert(forumPostVO1);
//
//		// UPDATE
//		ForumPostVO forumPostVO2 = new ForumPostVO();
//		forumPostVO2.setTitle("aaaaaaa");
//		forumPostVO2.setContent("hahahahaha");
//		forumPostVO2.setPostNo(3);
//		dao.update(forumPostVO2);
//		
//		// UPDATE VIEW
//		dao.updateView(500,2);
//
//		// DELETE
//		dao.delete(6);
//		// 有fk無法刪除
//
//		// FIND BY POST NO
//		ForumPostVO forumPostVO3 = dao.findByPostNo(1);
//		System.out.println(forumPostVO3);
//		System.out.println(forumPostVO3.getPostNo());
//		System.out.println(forumPostVO3.getMemberNo());
//		System.out.println(forumPostVO3.getTopicNo());
//		System.out.println(forumPostVO3.getTitle());
//		System.out.println(forumPostVO3.getContent());
//		System.out.println(forumPostVO3.getPostTime());
//		System.out.println(forumPostVO3.getView());
//		System.out.println("=====================");
//
//		// FIND BY MEMBER NO
//		List<ForumPostVO> list1 = dao.findByMemberNo(1);
//		for (ForumPostVO aForumPostVO : list1) {
//		System.out.println(aForumPostVO);
////			System.out.println(aForumPostVO.getPostNo());
////			System.out.println(aForumPostVO.getMemberNo());
////			System.out.println(aForumPostVO.getTopicNo());
////			System.out.println(aForumPostVO.getTitle());
////			System.out.println(aForumPostVO.getContent());
////			System.out.println(aForumPostVO.getPostTime());
////			System.out.println(aForumPostVO.getView());
//			System.out.println("=====================");
//		}
//
//		// FIND BY TITLE
//		List<ForumPostVO> list2 = dao.findByTitle("一");
//		for (ForumPostVO aForumPostVO : list2) {
//			System.out.println(aForumPostVO);
////			System.out.println(aForumPostVO.getPostNo());
////			System.out.println(aForumPostVO.getMemberNo());
////			System.out.println(aForumPostVO.getTopicNo());
////			System.out.println(aForumPostVO.getTitle());
////			System.out.println(aForumPostVO.getContent());
////			System.out.println(aForumPostVO.getPostTime());
////			System.out.println(aForumPostVO.getView());
//			System.out.println("=====================");
//		}
//
//		// FIND BY CONTENT
//		List<ForumPostVO> list3 = dao.findByContent("haha");
//		for (ForumPostVO aForumPostVO : list3) {
//			System.out.println(aForumPostVO);
////			System.out.println(aForumPostVO.getPostNo());
////			System.out.println(aForumPostVO.getMemberNo());
////			System.out.println(aForumPostVO.getTopicNo());
////			System.out.println(aForumPostVO.getTitle());
////			System.out.println(aForumPostVO.getContent());
////			System.out.println(aForumPostVO.getPostTime());
////			System.out.println(aForumPostVO.getView());
//			System.out.println("=====================");
//		}
//
//		// FIND ALL
//		List<ForumPostVO> list4 = dao.getAll();
//		for (ForumPostVO aForumPostVO : list4) {
//			System.out.println(aForumPostVO);
//			System.out.println(aForumPostVO.getPostNo());
//			System.out.println(aForumPostVO.getMemberNo());
//			System.out.println(aForumPostVO.getTopicNo());
//			System.out.println(aForumPostVO.getTitle());
//			System.out.println(aForumPostVO.getContent());
//			System.out.println(aForumPostVO.getPostTime());
//			System.out.println(aForumPostVO.getView());
//			System.out.println("=====================");
//		}
//
//		ForumPostVO forumpostVO = dao.findLastPostTimeByTopicNo(1);
//		System.out.println(forumpostVO.getMemberNo());
//		System.out.println(forumpostVO.getTitle());
//		System.out.println(forumpostVO.getPostTime());
//
//		// FIND BY keyword
//		List<ForumPostVO> list = dao.findByKeyword("redis");
//		for (ForumPostVO aForumPostVO : list) {
//			System.out.println(aForumPostVO);
//			System.out.println(aForumPostVO.getPostNo());
//			System.out.println(aForumPostVO.getMemberNo());
//			System.out.println(aForumPostVO.getTopicNo());
//			System.out.println(aForumPostVO.getTitle());
//			System.out.println(aForumPostVO.getContent());
//			System.out.println(aForumPostVO.getPostTime());
//			System.out.println("=====================");
//		}

	}
}