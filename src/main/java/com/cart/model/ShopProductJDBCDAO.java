package com.cart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.product.model.ProductVO;

public class ShopProductJDBCDAO implements ShopProductDAOInterface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/matdesign?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ALL_STMT = "select Product.productNo, Product.productName, min(pic), Product.price "
			+ "from Product join ProductPic on Product.productNo = ProductPic.productNo "
			+ "group by ProductPic.productNo;";
	private static final String GET_CARTPRODUCT_STMT = "select productNo, productName, price from Product where productNo=?;";
	private static final String GET_PRODUCTPRICE_STMT = "select price from product where productNo=?;";

	@Override
	public List<Map<String, Object>> getAll() {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
				ResultSet rs = pstmt.executeQuery();) {
			List<Map<String, Object>> list = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("productNo", rs.getInt("productNo"));
				map.put("productName", rs.getString("productName"));
				map.put("price", rs.getInt("price"));
				map.put("productPic", rs.getBytes("min(pic)"));
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {

		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = con.prepareStatement(GET_CARTPRODUCT_STMT);) {
			
			    Cart cart = new Cart();
			    List<Cart> products = new ArrayList<Cart>();    
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					pstmt.setInt(1, item.getProductNo());
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setProductNo(rs.getInt("productNo"));
						row.setProductName(rs.getString("productName"));
						row.setQuantity(item.getQuantity());
						row.setPrice(rs.getInt("price")* item.getQuantity());
						products.add(row);
					}
				}
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getTotalCartPrice(ArrayList<Cart> cartList) {
		Integer sum = 0;

		try (Connection con = DriverManager.getConnection(url, userid, passwd)) {
			Cart cart = new Cart();
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTPRICE_STMT);
					pstmt.setInt(1, item.getProductNo());
					ResultSet rs = pstmt.executeQuery();

					while (rs.next()) {
						sum += rs.getInt("price") * item.getQuantity();
					}
				}
			}
			return sum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ShopProduct getSingleProduct(Integer productNo) {

		ShopProduct row = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement("select productNo, productName, price from product where productNo=?");

			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				row = new ShopProduct();
				row.setProductNo(rs.getInt("productNo"));
				row.setProductName(rs.getString("productName"));
				row.setPrice(rs.getInt("Price"));
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
		return row;
	}

	// main方法
	public static void main(String[] args) {
		ShopProductJDBCDAO dao = new ShopProductJDBCDAO();

		// 查詢商品資訊
//			List<Map<String, Object>> list = dao.getAll();
//			for (Map<String, Object> keys : list) {
//				System.out.println(keys);
//			}

	}

}
