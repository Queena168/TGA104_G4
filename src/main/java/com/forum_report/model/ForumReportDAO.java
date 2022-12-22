package com.forum_report.model;

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
	public void updateByPostNo(ForumReportVO forumReportVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE ForumReport SET reviewer = ?, reportStatus = '已處理', reviewResult = ?, reviewTime = now() WHERE postNo = ?;")) {
			ps.setInt(1, forumReportVO.getReviewer());
			ps.setString(2, forumReportVO.getReviewResult());
			ps.setInt(3, forumReportVO.getPostNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateByReplyNo(ForumReportVO forumReportVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE ForumReport SET reviewer = ?, reportStatus = '已處理', reviewResult = ?, reviewTime = now() WHERE replyNo = ?;")) {
			ps.setInt(1, forumReportVO.getReviewer());
			ps.setString(2, forumReportVO.getReviewResult());
			ps.setInt(3, forumReportVO.getReplyNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ForumReportVO> findByReportStatus(String reportStatus) {
		List<ForumReportVO> list = new ArrayList<ForumReportVO>();
		ForumReportVO forumReportVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT reportNo, RP.postNo, RP.replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewreSult, P.Content postContent, R.Content replyContent FROM ForumReport RP LEFT JOIN ForumPost P ON RP.postNo = P.postNo LEFT JOIN ForumReply R ON RP.replyNo = R.replyNo WHERE reportStatus LIKE ?;")) {
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
				forumReportVO.setPostContent(rs.getString("postContent"));
				forumReportVO.setReplyContent(rs.getString("replyContent"));
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
						"SELECT reportNo, RP.postNo, RP.replyNo, informant, reviewer, reportReason, reportTime, reportStatus, reviewTime, reviewreSult, P.Content postContent, R.Content replyContent FROM ForumReport RP LEFT JOIN ForumPost P ON RP.postNo = P.postNo LEFT JOIN ForumReply R ON RP.replyNo = R.replyNo;")) {
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
				forumReportVO.setPostContent(rs.getString("postContent"));
				forumReportVO.setReplyContent(rs.getString("replyContent"));
				list.add(forumReportVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}