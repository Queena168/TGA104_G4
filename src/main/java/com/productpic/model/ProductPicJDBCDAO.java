package com.productpic.model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class ProductPicJDBCDAO implements ProductPicDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/MatdesignDB?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT = "insert into ProductPic(productNo, pic) values(?, ?)";
	private static final String GET_ONE_STMT = "select productPicNo, productNo, pic from ProductPic where productPicNo=?";
	private static final String GET_ALL_STMT = "select productPicNo, productNo, pic from ProductPic order by productPicNo";
	private static final String UPDATE = "update ProductPic set productNo=?, pic=? where productPicNo=?";
	private static final String DELETE = "delete from ProductPic where productPicNo = ?";
	private static final String SHOW_ONE_STMT = "select productNo, min(pic) from ProductPic group by productNo=?";
	private static final String SHOW_ALL_STMT = "select productNo, min(pic) from ProductPic group by productNo";
	private static final String SHOW = "select Product.productNo, Product.productName, min(pic) from Product join ProductPic on Product.productNo = ProductPic.productNo group by ProductPic.productNo";
	private static final String LIST_ALL_PRODUCT = "select Product.productNo, ProductType.productTypeName, Product.productName, Product.stock, Product.price, "
			+ "Product.productDescription, Product.productStatus, min(pic), adminNo  "
			+ "from (ProductType join Product on ProductType.productTypeNo = Product.productTypeNo) "
			+ "join ProductPic on Product.productNo = ProductPic.productNo group by ProductPic.productNo;";

	@Override
	public void insert(ProductPicVO productPicVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productPicVO.getProductNo());
			pstmt.setBytes(2, productPicVO.getPic());
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
	public void update(ProductPicVO productPicVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productPicVO.getProductNo());
			pstmt.setBytes(2, productPicVO.getPic());
			pstmt.setInt(3, productPicVO.getProductPicNo());

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
	public void delete(Integer productPicNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, productPicNo);

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
	public ProductPicVO findByPrimaryKey(Integer productNo) {
		ProductPicVO productPicVO = null;
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
				// empVo 也稱為 Domain objects
				productPicVO = new ProductPicVO();
				productPicVO.setProductPicNo(rs.getInt("productPicNo"));
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
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
		return productPicVO;
	}

	@Override
	public List<ProductPicVO> getAll() {
		List<ProductPicVO> list = new ArrayList<ProductPicVO>();
		ProductPicVO productPicVO = null;
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
				productPicVO = new ProductPicVO();
				productPicVO.setProductPicNo(rs.getInt("productPicNo"));
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
				list.add(productPicVO); // Store the row in the list
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
	public ProductPicVO showOnePic(Integer productNo) {
		ProductPicVO productPicVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SHOW_ONE_STMT);

			pstmt.setInt(1, productNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				productPicVO = new ProductPicVO();
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
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
		return productPicVO;
	}

	@Override
	public List<ProductPicVO> showAllPic() {
		List<ProductPicVO> list = new ArrayList<ProductPicVO>();
		ProductPicVO productPicVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SHOW_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ProductVO 也稱為 Domain objects
				productPicVO = new ProductPicVO();
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("min(pic)"));
				list.add(productPicVO); // Store the row in the list
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
				map.put("productNo", rs.getInt("productNo"));
				map.put("productName", rs.getString("productName"));
				map.put("productPic", rs.getBytes("min(pic)"));

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

	public static void main(String[] args) {
		ProductPicJDBCDAO dao = new ProductPicJDBCDAO();

		// 新增
//		ProductPicVO productPicVO1 = new ProductPicVO();
//		productPicVO1.setProductNo(1);
//
//		InputStream in;
//		try {
//			in = Files.newInputStream(Path.of("home.jpeg"));
//			byte[] pic = new byte[in.available()];
//			in.read(pic);
//			productPicVO1.setPic(pic);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		dao.insert(productPicVO1);

		// 修改
//		ProductPicVO productPicVO = new ProductPicVO();
//		productPicVO.setProductNo(1);
//		
//		InputStream in;
//		try {
//			in = Files.newInputStream(Path.of("home.jpeg"));
//			byte[] pic = new byte[in.available()];
//			in.read(pic);
//			productPicVO.setPic(pic);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		productPicVO.setProductPicNo(1);
//		dao.update(productPicVO);

		// 查詢
//		ProductPicVO productPicVO1 = dao.findByPrimaryKey(1);
//		System.out.print(productPicVO1.getProductPicNo() + ",");
//		System.out.print(productPicVO1.getProductNo() + ",");
//		System.out.print(productPicVO1.getPic());

		// 查詢
//		List<ProductTypeVO> list = dao.getAll();
//		for (ProductTypeVO aProductType : list) {
//			System.out.print(aProductType.getProductTypeNo() + ",");
//			System.out.print(aProductType.getProductTypeName() + ",");
//			System.out.println();
//		}

		// 查詢 showOne
//		ProductPicVO productPicVO = dao.showOnePicture(1);
//		System.out.print(productPicVO.getProductNo() + ",");
//		System.out.print(productPicVO.getPic());

		// 查詢 showAll
//		List<ProductPicVO> list = dao.showAllPic();
//		for (ProductPicVO aProductPic : list) {
//			System.out.print(aProductPic.getProductNo() + ",");
//			System.out.print(aProductPic.getPic());
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
