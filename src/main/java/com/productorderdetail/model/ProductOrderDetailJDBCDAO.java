package com.productorderdetail.model;

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

import com.producttype.model.ProductTypeVO;



public class ProductOrderDetailJDBCDAO implements ProductOrderDetailDAO_interface{
	private static DataSource dataSource = null;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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

			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {
				pstmt.setInt(1, productOrderDetailVO.getOrderNo());
				pstmt.setInt(2, productOrderDetailVO.getProductNo());
				pstmt.setInt(3, productOrderDetailVO.getQty());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override
		public void update(ProductOrderDetailVO productOrderDetailVO) {

			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
				pstmt.setInt(1, productOrderDetailVO.getOrderNo());
				pstmt.setInt(2, productOrderDetailVO.getProductNo());
				pstmt.setInt(3, productOrderDetailVO.getQty());
				pstmt.setInt(4, productOrderDetailVO.getOrderDetailNo());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override
		public void delete(Integer orderNo) {
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(DELETE)) {
				pstmt.setInt(1, orderNo);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override    
		public ProductOrderDetailVO findByPrimaryKey(Integer orderNo) {

			ProductOrderDetailVO productOrderDetailVO = null;
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
				pstmt.setInt(1, orderNo);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						productOrderDetailVO = new ProductOrderDetailVO();
						productOrderDetailVO.setOrderDetailNo(rs.getInt("orderDetailNo"));
						productOrderDetailVO.setOrderNo(rs.getInt("orderNo"));
						productOrderDetailVO.setProductNo(rs.getInt("productNo"));
						productOrderDetailVO.setQty(rs.getInt("qty"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    return productOrderDetailVO;
		}

		@Override
		public List<ProductOrderDetailVO> getAll() {
			List<ProductOrderDetailVO> list = new ArrayList<ProductOrderDetailVO>();
			ProductOrderDetailVO productOrderDetailVO = null;
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT)) {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						// ProductTypeVO 也稱為 Domain objects
						productOrderDetailVO = new ProductOrderDetailVO();
						productOrderDetailVO.setOrderDetailNo(rs.getInt("orderDetailNo"));
						productOrderDetailVO.setOrderNo(rs.getInt("orderNo"));
						productOrderDetailVO.setProductNo(rs.getInt("productNo"));
						productOrderDetailVO.setQty(rs.getInt("qty"));
						list.add(productOrderDetailVO); // Store the row in the list
					}
				} catch (SQLException e) {
					e.printStackTrace();
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
