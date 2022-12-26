package com.tibame.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements Member_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/MatdesignDB?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = 
		"INSERT INTO member (memberAccount,memberPassword,memberName,nickName,gender,birthDate,activaction) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT =
		"SELECT memberNo,memberAccount,memberPassword,memberName,nickName,gender,birthDate,activaction FROM member order by memberNo";
	private static final String GET_ONE_STMT = 
		"SELECT memberNo,memberAccount,memberPassword,memberName,nickName,gender,birthDate,activaction FROM member where memberNo = ?";
	private static final String DELETE = 
		"DELETE FROM member where memberno = ?";
	private static final String UPDATE = 
		"UPDATE member set memberAccount=?, memberPassword=?, memberName=?, nickName=?, gender=?, birthDate=?, activaction=? where memberNo = ?";

	
	@Override
	public void update(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, memberVO.getMemberAccount());
			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(3, memberVO.getMemberName());
			pstmt.setString(4, memberVO.getNickName());
			pstmt.setString(5, memberVO.getGender());
			pstmt.setDate(6, memberVO.getBirthDate());
			pstmt.setBoolean(7, memberVO.getActivaction());
			pstmt.setInt(8, memberVO.getMemberNo());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer memberNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public MemberVO findByPrimaryKey(Integer memberNo) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("memberNo"));
				memberVO.setMemberAccount(rs.getString("memberAccount"));
				memberVO.setMemberPassword(rs.getString("memberPassword"));
				memberVO.setMemberName(rs.getString("memberName"));
				memberVO.setNickName(rs.getString("nickname"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthDate(rs.getDate("birthDate"));
				memberVO.setActivaction(rs.getBoolean("activaction"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("memberNo"));
				memberVO.setMemberAccount(rs.getString("memberAccount"));
				memberVO.setMemberPassword(rs.getString("memberPassword"));
				memberVO.setMemberName(rs.getString("memberName"));
				memberVO.setNickName(rs.getString("nickName"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthDate(rs.getDate("birthDate"));
				memberVO.setActivaction(rs.getBoolean("activaction"));
				list.add(memberVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
	@Override
	public void insert(MemberVO memberVO) {
		{

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setString(1, memberVO.getMemberAccount());
				pstmt.setString(2, memberVO.getMemberPassword());
				pstmt.setString(3, memberVO.getMemberName());
				pstmt.setString(4, memberVO.getNickName());
				pstmt.setString(5, memberVO.getGender());
				pstmt.setDate(6, memberVO.getBirthDate());
				pstmt.setBoolean(7, memberVO.getActivaction());

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
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

		
	}
	
	private static final String SELECT_FOR_LOGIN = 
			"select * from Member where memberAccount=? and memberPassword=?";
	
	public MemberVO memberLogin(MemberVO memberVO) {
		boolean status = false; // 利用布林值確認帳號密碼是否匹配 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT_FOR_LOGIN);
			
			pstmt.setString(1, memberVO.getMemberAccount());
			pstmt.setString(2, memberVO.getMemberPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				status = true;
				
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("memberNo"));
				memberVO.setMemberAccount(rs.getString("memberAccount"));
				memberVO.setMemberPassword(rs.getString("memberPassword"));
				memberVO.setMemberName(rs.getString("memberName"));
				memberVO.setNickName(rs.getString("nickName"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setBirthDate(rs.getDate("birthDate"));
				memberVO.setActivaction(rs.getBoolean("activaction"));
			}
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			// process sql exception
			se.printStackTrace(System.err);
		}
		
		
		
		return memberVO;
	}
	
	private static final String CHECK_MEMBERACCOUNT = 
			"select memberNo from Member where memberAccount = ?;";
	
	public Boolean accountUsed(String memberAccount) {
		Boolean used = null; // 裝判斷後結果
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(CHECK_MEMBERACCOUNT);
			pstmt.setString(1, memberAccount);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("memberNo"));
			}
			
			if(memberVO==null) {
				used = false;
				return used; // 帳號尚未被使用 
			}
			used = true; //帳號被使用過
			return used;
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	
	private static final String UPDATE_ACTIVACTION = 
			"UPDATE member set activaction=? where memberNo = ?;";
	
	public void updateActivaction(Integer memberNo, Boolean activaction) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ACTIVACTION);
			pstmt.setBoolean(1, activaction);
			pstmt.setInt(2, memberNo);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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

}