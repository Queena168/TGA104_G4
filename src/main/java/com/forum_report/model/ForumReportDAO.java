package com.forum_report.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ForumReportDAO implements ForumReportDAO_interface {
	
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
	public void insert(ForumReportVO forumReportVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO ForumReport (postNo, replyNo, informant, reportReason) VALUES (?, ?, ?, ?);")) {
			ps.setObject(1, forumReportVO.getPostNo());
			ps.setObject(2, forumReportVO.getReplyNo());
			ps.setInt(3, forumReportVO.getInformant());
			ps.setString(4, forumReportVO.getReportReason());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ForumReportVO forumReportVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE ForumReport SET reviewer = ?, reportStatus = ?, reviewResult = ?, reviewTime = now() WHERE reportNo = ?;")) {
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement("DELETE FROM ForumReport WHERE reportNo = ?;")) {
			ps.setInt(1, reportNo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumReportVO findByReportNo(Integer reportNo) {
		ForumReportVO forumReportVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reportNo = ?;")) {
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reportStatus LIKE ?;")) {
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport WHERE reviewResult LIKE ?;")) {
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT reportNo, postNo, replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewResult FROM ForumReport ORDER BY reportTime;")) {
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
}