package com.tibame.cart.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class UserJDBCDAO {
	private static DataSource dataSource = null;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String GET_ONE_STMT =
			"SELECT memberNo, memberName, memberAccount, memberPassword from Member where memberAccount=? and memberPassword=?";
	private static final String GET_MEMBER_STMT = 
			"SELECT memberNo, memberName, memberAccount, memberPassword from Member where memberNo = ?";
	
	public User findByPrimaryKey(Integer memberNo) {
		User user = null;
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_MEMBER_STMT)) {
			pstmt.setInt(1, memberNo);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setUserNo(rs.getInt("memberNo"));
					user.setName(rs.getString("memberName"));
					user.setEmail(rs.getString("memberAccount"));
					user.setPassword(rs.getString("memberPassword"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    return user;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setUserNo(rs.getInt("memberNo"));
					user.setName(rs.getString("memberName"));
					user.setEmail(rs.getString("memberAccount"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
