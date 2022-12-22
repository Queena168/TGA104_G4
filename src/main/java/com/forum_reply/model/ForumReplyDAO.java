package com.forum_reply.model;

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

public class ForumReplyDAO implements ForumReplyDAO_interface {

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
	public void insert(ForumReplyVO forumReplyVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO ForumReply (memberNo, replyTo, content) VALUES (?, ?, ?)")) {
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE ForumReply SET content = ?, modificationTime = now() WHERE replyNo = ?")) {
			ps.setString(1, forumReplyVO.getContent());
			ps.setInt(2, forumReplyVO.getReplyNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ForumReplyVO findLastReplyTimeByReplyTo(Integer replyTo) {
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT DISTINCT R.replyNo, R.memberNo, replyTo, content, replyTime, modificationTime, nickName, reviewResult FROM ForumReply R left join Member M on R.memberNo = M.memberNo left join ForumReport RP on R.replyNo = RP.replyNo WHERE replyTo = ? ORDER BY replyTime DESC LIMIT 1")) {
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
				forumReplyVO.setNickName(rs.getString("nickName"));
				forumReplyVO.setReviewResult(rs.getString("reviewResult"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forumReplyVO;
	}

	@Override
	public Integer findReplyCountByReplyTo(Integer replyTo) {
		Integer count = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT count(*) as count from ForumReply R left join Member M on R.memberNo = M.memberNo left join ForumReport RP on R.replyNo = RP.replyNo WHERE replyTo = ? GROUP BY replyTo")) {
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
	public List<ForumReplyVO> findByReplyTo(Integer replyTo) {
		List<ForumReplyVO> list = new ArrayList<ForumReplyVO>();
		ForumReplyVO forumReplyVO = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT DISTINCT R.replyNo, R.memberNo, replyTo, content, replyTime, modificationTime, nickName, reviewResult FROM ForumReply R left join Member M on R.memberNo = M.memberNo left join ForumReport RP on R.replyNo = RP.replyNo WHERE replyTo = ?")) {
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
				forumReplyVO.setNickName(rs.getString("nickName"));
				forumReplyVO.setReviewResult(rs.getString("reviewResult"));
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT DISTINCT R.replyNo, R.memberNo, replyTo, content, replyTime, modificationTime, nickName, reviewResult FROM ForumReply R left join Member M on R.memberNo = M.memberNo left join ForumReport RP on R.replyNo = RP.replyNo")) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				forumReplyVO = new ForumReplyVO();
				forumReplyVO.setReplyNo(rs.getInt("replyNo"));
				forumReplyVO.setMemberNo(rs.getInt("memberNo"));
				forumReplyVO.setReplyTo(rs.getInt("replyTo"));
				forumReplyVO.setContent(rs.getString("content"));
				forumReplyVO.setReplyTime(rs.getTimestamp("replyTime"));
				forumReplyVO.setModificationTime(rs.getTimestamp("modificationTime"));
				forumReplyVO.setNickName(rs.getString("nickName"));
				forumReplyVO.setReviewResult(rs.getString("reviewResult"));
				list.add(forumReplyVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}