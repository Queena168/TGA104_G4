package com.forum_report.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumReportJDBCDAO implements ForumReportDAO_interface {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/db04?serverTimezone=Asia/Taipei";
	final String USER = "root";
	final String PASSWORD = "password";

//	private static final String INSERT_POSTREPORT_STATEMENT = "INSERT INTO ForumReport (postNo, informant, reportReason) VALUES (?, ?, ?)";
//	private static final String INSERT_REPLYREPORT_STATEMENT = "INSERT INTO ForumReport (replyNo, informant, reportReason) VALUES (?, ?, ?)";
	private static final String INSERT_REPORT_STATEMENT = "INSERT INTO ForumReport (postNo, replyNo, informant, reportReason) VALUES (?, ?, ?, ?)";
	private static final String UPDATESTATUS_STATEMENT = "UPDATE ForumReport SET reviewer = ?, reportStatus = ?, reviewResult = ?, reviewTime = now() WHERE reportNo = ?";
	private static final String DELETE_STATEMENT = "DELETE FROM ForumReport WHERE reportNo = ?";
	private static final String FINDBYREPORTNO_STATEMENT = "SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reportNo = ?";
	private static final String FINDBYREPORSTATUS_STATEMENT = "SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reportStatus LIKE ?";
	private static final String FINDBYREVIEWRESULT_STATEMENT = "SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reviewResult LIKE ?";
	private static final String GETALL_STATEMENT = "SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport ORDER BY reportTime";

	
	@Override
	public void insertReport(ForumReportVO forumReportVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(INSERT_REPORT_STATEMENT)) {
			ps.setObject(1, forumReportVO.getPostNo());
			ps.setObject(2, forumReportVO.getReplyNo());
			ps.setInt(3, forumReportVO.getInformant());
			ps.setString(4, forumReportVO.getReportReason());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	@Override
//	public void insertPostReport(ForumReportVO forumReportVO) {
//		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//				PreparedStatement ps = connection.prepareStatement(INSERT_POSTREPORT_STATEMENT)) {
//			ps.setInt(1, forumReportVO.getPostNo());
//			ps.setInt(2, forumReportVO.getInformant());
//			ps.setString(3, forumReportVO.getReportReason());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void insertReplyReport(ForumReportVO forumReportVO) {
//		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//				PreparedStatement ps = connection.prepareStatement(INSERT_REPLYREPORT_STATEMENT)) {
//			ps.setInt(1, forumReportVO.getReplyNo());
//			ps.setInt(2, forumReportVO.getInformant());
//			ps.setString(3, forumReportVO.getReportReason());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void updateStatus(ForumReportVO forumReportVO) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(UPDATESTATUS_STATEMENT)) {
			ps.setInt(1, forumReportVO.getReviewer());
			ps.setString(2, forumReportVO.getReportStatus());
			ps.setString(3, forumReportVO.getReviewResult());
			ps.setInt(4, forumReportVO.getReportNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer reportNo) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(DELETE_STATEMENT)) {
			ps.setInt(1, reportNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumReportVO findByReportNo(Integer reportNo) {
		ForumReportVO forumReportVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPORTNO_STATEMENT)) {
			ps.setInt(1, reportNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReportVO = new ForumReportVO();
				forumReportVO.setReportNo(rs.getInt("reportNo"));
				forumReportVO.setPostNo(rs.getInt("postNo"));
				forumReportVO.setReplyNo(rs.getInt("replyNo"));
				forumReportVO.setInformant(rs.getInt("informant"));
				forumReportVO.setReviewer(rs.getInt("reviewer"));
				forumReportVO.setReportReason(rs.getString("reportReason"));
				forumReportVO.setReportTime(rs.getTimestamp("reportTime"));
				forumReportVO.setReportStatus(rs.getString("reportStatus"));
				forumReportVO.setReviewTime(rs.getTimestamp("reviewTime"));
				forumReportVO.setReviewResult(rs.getString("reviewResult"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumReportVO;
	}

	@Override
	public List<ForumReportVO> findByReportStatus(String reportStatus) {
		List<ForumReportVO> list = new ArrayList<ForumReportVO>();
		ForumReportVO forumReportVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREPORSTATUS_STATEMENT)) {
			ps.setString(1, "%" + reportStatus + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReportVO = new ForumReportVO();
				forumReportVO.setReportNo(rs.getInt("reportNo"));
				forumReportVO.setPostNo(rs.getInt("postNo"));
				forumReportVO.setReplyNo(rs.getInt("replyNo"));
				forumReportVO.setInformant(rs.getInt("informant"));
				forumReportVO.setReviewer(rs.getInt("reviewer"));
				forumReportVO.setReportReason(rs.getString("reportReason"));
				forumReportVO.setReportTime(rs.getTimestamp("reportTime"));
				forumReportVO.setReportStatus(rs.getString("reportStatus"));
				forumReportVO.setReviewTime(rs.getTimestamp("reviewTime"));
				forumReportVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumReportVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumReportVO> findByReviewResult(String reviewResult) {
		List<ForumReportVO> list = new ArrayList<ForumReportVO>();
		ForumReportVO forumReportVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(FINDBYREVIEWRESULT_STATEMENT)) {
			ps.setString(1, "%" + reviewResult + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReportVO = new ForumReportVO();
				forumReportVO.setReportNo(rs.getInt("reportNo"));
				forumReportVO.setPostNo(rs.getInt("postNo"));
				forumReportVO.setReplyNo(rs.getInt("replyNo"));
				forumReportVO.setInformant(rs.getInt("informant"));
				forumReportVO.setReviewer(rs.getInt("reviewer"));
				forumReportVO.setReportReason(rs.getString("reportReason"));
				forumReportVO.setReportTime(rs.getTimestamp("reportTime"));
				forumReportVO.setReportStatus(rs.getString("reportStatus"));
				forumReportVO.setReviewTime(rs.getTimestamp("reviewTime"));
				forumReportVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumReportVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumReportVO> getAll() {
		List<ForumReportVO> list = new ArrayList<ForumReportVO>();
		ForumReportVO forumReportVO = null;
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = connection.prepareStatement(GETALL_STATEMENT)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReportVO = new ForumReportVO();
				forumReportVO.setReportNo(rs.getInt("reportNo"));
				forumReportVO.setPostNo(rs.getInt("postNo"));
				forumReportVO.setReplyNo(rs.getInt("replyNo"));
				forumReportVO.setInformant(rs.getInt("informant"));
				forumReportVO.setReviewer(rs.getInt("reviewer"));
				forumReportVO.setReportReason(rs.getString("reportReason"));
				forumReportVO.setReportTime(rs.getTimestamp("reportTime"));
				forumReportVO.setReportStatus(rs.getString("reportStatus"));
				forumReportVO.setReviewTime(rs.getTimestamp("reviewTime"));
				forumReportVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumReportVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ForumReportJDBCDAO dao = new ForumReportJDBCDAO();
		
//		//test
//		ForumReportVO forumReportVO = new ForumReportVO();
//		forumReportVO.setPostNo(2);
//		forumReportVO.setReplyNo(1);
//		forumReportVO.setInformant(2);
//		forumReportVO.setReportReason("lolo");
//		dao.insertReport(forumReportVO);

//		// INSERT POST REPORT
//		ForumReportVO forumReportVO1 = new ForumReportVO();
//		forumReportVO1.setPostNo(1);
//		forumReportVO1.setInformant(2);
//		forumReportVO1.setReportReason("hahahahaha");
//		dao.insertPostReport(forumReportVO1);
//		
//		// INSERT REPLY REPORT
//		ForumReportVO forumReportVO2 = new ForumReportVO();
//		forumReportVO2.setReplyNo(1);
//		forumReportVO2.setInformant(2);
//		forumReportVO2.setReportReason("bad");
//		dao.insertReplyReport(forumReportVO2);
//
//		//UPDATE STATUS
//		ForumReportVO forumReportVO3 = new ForumReportVO();
//		forumReportVO3.setReviewer(2);
//		forumReportVO3.setReportStatus("已處理");
//		forumReportVO3.setReviewResult("下架");
//		forumReportVO3.setReportNo(2);
//		dao.updateStatus(forumReportVO3);
//
//		//DELETE
//		dao.delete(12);
//
//		FIND BY REPORT NO
//		ForumReportVO forumReportVO4 = dao.findByReportNo(2);
//		System.out.println(forumReportVO4);
////		System.out.println(forumReportVO4.getReportNo());
////		System.out.println(forumReportVO4.getPostNo());
////		System.out.println(forumReportVO4.getReplyNo());
////		System.out.println(forumReportVO4.getInformant());
////		System.out.println(forumReportVO4.getReviewer());
////		System.out.println(forumReportVO4.getReportReason());
////		System.out.println(forumReportVO4.getReportTime());
////		System.out.println(forumReportVO4.getReportStatus());
////		System.out.println(forumReportVO4.getReviewTime());
////		System.out.println(forumReportVO4.getReviewResult());
//		System.out.println("=====================");
//
//		// FIND BY REPORT STATUS
//		List<ForumReportVO> list1 = dao.findByReportStatus("未處理");
//		for (ForumReportVO aforumReportVO : list1) {
//			System.out.println(aforumReportVO);
//			System.out.println(aforumReportVO.getReportNo());
//			System.out.println(aforumReportVO.getPostNo());
//			System.out.println(aforumReportVO.getReplyNo());
//			System.out.println(aforumReportVO.getInformant());
//			System.out.println(aforumReportVO.getReviewer());
//			System.out.println(aforumReportVO.getReportReason());
//			System.out.println(aforumReportVO.getReportTime());
//			System.out.println(aforumReportVO.getReportStatus());
//			System.out.println(aforumReportVO.getReviewTime());
//			System.out.println(aforumReportVO.getReviewResult());
//			System.out.println("=====================");
//		}
//
////		// FIND BY REVIEW RESULT
//		List<ForumReportVO> list2 = dao.findByReviewResult("下架");
//		for (ForumReportVO aforumReportVO : list2) {
//			System.out.println(aforumReportVO);
////			System.out.println(aforumReportVO.getReportNo());
////			System.out.println(aforumReportVO.getPostNo());
////			System.out.println(aforumReportVO.getReplyNo());
////			System.out.println(aforumReportVO.getInformant());
////			System.out.println(aforumReportVO.getReviewer());
////			System.out.println(aforumReportVO.getReportReason());
////			System.out.println(aforumReportVO.getReportTime());
////			System.out.println(aforumReportVO.getReportStatus());
////			System.out.println(aforumReportVO.getReviewTime());
////			System.out.println(aforumReportVO.getReviewResult());
//			System.out.println("=====================");
//		}
//
//		// FIND ALL
//		List<ForumReportVO> list3 = dao.getAll();
//		for (ForumReportVO aforumReportVO : list3) {
//			System.out.println(aforumReportVO);
////			System.out.println(aforumReportVO.getReportNo());
////			System.out.println(aforumReportVO.getPostNo());
////			System.out.println(aforumReportVO.getReplyNo());
////			System.out.println(aforumReportVO.getInformant());
////			System.out.println(aforumReportVO.getReviewer());
////			System.out.println(aforumReportVO.getReportReason());
////			System.out.println(aforumReportVO.getReportTime());
////			System.out.println(aforumReportVO.getReportStatus());
////			System.out.println(aforumReportVO.getReviewTime());
////			System.out.println(aforumReportVO.getReviewResult());
//			System.out.println("=====================");
//		}
	}

}
