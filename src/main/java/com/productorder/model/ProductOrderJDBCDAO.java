package com.productorder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cart.model.Cart;
import com.cart.model.ShopProduct;
import com.cart.model.ShopProductJDBCDAO;
import com.product.model.ProductJDBCDAO;
import com.product.model.ProductService;
import com.product.model.ProductVO;
import com.productorderdetail.model.ProductOrderDetailVO;
import com.producttype.model.ProductTypeVO;

public class ProductOrderJDBCDAO implements ProductOrderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/MatdesignDB?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String GET_ALL_STMT = "SELECT orderNo, memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, invoiceNo, "
			+ "businessNumber, paidDate, shipDate, orderStatus FROM ProductOrder order by orderNo";
	private static final String INSERT_STMT = "insert into ProductOrder(memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, invoiceNo, "
			+ "businessNumber, paidDate, shipDate, orderStatus)" + " " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE ProductOrder set memberNo=?, receiverName=?, receiverPhone=?, receiverAddress=?, totalQTY=?, totalAmount=?, invoiceNo=?, "
			+ "businessNumber=?, shipDate=?, orderStatus=? where orderNo=?";
	private static final String GET_ONE_STMT = "SELECT orderNo, memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, invoiceNo,"
			+ "businessNumber, paidDate, shipDate, orderStatus FROM ProductOrder where orderNo = ?";
	private static final String DELETE = "UPDATE ProductOrder set orderStatus=? where orderNo = ?";
	private static final String INSERT = "insert into ProductOrder(memberNo, totalQTY, paidDate) values(?, ?, ?)";
	private static final String USEORDER = "select orderNo, productNo, memberNo, totalQTY, paidDate from ProductOrder where memberNo=? order by orderNo desc;";

	private static final String INSERTORDER = "insert into ProductOrder(memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, paidDate, orderNo, orderStatus) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERTORDERITEM = "insert into ProductOrderDetail(orderNo, productNo, qty, price) values(?, ?, ?, ?)";
	private static final String USERORDER = 
			"select orderNo, memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, paidDate , orderStatus from ProductOrder where memberNo=? order by orderNo desc;";
	private static final String FINDORDER = 
			"select orderNo, memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, paidDate from ProductOrder where orderNo=? ;";
	private static final String FINDORDERDETAIL = 
			"select ProductOrderDetail.orderDetailNo, ProductOrderDetail.orderNo, ProductOrderDetail.productNo, Product.productName, ProductOrderDetail.qty, ProductOrderDetail.price "
			+ 
			"from ProductOrderDetail join Product on ProductOrderDetail.productNo = Product.productNo where orderNo=?;";
