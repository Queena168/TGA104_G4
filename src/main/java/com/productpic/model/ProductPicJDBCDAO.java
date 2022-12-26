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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.producttype.model.ProductTypeVO;

public class ProductPicJDBCDAO implements ProductPicDAO_interface {

	private static DataSource dataSource = null;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {
			pstmt.setInt(1, productPicVO.getProductNo());
			pstmt.setBytes(2, productPicVO.getPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(ProductPicVO productPicVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
			pstmt.setInt(1, productPicVO.getProductNo());
			pstmt.setBytes(2, productPicVO.getPic());
			pstmt.setInt(3, productPicVO.getProductPicNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProductPicVO findByPrimaryKey(Integer productNo) {
		ProductPicVO productPicVO = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, productNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productPicVO = new ProductPicVO();
				productPicVO.setProductPicNo(rs.getInt("productPicNo"));
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productPicVO;
	}

	@Override
	public List<ProductPicVO> getAll() {
		List<ProductPicVO> list = new ArrayList<ProductPicVO>();
		ProductPicVO productPicVO = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productPicVO = new ProductPicVO();
				productPicVO.setProductPicNo(rs.getInt("productPicNo"));
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
				list.add(productPicVO); // Store the row in the list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductPicVO showOnePic(Integer productNo) {
		ProductPicVO productPicVO = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SHOW_ONE_STMT)) {
			pstmt.setInt(1, productNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productPicVO = new ProductPicVO();
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productPicVO;
	}

	@Override
	public List<ProductPicVO> showAllPic() {
		List<ProductPicVO> list = new ArrayList<ProductPicVO>();
		ProductPicVO productPicVO = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SHOW_ALL_STMT)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productPicVO = new ProductPicVO();
				productPicVO.setProductNo(rs.getInt("productNo"));
				productPicVO.setPic(rs.getBytes("min(pic)"));
				list.add(productPicVO); // Store the row in the list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> showAll2() {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SHOW)) {
			ResultSet rs = pstmt.executeQuery();
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
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(LIST_ALL_PRODUCT)) {
			ResultSet rs = pstmt.executeQuery();
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
