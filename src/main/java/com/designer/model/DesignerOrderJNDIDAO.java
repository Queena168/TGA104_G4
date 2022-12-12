package com.designerOrder.model;

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

public class DesignerOrderJNDIDAO implements DesignerOrderDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestMatDesign");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_DESIGNER = "";
	private static final String GET_ONE_ORDER = "select * from DesignerOrder where orderNo=?";
	private static final String GET_ALL_MYORDER = "select * from DesignerOrder where designerNo=?";
	private static final String DELETE = "";
	//private static final String UPDATE = "";

	@Override
	public void insert(DesignerOrderVO designerOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_DESIGNER);

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

	//=======================================================================================
	
	@Override
	public void update(DesignerOrderVO designerOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

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
	
	//=======================================================================================

	@Override
	public void delete(Integer orderNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

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
	
	//=======================================================================================
	
	//案件管理點擊查看某筆訂單

	@Override
	public DesignerOrderVO findDesignerOrder(Integer orderNo) {
		DesignerOrderVO designerOrderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_ORDER);

			pstmt.setInt(1, orderNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO=new DesignerOrderVO();
				designerOrderVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderVO.setDesignerNo(rs.getInt("designerNo"));
				designerOrderVO.setMemberNo(rs.getInt("memberNo"));
				designerOrderVO.setInquiryBudget(rs.getInt("inquiryBudget"));
				designerOrderVO.setInquirySize(rs.getInt("inquirySize"));
				designerOrderVO.setInquiryDetail(rs.getString("inquiryDetail"));
				designerOrderVO.setQuotationDetail(rs.getString("quotationDetail"));
				designerOrderVO.setQuotationAmount(rs.getInt("quotationAmount"));
				designerOrderVO.setQuotationSendTime(rs.getDate("quotationSendTime"));
				designerOrderVO.setQuotationApprovalTime(rs.getDate("quotationApprovalTime"));
				designerOrderVO.setQuotationAtt(rs.getBytes("quotationAtt"));
				designerOrderVO.setQuotationStatus(rs.getString("quotationStatus"));
				designerOrderVO.setContractStatus(rs.getString("contractDetail"));
				designerOrderVO.setContractAtt(rs.getBytes("contractAtt"));
				designerOrderVO.setContractStatus(rs.getString("contractStatus"));
				designerOrderVO.setContractApprovalTime(rs.getDate("contractApprovalTime"));
				designerOrderVO.setContractModificationTime(rs.getDate("contractModificationTime"));
				designerOrderVO.setQuotationNote(rs.getString("quotationNote"));
				designerOrderVO.setContractNote(rs.getString("contractNote"));
				designerOrderVO.setReviewStars(rs.getInt("reviewStars"));
				designerOrderVO.setReviewDetail(rs.getString("reviewDetail"));
				designerOrderVO.setReviewTime(rs.getDate("reviewTime"));
				designerOrderVO.setFinishStatus(rs.getBoolean("finishStatus"));
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
		return designerOrderVO;
	}
	
	//=======================================================================================

	@Override
	public List<DesignerOrderVO> getAll() {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MYORDER);
			rs = pstmt.executeQuery();

			while (rs.next()) {

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
	
	
	//===========================================================================
	
	@Override
	public List<DesignerOrderVO> getAllMyOrder(Integer designerNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MYORDER);
			pstmt.setInt(1, designerNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO=new DesignerOrderVO();
				designerOrderVO.setOrderNo(rs.getInt("orderNo"));
				designerOrderVO.setDesignerNo(rs.getInt("designerNo"));
				designerOrderVO.setMemberNo(rs.getInt("memberNo"));
				designerOrderVO.setInquiryBudget(rs.getInt("inquiryBudget"));
				designerOrderVO.setInquirySize(rs.getInt("inquirySize"));
				designerOrderVO.setInquiryDetail(rs.getString("inquiryDetail"));
				designerOrderVO.setQuotationDetail(rs.getString("quotationDetail"));
				designerOrderVO.setQuotationAmount(rs.getInt("quotationAmount"));
				designerOrderVO.setQuotationSendTime(rs.getDate("quotationSendTime"));
				designerOrderVO.setQuotationApprovalTime(rs.getDate("quotationApprovalTime"));
				designerOrderVO.setQuotationAtt(rs.getBytes("quotationAtt"));
				designerOrderVO.setQuotationStatus(rs.getString("quotationStatus"));
				designerOrderVO.setContractStatus(rs.getString("contractDetail"));
				designerOrderVO.setContractAtt(rs.getBytes("contractAtt"));
				designerOrderVO.setContractStatus(rs.getString("contractStatus"));
				designerOrderVO.setContractApprovalTime(rs.getDate("contractApprovalTime"));
				designerOrderVO.setContractModificationTime(rs.getDate("contractModificationTime"));
				designerOrderVO.setQuotationNote(rs.getString("quotationNote"));
				designerOrderVO.setContractNote(rs.getString("contractNote"));
				designerOrderVO.setReviewStars(rs.getInt("reviewStars"));
				designerOrderVO.setReviewDetail(rs.getString("reviewDetail"));
				designerOrderVO.setReviewTime(rs.getDate("reviewTime"));
				designerOrderVO.setFinishStatus(rs.getBoolean("finishStatus"));
				list.add(designerOrderVO);				

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
	

}
