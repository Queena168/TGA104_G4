package com.forum_reply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forum_post.model.ForumPostVO;

public class ForumReplyJDBCDAO implements ForumReplyDAO_interface {
	final String Driver = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/db04?serverTimezone=Asia/Taipei";
	final String USER = "root";
	final String PASSWORD = "password";

	private static final String INSERT_STATEMENT = "INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (?, ?, ?);";
	private static final String UPDATE_STATEMENT = "UPDATE ForumReply SET content = ?, modificationTime = now() WHERE replyNo = ?;";
	private static final String UPDATEVIEW_STATEMENT = "UPDATE ForumReply SET view = ? WHERE replyNo = ?;";
	private static final String DELETE_STATEMENT = "DELETE FROM ForumReply WHERE replyNo = ?;";
	private static final String FINDBYREPLYNO_STATEMENT = "SELECT replyNo, memberNo, replyTo, content, replyTime, modificationTime, view from ForumReply WHERE replyNo = ?;";
	private static final String FINDBYREPLYTO_STATEMENT = "SELECT replyNo, memberNo, replyTo, content, replyTime, modificationTime, view from ForumReply WHERE replyTo = ?;";
	private static final String FINDBYMEMBERNO_STATEMENT = "SELECT replyNo, memberNo, replyTo, content, replyTime, modificationTime, view from ForumReply WHERE memberNo = ?;";
	private static final String FINDBYCONTENT_STATEMENT = "SELECT replyNo, memberNo, replyTo, content, replyTime, modificationTime, view from ForumReply WHERE content LIKE ?;";
	private static final String GETALL_STATEMENT = "SELECT replyNo, memberNo, replyTo, content, replyTime, modificationTime, view from ForumReply ORDER BY replyTime;";
	private static final String FINDBYREPLYTIME_STATEMENT = "SELECT memberNo, replyTime from ForumReply WHERE replyTo = ? ORDER BY replyTime DESC LIMIT 1;";
	private static final String FINDBYREPLYCOUNT_STATEMENT = "SELECT count(*) as count from ForumReply WHERE replyTo = ? GROUP BY replyTo;";

