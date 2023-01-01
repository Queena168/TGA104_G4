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

	private static final String INSERT_INQUIRY = "insert into DesignerOrder(designerNo,memberNo,inquiryBudget,inquirySize,inquiryDetail,quotationStatus,contractStatus)values(?,?,?,?,?,?,?)";
	
	private static final String UPDATE_CONTRACT = "update DesignerOrder set contractDetail=?,contractStatus=?,contractModificationTime=now(),contractAtt=? where orderNo=?";
	private static final String GET_ONE_ORDER = "select * from DesignerOrder where orderNo=?";
	private static final String GET_ALL_MYORDER = "select * from DesignerOrder where designerNo=?";
	private static final String GET_ALL_MYINGORDER = "select * from DesignerOrder where designerNo=? and finishStatus=0";
	private static final String GET_ALL_MYFINISHEDORDER = "select * from DesignerOrder where designerNo=? and finishStatus=1";
	private static final String GET_ALL_MYCONTRACT = "select * from DesignerOrder where designerNo=? and quotationStatus=?";
	private static final String GET_ALL_MEMBERMYORDER = "select * from DesignerOrder where memberNo=?";

	// 新增及更新報價資訊
	@Override
	public void updateQuotation(DesignerOrderVO designerOrderVO) {
		String UPDATE_QUOTATION = "update DesignerOrder set quotationAmount=?,quotationDetail=?,quotationStatus=?,quotationSendTime=now(),quotationAtt=? where orderNo=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_QUOTATION);
			pstmt.setInt(1, designerOrderVO.getQuotationAmount());
			pstmt.setString(2, designerOrderVO.getQuotationDetail());
			pstmt.setString(3, "確認中");
			
			pstmt.setBytes(4, designerOrderVO.getQuotationAtt());
			pstmt.setInt(5, designerOrderVO.getOrderNo());
			pstmt.executeUpdate();

			System.out.println("報價新增成功");

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

	// =================================================================================
	// 新增及更新合約資訊

	@Override
	public void updateContract(DesignerOrderVO designerOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_CONTRACT);
			pstmt.setString(1, designerOrderVO.getContractDetail());
			pstmt.setString(2, "確認中");
			pstmt.setBytes(3, designerOrderVO.getContractAtt());
			pstmt.setInt(4, designerOrderVO.getOrderNo());
			pstmt.executeUpdate();

			System.out.println("合約新增/更新成功");

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

	// =====================================================================================

	@Override
	public void updateFinished(DesignerOrderVO designerOrderVO) {
		String updateFinished = "update DesignerOrder set finishStatus=? where orderNo=?";
		try (Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateFinished)) {
			ps.setBoolean(1, true);
			ps.setInt(2, designerOrderVO.getOrderNo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ====================================================================================
	// 案件管理點擊查看某筆訂單

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
				designerOrderVO = new DesignerOrderVO();
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
				designerOrderVO.setContractDetail(rs.getString("contractDetail"));
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

	// =======================================================================================

	// ===========================================================================

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
				designerOrderVO = new DesignerOrderVO();
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

	// ===============================================================================
	// 新增案件裡的設計師編號，客戶編號及諮詢項目

	@Override
	public void insertinquiry(DesignerOrderVO designerOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_INQUIRY);
			pstmt.setInt(1, designerOrderVO.getDesignerNo());
			pstmt.setInt(2, 3);
			pstmt.setInt(3, designerOrderVO.getInquiryBudget());
			pstmt.setInt(4, designerOrderVO.getInquirySize());
			pstmt.setString(5, designerOrderVO.getInquiryDetail());
			pstmt.setString(6, "未報價");
			pstmt.setString(7, "尚未進行");
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
	public List<DesignerOrderVO> getMemberAllMyOrder(Integer memberNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MEMBERMYORDER);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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

//====================================================================================
	@Override
	public List<DesignerOrderVO> getAllMyQuotation(Integer designerNo) {
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
				designerOrderVO = new DesignerOrderVO();
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

	@Override
	public List<DesignerOrderVO> getMemberAllMyQuotation(Integer memberNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MEMBERMYORDER);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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

	// ====================================================================================

	@Override
	public List<DesignerOrderVO> getAllMyContract(Integer designerNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MYCONTRACT);
			pstmt.setInt(1, designerNo);
			pstmt.setString(2, "同意報價");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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
				designerOrderVO.setContractDetail(rs.getString("contractDetail"));
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

	@Override
	public List<DesignerOrderVO> getMemberAllMyContract(Integer memberNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MEMBERMYORDER);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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

	// 取得設計師進行中訂單
	@Override
	public List<DesignerOrderVO> getAllMyINGOrder(Integer designerNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MYINGORDER);
			pstmt.setInt(1, designerNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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

	// 如結案狀態為結案則取得設計師結案訂單
	@Override
	public List<DesignerOrderVO> getAllMyisFinishOrder(Integer designerNo) {
		List<DesignerOrderVO> list = new ArrayList<DesignerOrderVO>();
		DesignerOrderVO designerOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MYFINISHEDORDER);
			pstmt.setInt(1, designerNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerOrderVO = new DesignerOrderVO();
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
