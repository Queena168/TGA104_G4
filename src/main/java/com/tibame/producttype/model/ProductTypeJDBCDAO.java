package com.tibame.producttype.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductTypeJDBCDAO implements ProductTypeDAO_interface{

	private static DataSource dataSource = null;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
 
	private static final String GET_ALL_STMT = 
			"SELECT productTypeNo, productTypeName FROM ProductType order by productTypeNo";
	private static final String INSERT_STMT = 
			"insert into ProductType(productTypeName) values(?)";
	private static final String UPDATE = 
			"UPDATE ProductType set productTypeName=? where productTypeNo = ?";
	private static final String GET_ONE_STMT = "SELECT productTypeNo, productTypeName FROM ProductType where productTypeNo = ?";

	@Override
	public void insert(ProductTypeVO productTypeVO) {
		try (Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {
			pstmt.setString(1, productTypeVO.getProductTypeName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductTypeVO productTypeVO) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
				pstmt.setString(1, productTypeVO.getProductTypeName());
				pstmt.setInt(2, productTypeVO.getProductTypeNo());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public ProductTypeVO findByPrimaryKey(Integer productTypeNo) {
		
		ProductTypeVO productTypeVO = null;
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {
				pstmt.setInt(1, productTypeNo);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// empVo 也稱為 Domain objects
					productTypeVO = new ProductTypeVO();
					productTypeVO.setProductTypeNo(rs.getInt("productTypeNo"));
					productTypeVO.setProductTypeName(rs.getString("productTypeName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    return productTypeVO;
	}

	@Override
	public List<ProductTypeVO> getAll() {
		List<ProductTypeVO> list = new ArrayList<ProductTypeVO>();
		ProductTypeVO productTypeVO = null;
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT)) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// ProductTypeVO 也稱為 Domain objects
					productTypeVO = new ProductTypeVO();
					productTypeVO.setProductTypeNo(rs.getInt("productTypeNo"));
					productTypeVO.setProductTypeName(rs.getString("productTypeName"));
					list.add(productTypeVO); // Store the row in the list
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

	// main方法，連線池只能在Server
	public static void main(String[] args) {
		ProductTypeJDBCDAO dao = new ProductTypeJDBCDAO();
		
		// 新增
//		ProductTypeVO productTypeVO1 = new ProductTypeVO();
//		productTypeVO1.setProductTypeName("家飾");
//		dao.insert(productTypeVO1);
		
		// 修改
//		ProductTypeVO productTypeVO = new ProductTypeVO();
//		productTypeVO.setProductTypeNo(4);
//		productTypeVO.setProductTypeName("其他");
//		dao.update(productTypeVO);
		
		// 查詢
//		ProductTypeVO productTypeVO2 = dao.findByPrimaryKey(1);		
//		System.out.print(productTypeVO2.getProductTypeNo() + ",");
//		System.out.print(productTypeVO2.getProductTypeName());

		
		// 查詢
		List<ProductTypeVO> list = dao.getAll();
		for (ProductTypeVO aProductType : list) {
			System.out.print(aProductType.getProductTypeNo() + ",");
			System.out.print(aProductType.getProductTypeName() + ",");
			System.out.println();
		}
	}
}