	@Override
	public ForumReplyVO findLastReplyTimeByReplyTo(Integer replyTo) {
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPLYTIME_STATEMENT)) {
			ps.setInt(1, replyTo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumReplyVO;
	}

	@Override
	public Integer findReplyCountByReplyTo(Integer replyTo) {
		Integer count = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPLYCOUNT_STATEMENT)) {
			ps.setInt(1, replyTo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void insert(ForumReplyVO forumReplyVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(INSERT_STATEMENT)) {
			ps.setInt(1, forumReplyVO.getMemberNo());
			ps.setInt(2, forumReplyVO.getReplyTo());
			ps.setString(3, forumReplyVO.getContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ForumReplyVO forumReplyVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(UPDATE_STATEMENT)) {
			ps.setString(1, forumReplyVO.getContent());
			ps.setInt(2, forumReplyVO.getReplyNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatView(Integer view, Integer replyNo) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(UPDATEVIEW_STATEMENT)) {
			ps.setInt(1, view);
			ps.setInt(2, replyNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer replyNo) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(DELETE_STATEMENT)) {
			ps.setInt(1, replyNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumReplyVO findByReplyNo(Integer replyNo) {
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPLYNO_STATEMENT)) {
			ps.setInt(1, replyNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setView(rs.getInt("view"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumReplyVO;
	}

	@Override
	public List<ForumReplyVO> findByReplyTo(Integer replyTo) {
		List<ForumReplyVO> list = new ArrayList<ForumReplyVO>();
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPLYTO_STATEMENT)) {
			ps.setInt(1, replyTo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setView(rs.getInt("view"));
				list.add(forumReplyVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumReplyVO> findByMemberNo(Integer memberNo) {
		List<ForumReplyVO> list = new ArrayList<ForumReplyVO>();
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYMEMBERNO_STATEMENT)) {
			ps.setInt(1, memberNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setView(rs.getInt("view"));
				list.add(forumReplyVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumReplyVO> findByContent(String content) {
		List<ForumReplyVO> list = new ArrayList<ForumReplyVO>();
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYCONTENT_STATEMENT)) {
			ps.setString(1, "%" + content + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setView(rs.getInt("view"));
				list.add(forumReplyVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumReplyVO> getAll() {
		List<ForumReplyVO> list = new ArrayList<ForumReplyVO>();
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(GETALL_STATEMENT)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setView(rs.getInt("view"));
				list.add(forumReplyVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ForumReplyJDBCDAO dao = new ForumReplyJDBCDAO();

		ForumReplyVO forumReplyVO = dao.findLastReplyTimeByReplyTo(2);
		System.out.println(forumReplyVO.getMemberNo());
		System.out.println(forumReplyVO.getReplyTime());
		
		System.out.println(dao.findReplyCountByReplyTo(3));

//		//INSERT
//		ForumReplyVO forumReplyVO1 = new ForumReplyVO();
//		forumReplyVO1.setMemberNo(1);
//		forumReplyVO1.setReplyTo(4);
//		forumReplyVO1.setContent("replyyyyyyy!!!!!!!");
//		dao.insert(forumReplyVO1);
//	
//		//UPDATE
//		ForumReplyVO forumReplyVO2 = new ForumReplyVO();
//		forumReplyVO2.setContent("lol!");
//		forumReplyVO2.setReplyNo(4);
//		dao.update(forumReplyVO2);
//	
//		//UPDATE VIEW
//		dao.updatView(101, 2);
//		
//		//DELETE
//		dao.delete(8);
//		
//		//FIND BY REPLYNO
//		ForumReplyVO forumReplyVO3 = dao.findByReplyNo(3);
//		System.out.println(forumReplyVO3);
////		System.out.println(forumReplyVO3.getReplyNo());
////		System.out.println(forumReplyVO3.getMemberNo());
////		System.out.println(forumReplyVO3.getReplyTo());
////		System.out.println(forumReplyVO3.getContent());
////		System.out.println(forumReplyVO3.getContent());
////		System.out.println(forumReplyVO3.getReplyTime());
////		System.out.println(forumReplyVO3.getModificationTime());
////		System.out.println(forumReplyVO3.getView());
//		System.out.println("=====================");
//		
//		// FIND BY REPLY TO
//		List<ForumReplyVO> list1 = dao.findByReplyTo(1);
//		for (ForumReplyVO aforumReplyVO : list1) {
//			System.out.println(aforumReplyVO);
////			System.out.println(aforumReplyVO.getReplyNo());
////			System.out.println(aforumReplyVO.getMemberNo());
////			System.out.println(aforumReplyVO.getReplyTo());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getReplyTime());
////			System.out.println(aforumReplyVO.getModificationTime());
////			System.out.println(aforumReplyVO.getView());
//			System.out.println("=====================");
//		}

//		// FIND BY MEMBER NO
//		List<ForumReplyVO> list2 = dao.findByMemberNo(1);
//		for (ForumReplyVO aforumReplyVO : list2) {
//			System.out.println(aforumReplyVO);
////			System.out.println(aforumReplyVO.getReplyNo());
////			System.out.println(aforumReplyVO.getMemberNo());
////			System.out.println(aforumReplyVO.getReplyTo());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getReplyTime());
////			System.out.println(aforumReplyVO.getModificationTime());
////			System.out.println(aforumReplyVO.getView());
//			System.out.println("=====================");
//		}
//
//		// FIND BY CONTENT
//		List<ForumReplyVO> list3 = dao.findByContent("回應");
//		for (ForumReplyVO aforumReplyVO : list3) {
//			System.out.println(aforumReplyVO);
////			System.out.println(aforumReplyVO.getReplyNo());
////			System.out.println(aforumReplyVO.getMemberNo());
////			System.out.println(aforumReplyVO.getReplyTo());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getReplyTime());
////			System.out.println(aforumReplyVO.getModificationTime());
////			System.out.println(aforumReplyVO.getView());
//			System.out.println("=====================");
//		}
//		// GET ALL
//		List<ForumReplyVO> list4 = dao.getAll();
//		for (ForumReplyVO aforumReplyVO : list4) {
//			System.out.println(aforumReplyVO);
////			System.out.println(aforumReplyVO.getReplyNo());
////			System.out.println(aforumReplyVO.getMemberNo());
////			System.out.println(aforumReplyVO.getReplyTo());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getContent());
////			System.out.println(aforumReplyVO.getReplyTime());
////			System.out.println(aforumReplyVO.getModificationTime());
////			System.out.println(aforumReplyVO.getView());
//			System.out.println("=====================");
//		}
	}
}
