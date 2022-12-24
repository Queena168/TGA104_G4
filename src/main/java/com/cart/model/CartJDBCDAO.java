package com.cart.model;

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



public class CartJDBCDAO implements CartDAO_interface{
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
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {
				pstmt.setInt(1, cartVO.getMemberNo());
				pstmt.setInt(2, cartVO.getProductNo());
				pstmt.setInt(3, cartVO.getQty());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override
		public void update(CartVO cartVO) {
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
				pstmt.setInt(1, cartVO.getMemberNo());
				pstmt.setInt(2, cartVO.getProductNo());
				pstmt.setInt(3, cartVO.getQty());
				pstmt.setInt(4, cartVO.getCartNo());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override
		public void delete(Integer cartNo) {

			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(DELETE)) {
				pstmt.setInt(1, cartNo);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		@Override    
		public CartVO findByPrimaryKey(Integer cartNo) {

			CartVO cartVO = null;
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
				pstmt.setInt(1, cartNo);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						cartVO = new CartVO();
						cartVO.setCartNo(rs.getInt("cartNo"));
						cartVO.setMemberNo(rs.getInt("memberNo"));
						cartVO.setProductNo(rs.getInt("productNo"));
						cartVO.setQty(rs.getInt("qty"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    return cartVO;
		}

		@Override
		public List<CartVO> getAll() {
			List<CartVO> list = new ArrayList<CartVO>();
			CartVO cartVO = null;
			
			try (Connection connection = dataSource.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT)) {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						cartVO = new CartVO();
						cartVO.setCartNo(rs.getInt("cartNo"));
						cartVO.setMemberNo(rs.getInt("memberNo"));
						cartVO.setProductNo(rs.getInt("productNo"));
						cartVO.setQty(rs.getInt("qty"));
						list.add(cartVO); // Store the row in the list
					}
				} catch (SQLException e) {
					e.printStackTrace();
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
