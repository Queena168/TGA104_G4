package com.tibame.cart.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopProductJDBCDAO implements ShopProductDAOInterface {
	@Autowired
	private DataSource dataSource;
//	static {
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

	private static final String GET_ALL_STMT = "select Product.productNo, Product.productName, min(pic), Product.price "
			+ "from Product join ProductPic on Product.productNo = ProductPic.productNo "
			+ "group by ProductPic.productNo;";
	private static final String GET_CARTPRODUCT_STMT = "select productNo, productName, price from Product where productNo=?;";
	private static final String GET_PRODUCTPRICE_STMT = "select price from product where productNo=?;";

	@Override
	public List<Map<String, Object>> getAll() {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT);
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

		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_CARTPRODUCT_STMT);) {
			
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

		try (Connection connection = dataSource.getConnection();) {
			Cart cart = new Cart();
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					PreparedStatement pstmt = connection.prepareStatement(GET_PRODUCTPRICE_STMT);
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
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("select productNo, productName, price from product where productNo=?")) {
			pstmt.setInt(1, productNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				row = new ShopProduct();
				row.setProductNo(rs.getInt("productNo"));
				row.setProductName(rs.getString("productName"));
				row.setPrice(rs.getInt("Price"));
			}

			// Handle any driver errors
		} catch (SQLException e) {
			e.printStackTrace();
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
