package com.tibame.designer.model;

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

	private static final String INSERT_DESIGNER_ORDER_PHASE = "insert into DesignerOrderPhase (orderNo,totalOrderPhase,totalamount) values(?,?,?)";
	private static final String GET_ORDER_PHASE = "select * from DesignerOrderPhase where orderNo=?";


	@Override
	public void insert(DesignerOrderPhaseVO designerOrderPhaseVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_DESIGNER_ORDER_PHASE);
			pstmt.setInt(1, designerOrderPhaseVO.getOrderNo());
			pstmt.setInt(2, designerOrderPhaseVO.getTotalOrderPhase());	
			pstmt.setInt(3, designerOrderPhaseVO.getTotalamount());
			pstmt.executeUpdate();

			System.out.println("designerOrderPhase新增成功");

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
		//System.out.println("你好友執行到2");
         int a=0;
		// =======================================
		String updateDesignerOrderPhaseConstruction = "Insert into DesignerOrderPhase (orderNo,totalOrderPhase,constructionStatus,orderPhase,orderPhaseDetail,orderPhaseAtt,modificationTime) values(?,?,?,?,?,?,now());";

		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateDesignerOrderPhaseConstruction)) {
			ps.setInt(1, designerOrderPhaseVO.getOrderNo());
			ps.setInt(2, designerOrderPhaseVO.getTotalOrderPhase());
			ps.setString(3, designerOrderPhaseVO.getConstructionStatus());
			  if(designerOrderPhaseVO.getConstructionStatus().equals("第一期施工開始")||designerOrderPhaseVO.getConstructionStatus().equals("第一期施工結束")) {
		    	 a=1;
		      }else if(designerOrderPhaseVO.getConstructionStatus().equals("第二期施工開始")||designerOrderPhaseVO.getConstructionStatus().equals("第二期施工結束")){	
		    	  a=2;
		      }else {
		    	 a=3;
		      }
			ps.setInt(4, a);			
			ps.setString(5, designerOrderPhaseVO.getOrderPhaseDetail());
			ps.setBytes(6, designerOrderPhaseVO.getOrderPhaseAtt());
			//System.out.println("你好友執行到3");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//===============================================================================
	
	

	@Override
	public void updateDesignerOrderPhasePayment(DesignerOrderPhaseVO designerOrderPhaseVO) {

		// =======================================
		String updateDesignerOrderPhaseConstruction = "insert into  DesignerOrderPhase (orderNo,)set paymentStatus=? where orderNo=?";

		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateDesignerOrderPhaseConstruction)) {
			ps.setString(1, designerOrderPhaseVO.getPaymentStatus());
			ps.setInt(2, designerOrderPhaseVO.getOrderNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ==============================================================================

	@Override
	public DesignerOrderPhaseVO findOneDesignerOrderPhase(Integer orderNo) {
		String findOneDesignerOrderPhase = "select * from DesignerOrderPhase where orderNo=? and constructionStatus='第一期施工開始'";
		DesignerOrderPhaseVO designerOrderPhaseVO=null;
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(findOneDesignerOrderPhase);) {
			pstmt.setInt(1, orderNo);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
	            designerOrderPhaseVO = new DesignerOrderPhaseVO();
	            designerOrderPhaseVO.setPhaseNo(rs.getInt("phaseNo"));
				designerOrderPhaseVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderPhaseVO.setOrderPhase(rs.getInt("orderPhase"));
				designerOrderPhaseVO.setAmount(rs.getInt("amount"));
				designerOrderPhaseVO.setConstructionStatus(rs.getString("constructionStatus"));
				designerOrderPhaseVO.setPaymentPhase(rs.getInt("paymentPhase"));
				designerOrderPhaseVO.setPaymentStatus(rs.getString("paymentStatus"));
				designerOrderPhaseVO.setPaymentAtt(rs.getBytes("paymentAtt"));
				designerOrderPhaseVO.setModificationTime(rs.getDate("modificationTime"));
				designerOrderPhaseVO.setOrderPhaseDetail(rs.getString("orderPhaseDetail"));
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
		DesignerOrderPhaseVO designerOrderPhaseVO = null;
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
				designerOrderPhaseVO.setTotalamount(rs.getInt("totalAmount"));
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

}
