package com.tibame.designer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DesignerOrderPhaseJNDIDAO implements DesignerOrderPhaseDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestMatDesign");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	String columns[] = { "phaseNo" };
	int phaseNo=-1;
	// private static final String INSERT_DESIGNER_ORDER_PHASE = "insert into
	// DesignerOrderPhase (orderNo,totalOrderPhase,totalamount) values(?,?,?)";
	private static final String INSERT_DESIGNER_ORDER_PHASE = "insert into DesignerOrderPhase (orderNo,totalOrderPhase,orderPhase,totalAmount,constructionStatus,paymentPhase,paymentStatus,modificationTime) values(?,?,?,?,?,?,?,NOW())";
	private static final String GET_ORDER_PHASE = "select * from DesignerOrderPhase where orderNo=?";

	@Override
	public void insert(DesignerOrderPhaseVO designerOrderPhaseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_DESIGNER_ORDER_PHASE,Statement.RETURN_GENERATED_KEYS);
			// 開始新增資料
			pstmt.setInt(1, designerOrderPhaseVO.getOrderNo());
			pstmt.setInt(2, designerOrderPhaseVO.getTotalOrderPhase());
			pstmt.setInt(3, 1);
			pstmt.setInt(4, designerOrderPhaseVO.getTotalAmount());
			pstmt.setString(5, "尚未施工");
			pstmt.setInt(6, 1);
			pstmt.setString(7, "尚未付款");
			pstmt.executeUpdate();
			// 取得DesignerOrderPhase資料表流水編號
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				phaseNo = rs.getInt(1);
				System.out.println("designerOrderPhase新增成功");
				System.out.println("inserted; phaseNo: " + phaseNo);
			}
			
