package com.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.model.ProductJDBCDAO;
import com.product.model.ProductVO;

public class UserJDBCDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/matdesign?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String GET_ONE_STMT =
			"SELECT memberNo, memberName, memberEmail, memberPassword from Member where memberEmail=? and memberPassword=?";
	private static final String GET_MEMBER_STMT = 
			"SELECT memberNo, memberName, email, password from Member where userNo = ?";
	
	public User findByPrimaryKey(Integer memberNo) {

		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_MEMBER_STMT);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				user = new User();
				user.setUserNo(rs.getInt("memberNo"));
				user.setName(rs.getString("memberName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return user;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserNo(rs.getInt("memberNo"));
				user.setName(rs.getString("memberName"));
				user.setEmail(rs.getString("memberEmail"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return user;
	}
	
	public static void main(String[] args) {
		UserJDBCDAO dao = new UserJDBCDAO();
		
		// 查詢
//		User user = dao.userLogin("123@gmail.com", "123");		
//		System.out.print(user.getUserNo() + ",");
//		System.out.print(user.getName() + ",");
//		System.out.print(user.getEmail() + ",");
		
	}	
		
}