//	private static final String FINDORDERDETAIL = 
//			"select orderDetailNo, orderNo, productNo, qty, price from ProductOrderDetail where orderNo=? order by orderNo desc;";
	private static final String UPDATE_ORDERSTATUS = "UPDATE ProductOrder set orderStatus=? where orderNo=?";
	@Override
	public boolean insert(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productOrderVO.getMemberNo());
			pstmt.setString(2, productOrderVO.getReceiverName());
			pstmt.setString(3, productOrderVO.getReceiverPhone());
			pstmt.setString(4, productOrderVO.getReceiverAddress());
			pstmt.setInt(5, productOrderVO.getTotalQTY());
			pstmt.setInt(6, productOrderVO.getTotalAmount());
			pstmt.setString(7, productOrderVO.getInvoiceNo());
			pstmt.setString(8, productOrderVO.getBusinessNumber());
			pstmt.setTimestamp(9, productOrderVO.getPaidDate());
			pstmt.setDate(10, productOrderVO.getShipDate());
			pstmt.setString(11, productOrderVO.getOrderStatus());

			pstmt.executeUpdate();
			return true;
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
	public void update(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productOrderVO.getMemberNo());
			pstmt.setString(2, productOrderVO.getReceiverName());
			pstmt.setString(3, productOrderVO.getReceiverPhone());
			pstmt.setString(4, productOrderVO.getReceiverAddress());
			pstmt.setInt(5, productOrderVO.getTotalQTY());
			pstmt.setInt(6, productOrderVO.getTotalAmount());
			pstmt.setString(7, productOrderVO.getInvoiceNo());
			pstmt.setString(8, productOrderVO.getBusinessNumber());
			pstmt.setDate(9, productOrderVO.getShipDate());
			pstmt.setString(10, productOrderVO.getOrderStatus());
			pstmt.setInt(11, productOrderVO.getOrderNo());

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
	public void delete(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, productOrderVO.getOrderStatus());
			pstmt.setInt(2, productOrderVO.getOrderNo());

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
	public ProductOrderVO findByPrimaryKey(Integer orderNo) {

		ProductOrderVO productOrderVO = null;
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
				productOrderVO = new ProductOrderVO();
				productOrderVO.setOrderNo(rs.getInt("orderNo"));
				productOrderVO.setMemberNo(rs.getInt("memberNo"));
				productOrderVO.setReceiverName(rs.getString("receiverName"));
				productOrderVO.setReceiverPhone(rs.getString("receiverPhone"));
				productOrderVO.setReceiverAddress(rs.getString("receiverAddress"));
				productOrderVO.setTotalQTY(rs.getInt("totalQTY"));
				productOrderVO.setTotalAmount(rs.getInt("totalAmount"));
				productOrderVO.setInvoiceNo(rs.getString("invoiceNo"));
				productOrderVO.setBusinessNumber(rs.getString("businessNumber"));
//				productOrderVO.setPaidDate(rs.getDate("paidDate"));
				productOrderVO.setShipDate(rs.getDate("shipDate"));
				productOrderVO.setOrderStatus(rs.getString("orderStatus"));
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
		return productOrderVO;
	}

	@Override
	public List<ProductOrderVO> getAll() {
		List<ProductOrderVO> list = new ArrayList<ProductOrderVO>();
		ProductOrderVO productOrderVO = null;
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
				productOrderVO = new ProductOrderVO();
				productOrderVO.setOrderNo(rs.getInt("orderNo"));
				productOrderVO.setMemberNo(rs.getInt("memberNo"));
				productOrderVO.setReceiverName(rs.getString("receiverName"));
				productOrderVO.setReceiverPhone(rs.getString("receiverPhone"));
				productOrderVO.setReceiverAddress(rs.getString("receiverAddress"));
				productOrderVO.setTotalQTY(rs.getInt("totalQTY"));
				productOrderVO.setTotalAmount(rs.getInt("totalAmount"));
				productOrderVO.setInvoiceNo(rs.getString("invoiceNo"));
				productOrderVO.setBusinessNumber(rs.getString("businessNumber"));
//				productOrderVO.setPaidDate(rs.getDate("paidDate"));
				productOrderVO.setShipDate(rs.getDate("shipDate"));
				productOrderVO.setOrderStatus(rs.getString("orderStatus"));
				list.add(productOrderVO); // Store the row in the list

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

	// 測試成功
	public boolean insertOrder(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setInt(1, productOrderVO.getMemberNo());
			pstmt.setInt(2, productOrderVO.getQuantity());
			pstmt.setTimestamp(3, productOrderVO.getPaidDate());

			pstmt.executeUpdate();
			result = true;

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
		return result;
	}

	public void addOrders(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERTORDER);
			
			pstmt.setInt(1, productOrderVO.getMemberNo());
			pstmt.setString(2, productOrderVO.getReceiverName());
			pstmt.setString(3, productOrderVO.getReceiverPhone());
			pstmt.setString(4, productOrderVO.getReceiverAddress());
			pstmt.setInt(5, productOrderVO.getTotalQTY());
			pstmt.setInt(6, productOrderVO.getTotalAmount());
			pstmt.setTimestamp(7, productOrderVO.getPaidDate());
			pstmt.setInt(8, productOrderVO.getOrderNo());
			pstmt.setString(9, productOrderVO.getOrderStatus());
			pstmt.executeUpdate();

			List<ProductOrderDetailVO> items  = productOrderVO.getItems();
			if (items != null && items.size() > 0) {// 订单项中 有东西，才添加进数据库中的订单项表
				pstmt = con.prepareStatement(INSERTORDERITEM);
//				Object pps[][] = new Object[items.size()][];
				for (int i = 0; i < items.size(); i++) {
					ProductOrderDetailVO productOrderDetailVO = items.get(i);
					pstmt.setInt(1, productOrderVO.getOrderNo());
					pstmt.setInt(2, productOrderDetailVO.getProductNo());
					pstmt.setInt(3, productOrderDetailVO.getQty());
					pstmt.setInt(4, productOrderDetailVO.getPrice());
					pstmt.executeUpdate();				
				}
			}

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

	// 測試成功
//	public List<ProductOrderVO> useOrders(Integer id) {
//		try (Connection con = DriverManager.getConnection(url, userid, passwd);) {
//			List<ProductOrderVO> list = new ArrayList<>();
//			PreparedStatement pstmt = con.prepareStatement(USEORDER);
//			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				ProductOrderVO productOrderVO = new ProductOrderVO();
//				ShopProductJDBCDAO shopProductJDBCDAO = new ShopProductJDBCDAO();
//				Integer pID = rs.getInt("productNo");
//
//				ShopProduct shopProduct = shopProductJDBCDAO.getSingleProduct(pID);
//				productOrderVO.setOrderNo(rs.getInt("orderNo"));
//				productOrderVO.setProductNo(pID);
//				productOrderVO.setProductName(shopProduct.getProductName());
//				productOrderVO.setPrice(shopProduct.getPrice() * rs.getInt("totalQTY"));
//				productOrderVO.setQuantity(rs.getInt("totalQTY"));
//				productOrderVO.setPaidDate(rs.getString("paidDate"));
//				list.add(productOrderVO);
//			}
//
//			return list;
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	// orderNo, memberNo, receiverName, receiverPhone, receiverAddress, totalQTY, totalAmount, paidDate
		public List<ProductOrderVO> userOrders(Integer id) {
			try (Connection con = DriverManager.getConnection(url, userid, passwd);) {
				PreparedStatement pstmt = con.prepareStatement(USERORDER);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				List<ProductOrderVO> list = new ArrayList<>();
				ProductOrderVO productOrderVO = null; 
				while (rs.next()) {
					productOrderVO = new ProductOrderVO();
					productOrderVO.setOrderNo(rs.getInt("orderNo"));
					productOrderVO.setMemberNo(rs.getInt("memberNo"));
					productOrderVO.setReceiverName(rs.getString("receiverName"));
					productOrderVO.setReceiverPhone(rs.getString("receiverPhone"));
					productOrderVO.setReceiverAddress(rs.getString("receiverAddress"));
					productOrderVO.setTotalQTY(rs.getInt("totalQTY"));
					productOrderVO.setTotalAmount(rs.getInt("totalAmount"));	
					productOrderVO.setPaidDate(rs.getTimestamp("paidDate"));
					//新增
					productOrderVO.setOrderStatus(rs.getString("orderStatus"));
					//
					list.add(productOrderVO);
				}
				
				return list;
			} catch (Exception e) {	
				e.printStackTrace();
			}
			return null;
		}

	public void cancelOrder(Integer id) {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);) {
			PreparedStatement pstmt = con.prepareStatement("delete from ProductOrder where orderNo = ?;");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductOrderDetailVO> findOrdersById(Integer orderNo) {
		try (Connection con = DriverManager.getConnection(url, userid, passwd);) {
//			PreparedStatement pstmt = con.prepareStatement(FINDORDER);
//			pstmt.setInt(1, orderNo);
//			ResultSet rs = pstmt.executeQuery();
//			ProductOrderVO productOrderVO = null;
//			while (rs.next()) {
//				productOrderVO = new ProductOrderVO();
//				productOrderVO.setOrderNo(rs.getInt("orderNo"));
//				productOrderVO.setMemberNo(rs.getInt("memberNo"));
//				productOrderVO.setReceiverName(rs.getString("receiverName"));
//				productOrderVO.setReceiverPhone(rs.getString("receiverPhone"));
//				productOrderVO.setReceiverAddress(rs.getString("receiverAddress"));
//				productOrderVO.setTotalQTY(rs.getInt("totalQTY"));
//				productOrderVO.setTotalAmount(rs.getInt("totalAmount"));	
//				productOrderVO.setPaidDate(rs.getString("paidDate"));
//			}
			PreparedStatement pstmt = con.prepareStatement(FINDORDERDETAIL);
			pstmt.setInt(1, orderNo);
			ResultSet rs = pstmt.executeQuery();
			List<ProductOrderDetailVO> items=new ArrayList<ProductOrderDetailVO>();
			ProductOrderDetailVO productOrderDetailVO = null;
			while (rs.next()) {
				productOrderDetailVO = new ProductOrderDetailVO();
				productOrderDetailVO.setOrderDetailNo(rs.getInt("orderDetailNo"));
				productOrderDetailVO.setOrderNo(rs.getInt("orderNo"));
				productOrderDetailVO.setProductNo(rs.getInt("productNo"));
				productOrderDetailVO.setProductName(rs.getString("productName"));
				productOrderDetailVO.setQty(rs.getInt("qty"));
				productOrderDetailVO.setPrice(rs.getInt("price"));
				items.add(productOrderDetailVO);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateOrderStatus(ProductOrderVO productOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_ORDERSTATUS);

			pstmt.setString(1, productOrderVO.getOrderStatus());
			pstmt.setInt(2, productOrderVO.getOrderNo());

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
	
	// main方法
	public static void main(String[] args) {
		ProductOrderJDBCDAO dao = new ProductOrderJDBCDAO();

		// 新增
		ProductOrderVO productOrderVO = new ProductOrderVO();
		productOrderVO.setMemberNo(1);
		productOrderVO.setProductNo(1);
		productOrderVO.setQuantity(10);
		productOrderVO.setPaidDate(java.sql.Timestamp.valueOf("2022-01-01"));
		dao.insertOrder(productOrderVO);

		// 修改
//		ProductOrderVO productOrderVO = new ProductOrderVO();
//		productOrderVO.setOrderNo(2);
//		productOrderVO.setMemberNo(1);
//		productOrderVO.setReceiverName("David");
//		productOrderVO.setReceiverPhone("0912345888");
//		productOrderVO.setReceiverAddress("新北市土城區學享街20號");
//		productOrderVO.setTotalQTY(10);
//		productOrderVO.setTotalAmount(300);
//		productOrderVO.setInvoiceNo("Ae347866");
//		productOrderVO.setBusinessNumber(null);
//		productOrderVO.setPaidDate(java.sql.Date.valueOf("2022-12-01"));
//		productOrderVO.setShipDate(null);
//		productOrderVO.setOrderStatus("已付款");
//		dao.update(productOrderVO);

		// 查詢
//		ProductOrderVO productOrderVO = dao.findByPrimaryKey(1);		
//		System.out.print(productOrderVO.getOrderNo() + ",");
//		System.out.print(productOrderVO.getMemberNo() + ",");
//		System.out.print(productOrderVO.getReceiverName() + ",");
//		System.out.print(productOrderVO.getReceiverPhone() + ",");
//		System.out.print(productOrderVO.getReceiverAddress() + ",");
//		System.out.print(productOrderVO.getTotalQTY() + ",");
//		System.out.print(productOrderVO.getTotalAmount() + ",");
//		System.out.print(productOrderVO.getInvoiceNo()+ ",");
//		System.out.print(productOrderVO.getBusinessNumber()+ ",");
//		System.out.print(productOrderVO.getPaidDate()+ ",");
//		System.out.print(productOrderVO.getShipDate()+ ",");
//		System.out.print(productOrderVO.getOrderStatus());

		// 查詢
//		List<ProductOrderVO> list = dao.getAll();
//		for (ProductOrderVO aProductOrderVO : list) {
//			System.out.print(aProductOrderVO.getOrderNo() + ",");
//			System.out.print(aProductOrderVO.getMemberNo() + ",");
//			System.out.print(aProductOrderVO.getReceiverName() + ",");
//			System.out.print(aProductOrderVO.getReceiverPhone() + ",");
//			System.out.print(aProductOrderVO.getReceiverAddress() + ",");
//			System.out.print(aProductOrderVO.getTotalQTY() + ",");
//			System.out.print(aProductOrderVO.getTotalAmount() + ",");
//			System.out.print(aProductOrderVO.getInvoiceNo() + ",");
//			System.out.print(aProductOrderVO.getBusinessNumber() + ",");
//			System.out.print(aProductOrderVO.getPaidDate() + ",");
//			System.out.print(aProductOrderVO.getShipDate() + ",");
//			System.out.print(aProductOrderVO.getOrderStatus() + ",");
//			System.out.println();
//		}

		// 新增
//		ProductOrderVO productOrderVO = new ProductOrderVO();
//		productOrderVO.setProductNo(1);
//		productOrderVO.setMemberNo(1);
//		productOrderVO.setQuantity(10);
//		productOrderVO.setPaidDate("20220101");
//		dao.insertOrder(productOrderVO);
		
		
		// 新增
//		ProductOrderVO productOrderVO = new ProductOrderVO();
//		productOrderVO.setMemberNo(1);
//		productOrderVO.setReceiverName("Queena");
//		productOrderVO.setReceiverPhone("Queena");
//		productOrderVO.setReceiverAddress("Queena");
//		productOrderVO.setTotalQTY(10);
//		productOrderVO.setTotalAmount(200);
//		productOrderVO.setPaidDate("20220101");
//		
//		ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
//        productOrderDetailVO.setOrderNo(21);
//        productOrderDetailVO.setProductNo(2);
//        productOrderDetailVO.setQty(2);
//        productOrderDetailVO.setPrice(200);
//		dao.addOrders(productOrderVO);
		
		// 查詢
		List<ProductOrderVO> list = dao.userOrders(1);
		for (ProductOrderVO aProductOrderVO : list) {
			System.out.print(aProductOrderVO.getOrderNo() + ",");
			System.out.print(aProductOrderVO.getMemberNo() + ",");
			System.out.print(aProductOrderVO.getReceiverName() + ",");
			System.out.print(aProductOrderVO.getReceiverPhone() + ",");
			System.out.print(aProductOrderVO.getReceiverAddress() + ",");
			System.out.print(aProductOrderVO.getTotalQTY() + ",");
			System.out.print(aProductOrderVO.getTotalAmount() + ",");
			System.out.print(aProductOrderVO.getInvoiceNo() + ",");
			System.out.print(aProductOrderVO.getBusinessNumber() + ",");
			System.out.print(aProductOrderVO.getPaidDate() + ",");
			System.out.print(aProductOrderVO.getShipDate() + ",");
			System.out.print(aProductOrderVO.getOrderStatus() + ",");
			System.out.println();
		}
		
		// 查詢
//		List<ProductOrderDetailVO> list = dao.findOrdersById(77);
//		for (ProductOrderDetailVO p : list) {
//			System.out.print(p.getOrderNo() + ",");
//			System.out.print(p.getProductNo() + ",");
//			System.out.print(p.getProductName() + ",");
//			System.out.print(p.getQty() + ",");
//			System.out.print(p.getPrice() + ",");
//			System.out.println();
//		}
		
		// 修改訂單狀態
//		ProductOrderVO productOrderVO = new ProductOrderVO();
//		productOrderVO.setOrderNo(20);
//		productOrderVO.setOrderStatus("未發貨");
//		dao.updateOrderStatus(productOrderVO);
		
	}
}