//			if (phaseNo == -1) {
//				System.out.println("phaseNo inserting failed!");
//				return;
//			}

		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}

	}

	@Override
	public void update(DesignerOrderPhaseVO designerOrderPhaseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("");
			pstmt.executeUpdate();

			System.out.println("新增成功");

		} catch (SQLException se) {
			System.out.println(se);
		} finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}

	}

	@Override
	public void insertDesignerOrderPhaseConstruction(DesignerOrderPhaseVO designerOrderPhaseVO) {

		// =======================================
		String updateDesignerOrderPhaseConstruction = "Insert into DesignerOrderPhase (orderNo,totalOrderPhase, orderPhase,totalAmount,constructionStatus,paymentPhase,paymentStatus,orderPhaseDetail,modificationTime) values(?,?,?,?,?,?,?,?,now());";

		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateDesignerOrderPhaseConstruction,Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, designerOrderPhaseVO.getOrderNo());
			ps.setInt(2, designerOrderPhaseVO.getTotalOrderPhase());
			ps.setInt(3, designerOrderPhaseVO.getOrderPhase());
			ps.setInt(4, designerOrderPhaseVO.getTotalAmount());
			ps.setString(5, designerOrderPhaseVO.getConstructionStatus());
			ps.setInt(6, designerOrderPhaseVO.getOrderPhase());
			ps.setString(7, "尚未付款");
			ps.setString(8, designerOrderPhaseVO.getOrderPhaseDetail());
			//ps.setBytes(6, designerOrderPhaseVO.getOrderPhaseAtt());
			ps.executeUpdate();
			// 取得DesignerOrderPhase資料表流水編號
						ResultSet rs = ps.getGeneratedKeys();
						if (rs.next()) {
							phaseNo = rs.getInt(1);
							System.out.println("designerOrderPhase新增成功");
							System.out.println("inserted; phaseNo: " + phaseNo);
						}
						
						if (phaseNo == -1) {
							System.out.println("phaseNo inserting failed!");
							return;
						}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ===============================================================================

	@Override
	public void updateDesignerOrderPhasePayment(DesignerOrderPhaseVO designerOrderPhaseVO) {

		// =======================================
		String updateDesignerOrderPhaseConstruction = "update DesignerOrderPhase set amount=?, paymentStatus=? where orderNo=? and orderPhase=? and constructionStatus=?";

		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateDesignerOrderPhaseConstruction)) {
			ps.setInt(1, designerOrderPhaseVO.getAmount());
			ps.setString(2, designerOrderPhaseVO.getPaymentStatus());
			ps.setInt(3, designerOrderPhaseVO.getOrderNo());
			ps.setInt(4, designerOrderPhaseVO.getOrderPhase());
			ps.setString(5, designerOrderPhaseVO.getConstructionStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ==============================================================================

	@Override
	public DesignerOrderPhaseVO findOneDesignerOrderPhase(Integer orderNo) {
		//System.out.println("phaseNo:"+phaseNo);
		String findOneDesignerOrderPhase = "select * from DesignerOrderPhase where orderNo=?";
		DesignerOrderPhaseVO designerOrderPhaseVO = null;
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(findOneDesignerOrderPhase);) {
			pstmt.setInt(1, orderNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				designerOrderPhaseVO = new DesignerOrderPhaseVO();
				designerOrderPhaseVO.setPhaseNo(rs.getInt("phaseNo"));
				designerOrderPhaseVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderPhaseVO.setTotalOrderPhase(rs.getInt("totalOrderPhase"));
				designerOrderPhaseVO.setOrderPhase(rs.getInt("orderPhase"));
				designerOrderPhaseVO.setTotalAmount(rs.getInt("totalAmount"));
				designerOrderPhaseVO.setAmount(rs.getInt("amount"));
				designerOrderPhaseVO.setConstructionStatus(rs.getString("constructionStatus"));
				designerOrderPhaseVO.setPaymentPhase(rs.getInt("paymentPhase"));
				designerOrderPhaseVO.setPaymentStatus(rs.getString("paymentStatus"));
				designerOrderPhaseVO.setPaymentAtt(rs.getBytes("paymentAtt"));
				designerOrderPhaseVO.setModificationTime(rs.getDate("modificationTime"));
				designerOrderPhaseVO.setOrderPhaseDetail(rs.getString("orderPhaseDetail"));
				designerOrderPhaseVO.setOrderPhaseAtt(rs.getBytes("orderPhaseAtt"));;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designerOrderPhaseVO;

	}

	// ===============================================================================

	@Override
	public List<DesignerOrderPhaseVO> findDesignerOrderPhase(Integer orderNo) {
		List<DesignerOrderPhaseVO> list = new ArrayList<DesignerOrderPhaseVO>();
		DesignerOrderPhaseVO designerOrderPhaseVO =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ORDER_PHASE);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderPhaseVO = new DesignerOrderPhaseVO();
				designerOrderPhaseVO.setPhaseNo(rs.getInt("phaseNo"));
				designerOrderPhaseVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderPhaseVO.setTotalOrderPhase(rs.getInt("totalOrderPhase"));
				designerOrderPhaseVO.setOrderPhase(rs.getInt("orderPhase"));
				designerOrderPhaseVO.setTotalAmount(rs.getInt("totalAmount"));
				designerOrderPhaseVO.setAmount(rs.getInt("amount"));
				designerOrderPhaseVO.setConstructionStatus(rs.getString("constructionStatus"));
				designerOrderPhaseVO.setPaymentPhase(rs.getInt("paymentPhase"));
				designerOrderPhaseVO.setPaymentStatus(rs.getString("paymentStatus"));
				designerOrderPhaseVO.setPaymentAtt(rs.getBytes("paymentAtt"));
				designerOrderPhaseVO.setModificationTime(rs.getDate("modificationTime"));
				designerOrderPhaseVO.setOrderPhaseDetail(rs.getString("orderPhaseDetail"));
				designerOrderPhaseVO.setOrderPhaseAtt(rs.getBytes("orderPhaseAtt"));
				list.add(designerOrderPhaseVO);

			}

			// Handle any driver errors
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
	public List<DesignerOrderPhaseVO> getAll() {
		return null;

	}

	@Override
	public List<DesignerOrderPhaseVO> testfindDesignerOrderPhase() {
		// TODO Auto-generated method stub
		return null;
	}

}
