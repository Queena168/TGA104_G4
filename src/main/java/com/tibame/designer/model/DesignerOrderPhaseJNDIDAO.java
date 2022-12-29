package designer.model;

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
	public void InsertDesignerOrderPhaseConstruction(DesignerOrderPhaseVO designerOrderPhaseVO) {

		// =======================================
		String updateDesignerOrderPhaseConstruction = "update DesignerOrderPhase set constructionStatus=?,orderPhaseDetail=? where orderNo=?";

		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateDesignerOrderPhaseConstruction)) {
			ps.setString(1, designerOrderPhaseVO.getConstructionStatus());
			ps.setString(2, designerOrderPhaseVO.getOrderPhaseDetail());
			ps.setInt(3, designerOrderPhaseVO.getOrderNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//===============================================================================
	
	

	@Override
	public void InsertDesignerOrderPhasePayment(DesignerOrderPhaseVO designerOrderPhaseVO) {

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
		String findOneDesignerOrderPhase = "select * from DesignerOrderPhase where orderNo=?";
		DesignerOrderPhaseVO designerOrderPhaseVO=null;
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(findOneDesignerOrderPhase);) {
			pstmt.setInt(1, orderNo);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
	            designerOrderPhaseVO = new DesignerOrderPhaseVO();
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
				designerOrderPhaseVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderPhaseVO.setOrderPhase(rs.getInt("orderPhase"));
				designerOrderPhaseVO.setAmount(rs.getInt("amount"));
				designerOrderPhaseVO.setConstructionStatus(rs.getString("constructionStatus"));
				designerOrderPhaseVO.setPaymentPhase(rs.getInt("paymentPhase"));
				designerOrderPhaseVO.setPaymentStatus(rs.getString("paymentStatus"));
				designerOrderPhaseVO.setPaymentAtt(rs.getBytes("paymentAtt"));
				designerOrderPhaseVO.setModificationTime(rs.getDate("modificationTime"));
				designerOrderPhaseVO.setTotalamount(rs.getInt("totalOrderPhase"));
				designerOrderPhaseVO.setTotalamount(rs.getInt("totalamount"));
				
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
