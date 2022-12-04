package com.chatmessage.model;

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



public class ChatMessageDAO implements ChatMessageDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"insert into ChatMessage (chatNo, message, sendTime, sender) values (?, ?, now(), ?)";
	private static final String GET_ALL_STMT = 
			"select messageNo, chatNo, message, sendTime, sender from ChatMessage order by messageNo";
	private static final String GET_ONE_STMT = 
			"select messageNo, chatNo, message, sendTime, sender from ChatMessage where messageNo=?";
	private static final String DELETE = 
			"delete from ChatMessage where messageNo=?";
	private static final String UPDATE = 
			"update ChatMessage set message=? where messageNo=?";
	
	@Override
	public void insert(ChatMessageVO chatMessageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, chatMessageVO.getChatNo());
			pstmt.setString(2, chatMessageVO.getMessage());
			pstmt.setBoolean(3, chatMessageVO.getSender());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public void update(ChatMessageVO chatMessageVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, chatMessageVO.getMessage());
			pstmt.setBoolean(2, chatMessageVO.getSender());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public void delete(Integer messageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, messageNo);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public ChatMessageVO findByPrimaryKey(Integer messageNo) {
		
		ChatMessageVO chatMessageVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, messageNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				chatMessageVO = new ChatMessageVO();
				chatMessageVO.setMessageNo(rs.getInt("messageNo"));
				chatMessageVO.setChatNo(rs.getInt("chatNo"));
				chatMessageVO.setMessage(rs.getString("message"));
				chatMessageVO.setSendTime(rs.getTimestamp("sendTime"));
				chatMessageVO.setSender(rs.getBoolean("sender"));
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		return chatMessageVO;
	}
	@Override
	public List<ChatMessageVO> getAll() {
		List<ChatMessageVO> list = new ArrayList<ChatMessageVO>();
		ChatMessageVO chatMessageVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				chatMessageVO = new ChatMessageVO();
				chatMessageVO.setMessageNo(rs.getInt("messageNo"));
				chatMessageVO.setChatNo(rs.getInt("chatNo"));
				chatMessageVO.setMessage(rs.getString("message"));
				chatMessageVO.setSendTime(rs.getTimestamp("sendTime"));
				chatMessageVO.setSender(rs.getBoolean("sender"));
				list.add(chatMessageVO);
				
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
}
