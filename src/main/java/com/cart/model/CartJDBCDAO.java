package com.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CartJDBCDAO implements CartDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/matdesign?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
			"INSERT INTO Cart (memberNo, productNo, qty) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT cartNo, memberNo, productNo, qty FROM Cart order by cartNo";
		private static final String GET_ONE_STMT = 
			"SELECT cartNo, memberNo, productNo, qty FROM Cart where cartNo = ?";
		private static final String DELETE = 
			"DELETE FROM Cart where cartNo = ?";
		private static final String UPDATE = 
			"UPDATE Cart set memberNo=?, productNo=?, qty=? where cartNo = ?";
		
		@Override
		public void insert(CartVO cartVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, cartVO.getMemberNo());
				pstmt.setInt(2, cartVO.getProductNo());
				pstmt.setInt(3, cartVO.getQty());


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
		public void update(CartVO cartVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, cartVO.getMemberNo());
				pstmt.setInt(2, cartVO.getProductNo());
				pstmt.setInt(3, cartVO.getQty());
				pstmt.setInt(4, cartVO.getCartNo());
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
		public void delete(Integer cartNo) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, cartNo);
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
		public CartVO findByPrimaryKey(Integer cartNo) {

			CartVO cartVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, cartNo);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					cartVO = new CartVO();
					cartVO.setCartNo(rs.getInt("cartNo"));
					cartVO.setMemberNo(rs.getInt("memberNo"));
					cartVO.setProductNo(rs.getInt("productNo"));
					cartVO.setQty(rs.getInt("qty"));
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
			return cartVO;
		}

		@Override
		public List<CartVO> getAll() {
			List<CartVO> list = new ArrayList<CartVO>();
			CartVO cartVO = null;

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
					cartVO = new CartVO();
					cartVO.setCartNo(rs.getInt("cartNo"));
					cartVO.setMemberNo(rs.getInt("memberNo"));
					cartVO.setProductNo(rs.getInt("productNo"));
					cartVO.setQty(rs.getInt("qty"));
					list.add(cartVO); // Store the row in the list
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

		public static void main(String[] args) {

			CartJDBCDAO dao = new CartJDBCDAO();

			// 新增
//			CartVO cartVO = new CartVO();
//			cartVO.setMemberNo(1);
//			cartVO.setProductNo(1);
//			cartVO.setQty(10);
//			dao.insert(cartVO);

			// 修改
//			CartVO cartVO = new CartVO();
//			cartVO.setCartNo(1);
//			cartVO.setMemberNo(1);
//			cartVO.setProductNo(1);
//			cartVO.setQty(5);
//			dao.update(cartVO);
//
//			// 刪除
//			dao.delete(3);

			// 查詢
//			CartVO cartVO = dao.findByPrimaryKey(1);
//			System.out.print(cartVO.getCartNo() + ",");
//			System.out.print(cartVO.getMemberNo() + ",");
//			System.out.print(cartVO.getProductNo() + ",");
//			System.out.print(cartVO.getQty() + ",");
//			System.out.println("---------------------");
//
			// 查詢
//			List<CartVO> list = dao.getAll();
//			for (CartVO aCart : list) {
//				System.out.print(aCart.getCartNo() + ",");
//				System.out.print(aCart.getMemberNo() + ",");
//				System.out.print(aCart.getProductNo() + ",");
//				System.out.print(aCart.getQty() + ",");
//				System.out.println();
//			}
		}
}
