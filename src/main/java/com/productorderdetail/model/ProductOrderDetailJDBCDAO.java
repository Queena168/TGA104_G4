package com.productorderdetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductOrderDetailJDBCDAO implements ProductOrderDetailDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/matdesign?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	
	private static final String INSERT_STMT = 
			"INSERT INTO ProductOrderDetail (orderNo, productNo, qty) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT orderDetailNo, orderNo, productNo, qty FROM ProductOrderDetail order by orderDetailNo";
		private static final String GET_ONE_STMT = 
			"SELECT orderDetailNo, orderNo, productNo, qty FROM ProductOrderDetail where orderDetailNo = ?";
		private static final String DELETE = 
			"DELETE FROM ProductOrderDetail where orderDetailNo = ?";
		private static final String UPDATE = 
			"UPDATE ProductOrderDetail set orderNo=?, productNo=?, qty=? where orderDetailNo = ?";
		
		@Override
		public void insert(ProductOrderDetailVO productOrderDetailVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, productOrderDetailVO.getOrderNo());
				pstmt.setInt(2, productOrderDetailVO.getProductNo());
				pstmt.setInt(3, productOrderDetailVO.getQty());

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
		public void update(ProductOrderDetailVO productOrderDetailVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, productOrderDetailVO.getOrderNo());
				pstmt.setInt(2, productOrderDetailVO.getProductNo());
				pstmt.setInt(3, productOrderDetailVO.getQty());
				pstmt.setInt(4, productOrderDetailVO.getOrderDetailNo());
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
		public void delete(Integer orderNo) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, orderNo);
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
		public ProductOrderDetailVO findByPrimaryKey(Integer orderNo) {

			ProductOrderDetailVO productOrderDetailVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, orderNo);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					productOrderDetailVO = new ProductOrderDetailVO();
					productOrderDetailVO.setOrderDetailNo(rs.getInt("orderDetailNo"));
					productOrderDetailVO.setOrderNo(rs.getInt("orderNo"));
					productOrderDetailVO.setProductNo(rs.getInt("productNo"));
					productOrderDetailVO.setQty(rs.getInt("qty"));
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
			return productOrderDetailVO;
		}

		@Override
		public List<ProductOrderDetailVO> getAll() {
			List<ProductOrderDetailVO> list = new ArrayList<ProductOrderDetailVO>();
			ProductOrderDetailVO productOrderDetailVO = null;

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
					productOrderDetailVO = new ProductOrderDetailVO();
					productOrderDetailVO.setOrderDetailNo(rs.getInt("orderDetailNo"));
					productOrderDetailVO.setOrderNo(rs.getInt("orderNo"));
					productOrderDetailVO.setProductNo(rs.getInt("productNo"));
					productOrderDetailVO.setQty(rs.getInt("qty"));
					list.add(productOrderDetailVO); // Store the row in the list
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

			ProductOrderDetailJDBCDAO dao = new ProductOrderDetailJDBCDAO();

			// 新增
//			ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
//			productOrderDetailVO.setOrderNo(1);
//			productOrderDetailVO.setProductNo(1);
//			productOrderDetailVO.setQty(20);
//			dao.insert(productOrderDetailVO);

			// 修改
//			ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
//			productOrderDetailVO.setOrderDetailNo(1);
//			productOrderDetailVO.setOrderNo(1);
//			productOrderDetailVO.setProductNo(1);
//			productOrderDetailVO.setQty(30);
//			dao.update(productOrderDetailVO);
//
//			// 刪除
//			dao.delete(1);

			// 查詢
//			ProductOrderDetailVO productOrderDetailVO = dao.findByPrimaryKey(1);
//			System.out.print(productOrderDetailVO.getOrderDetailNo() + ",");
//			System.out.print(productOrderDetailVO.getOrderNo() + ",");
//			System.out.print(productOrderDetailVO.getProductNo() + ",");
//			System.out.print(productOrderDetailVO.getQty() + ",");
//			System.out.println("---------------------");

			// 查詢
//			List<ProductOrderDetailVO> list = dao.getAll();
//			for (ProductOrderDetailVO aProductOrderDetail : list) {
//				System.out.print(aProductOrderDetail.getOrderDetailNo() + ",");
//				System.out.print(aProductOrderDetail.getOrderNo() + ",");
//				System.out.print(aProductOrderDetail.getProductNo() + ",");
//				System.out.print(aProductOrderDetail.getQty() + ",");
//				System.out.println();
//			}
		}
}
