package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.producttype.model.ProductTypeVO;

public class ProductJDBCDAO implements ProductDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/matdesign?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ALL_STMT = 
			"SELECT productNo, productTypeNo, productName, stock, price, productDescription, productStatus, adminNo FROM Product order by productTypeNo";
	private static final String INSERT_STMT = 
			"insert into Product(productTypeNo, productName, stock, price, productDescription, productStatus, adminNo)"
			+ " " + "values(?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE Product set productTypeNo=?, productName=?, stock=?, price=?, productDescription=?, productStatus=? , adminNo=? where productNo=?";
	private static final String GET_ONE_STMT = 
			"SELECT productNo, productTypeNo, productName, stock, price, productDescription, productStatus, adminNo FROM Product where productNo = ?";
	private static final String DELETE = 
			"DELETE FROM Product where productNo = ?";
	private static final String SHOW = 
			"select ProductType.productTypeName, Product.productName from ProductType join Product on ProductType.productTypeNo = Product.productTypeNo";
	private static final String LIST_ALL_PRODUCT = 
			"select Product.productNo, ProductType.productTypeName, Product.productName, Product.stock, Product.price, "
			+ "Product.productDescription, Product.productStatus, min(pic), adminNo  "
			+ "from (ProductType join Product on ProductType.productTypeNo = Product.productTypeNo) "
			+ "join ProductPic on Product.productNo = ProductPic.productNo group by ProductPic.productNo;";

	@Override
	public void insert(ProductVO productVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productVO.getProductTypeNo());
			pstmt.setString(2, productVO.getProductName());
			pstmt.setInt(3, productVO.getStock());
			pstmt.setInt(4, productVO.getPrice());
			pstmt.setString(5, productVO.getProductDescription());
			pstmt.setString(6, productVO.getProductStatus());
			pstmt.setInt(7, productVO.getAdminNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(ProductVO productVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productVO.getProductTypeNo());
			pstmt.setString(2, productVO.getProductName());
			pstmt.setInt(3, productVO.getStock());
			pstmt.setInt(4, productVO.getPrice());
			pstmt.setString(5, productVO.getProductDescription());
			pstmt.setString(6, productVO.getProductStatus());
			pstmt.setInt(7, productVO.getAdminNo());
			pstmt.setInt(8, productVO.getProductNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer productNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public ProductVO findByPrimaryKey(Integer productNo) {

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				productVO = new ProductVO();
				productVO.setProductNo(rs.getInt("productNo"));
				productVO.setProductTypeNo(rs.getInt("productTypeNo"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setStock(rs.getInt("stock"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setProductDescription(rs.getString("productDescription"));
				productVO.setProductStatus(rs.getString("productStatus"));
				productVO.setAdminNo(rs.getInt("adminNo"));
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
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ProductVO 也稱為 Domain objects
				productVO = new ProductVO();
				productVO.setProductNo(rs.getInt("productNo"));
				productVO.setProductTypeNo(rs.getInt("productTypeNo"));
				productVO.setProductName(rs.getString("productName"));
				productVO.setStock(rs.getInt("stock"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setProductDescription(rs.getString("productDescription"));
				productVO.setProductStatus(rs.getString("productStatus"));
				productVO.setAdminNo(rs.getInt("adminNo"));
				list.add(productVO); // Store the row in the list
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
		return list;
	}

	@Override
	public List<ProductVO> showAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;
		ProductTypeVO productTypeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SHOW);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ProductVO 也稱為 Domain objects
				productVO = new ProductVO();
				productTypeVO = new ProductTypeVO();

				productVO.setProductName(rs.getString("productName"));
				productTypeVO.setProductTypeName(rs.getString("productTypeName"));

				list.add(productVO); // Store the row in the list
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
		return list;
	}

	public List<Map<String, Object>> showAll2() {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = con.prepareStatement(SHOW);
				ResultSet rs = pstmt.executeQuery();) {
			List<Map<String, Object>> list = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("productTypeName", rs.getString("productTypeName"));
				map.put("productName", rs.getString("productName"));
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> listAllProduct() {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = con.prepareStatement(LIST_ALL_PRODUCT);
				ResultSet rs = pstmt.executeQuery();) {
			List<Map<String, Object>> list = new ArrayList<>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("productNo", rs.getInt("productNo"));
				map.put("productTypeName", rs.getString("productTypeName"));
				map.put("productName", rs.getString("productName"));
				map.put("stock", rs.getInt("stock"));
				map.put("price", rs.getInt("price"));
				map.put("productDescription", rs.getString("productDescription"));
				map.put("productStatus", rs.getString("productStatus"));
				map.put("productPic", rs.getBytes("min(pic)"));
				map.put("adminNo", rs.getInt("adminNo"));
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// main方法
	public static void main(String[] args) {
		ProductJDBCDAO dao = new ProductJDBCDAO();

		// 新增
//		ProductVO productVO1 = new ProductVO();
//		productVO1.setProductTypeNo(1);
//		productVO1.setProductName("壁紙");
//		productVO1.setStock(50);
//		productVO1.setPrice(30);
//		productVO1.setProductDescription(null);
//		productVO1.setProductStatus("已上架");
//		productVO1.setAdminNo(1);
//		dao.insert(productVO1);

		// 刪除
//		dao.delete(10);

		// 修改
//		ProductVO productVO1 = new ProductVO();
//		productVO1.setProductNo(2);
//		productVO1.setProductTypeNo(1);
//		productVO1.setProductName("地毯");
//		productVO1.setStock(100);
//		productVO1.setPrice(300);
//		productVO1.setProductDescription(null);
//		productVO1.setProductStatus("已上架");
//		productVO1.setAdminNo(1);
//		dao.update(productVO1);

		// 查詢
//		ProductVO productVO1 = dao.findByPrimaryKey(1);		
//		System.out.print(productVO1.getProductNo() + ",");
//		System.out.print(productVO1.getProductTypeNo() + ",");
//		System.out.print(productVO1.getProductName() + ",");
//		System.out.print(productVO1.getStock() + ",");
//		System.out.print(productVO1.getPrice() + ",");
//		System.out.print(productVO1.getProductDescription() + ",");
//		System.out.print(productVO1.getProductStatus() + ",");
//		System.out.print(productVO1.getAdminNo());

		// 查詢
//		List<ProductVO> list = dao.getAll();
//		for (ProductVO aProduct : list) {
//			System.out.print(aProduct.getProductNo() + ",");
//			System.out.print(aProduct.getProductTypeNo() + ",");
//			System.out.print(aProduct.getProductName() + ",");
//			System.out.print(aProduct.getStock() + ",");
//			System.out.print(aProduct.getPrice() + ",");
//			System.out.print(aProduct.getProductDescription() + ",");
//			System.out.print(aProduct.getProductStatus() + ",");
//			System.out.print(aProduct.getAdminNo());
//			System.out.println();
//		}

		// 查詢
//		List<Map<String, Object>> list = dao.showAll2();
//		for (Map<String, Object> keys : list) {
//			System.out.println(keys);
//		}
		
		// 查詢商品資訊
		List<Map<String, Object>> list = dao.listAllProduct();
		for (Map<String, Object> keys : list) {
			System.out.println(keys);
		}

	}
}
