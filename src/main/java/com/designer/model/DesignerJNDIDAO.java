package com.designer.model;

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






public class DesignerJNDIDAO implements DesignerDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestMatDesign");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_DESIGNER = "INSERT INTO Designer(designerAccount, designerPassword, designerName,designerCompany,designerPic,approvalStatus,approvalTime,Approver,designerStatus) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_DESIGNERINFO = "INSERT INTO Designer(designerAccount, designerPassword, designerName,designerCompany,designerPic) VALUES (?,?,?,?,?)";
	private static final String GET_ALL_DESIGNER = "SELECT designerNo,designerAccount, designerPassword, designerName,designerCompany,designerPic,approvalStatus,approvalTime,approver,designerStatus FROM Designer";
	private static final String GET_ONE_DESIGNER = "SELECT designerNo,designerAccount,designerPassword,designerName,designerCompany,designerPic,approvalStatus,approvalTime,approver,designerStatus FROM Designer where designerNo = ?";
	private static final String DELETE = "DELETE FROM Designer where designerNo = ?";
	private static final String UPDATE = "UPDATE Designer set designerName=?,designerPassword=?, designerCompany=? ,designerPic=? where designerNo = ?";
	private static final String UPDATENOPIC = "UPDATE Designer set designerName=?,designerPassword=?, designerCompany=?  where designerNo = ?";
	// 讀取圖片
//	public static byte[] getPictureByteArray(String path) throws IOException {
//		FileInputStream fis = new FileInputStream(path);
//		byte[] buffer = new byte[fis.available()];
//		fis.read(buffer);
//		fis.close();
//		return buffer;
//	}

	@Override
	public void insert(DesignerVO designerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_DESIGNER);
			// 使用 setBytes
			pstmt.setString(1, designerVO.getDesignerAccount());
			pstmt.setString(2, designerVO.getDesignerPassword());
			pstmt.setString(3, designerVO.getDesignerName());
			pstmt.setString(4, designerVO.getDesignerCompany());
			pstmt.setBytes(5, designerVO.getDesignerPic());
			pstmt.setString(6, designerVO.getApprovalStatus());
			pstmt.setObject(7, designerVO.getApprovalTime());
			pstmt.setInt(8, designerVO.getApprover());
			pstmt.setBoolean(9, designerVO.getDesignerStatus());
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
	public void update(DesignerVO designerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, designerVO.getDesignerName());
			pstmt.setString(2, designerVO.getDesignerPassword());
			pstmt.setString(3, designerVO.getDesignerCompany());
		    pstmt.setBytes(4, designerVO.getDesignerPic());	
			pstmt.setInt(5, designerVO.getDesignerNo());
			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void updatenoPic(DesignerVO designerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATENOPIC);
			pstmt.setString(1, designerVO.getDesignerName());
			pstmt.setString(2, designerVO.getDesignerPassword());
			pstmt.setString(3, designerVO.getDesignerCompany());
			pstmt.setInt(4, designerVO.getDesignerNo());
			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer designerNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, designerNo);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public DesignerVO findByPrimaryKey(Integer designerNo) {

		DesignerVO designerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_DESIGNER);

			pstmt.setInt(1, designerNo);

			rs = pstmt.executeQuery();
			
			
			//讀取圖片開始
//			File file = new File(filename);
//			FileOutputStream output = new FileOutputStream(file);
			
			

			while (rs.next()) {
				designerVO = new DesignerVO();
				designerVO.setDesignerNo(rs.getInt("designerNo"));
				designerVO.setDesignerAccount(rs.getString("designerAccount"));
				designerVO.setDesignerPassword(rs.getString("designerPassword"));
				designerVO.setDesignerName(rs.getString("designerName"));
				designerVO.setDesignerCompany(rs.getString("designerCompany"));
				designerVO.setDesignerPic(rs.getBytes("designerPic"));
				designerVO.setApprovalStatus(rs.getString("approvalStatus"));
				designerVO.setApprovalTime(rs.getDate("approvalTime"));
				designerVO.setApprover(rs.getInt("approver"));
				designerVO.setDesignerStatus(rs.getBoolean("designerStatus"));

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
		return designerVO;

	}

	@Override
	public List<DesignerVO> getAll() {
		List<DesignerVO> list = new ArrayList<DesignerVO>();
		DesignerVO designerVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

			con = ds.getConnection();	
			pstmt = con.prepareStatement(GET_ALL_DESIGNER);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				
				designerVO = new DesignerVO();
//				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("designerPic"));
//				byte[] buf = in.readAllBytes();
				
				designerVO.setDesignerNo(rs.getInt("designerNo"));
				designerVO.setDesignerAccount(rs.getString("designerAccount"));
				designerVO.setDesignerPassword(rs.getString("designerPassword"));
				designerVO.setDesignerName(rs.getString("designerName"));
				designerVO.setDesignerCompany(rs.getString("designerCompany"));	
				//designerVO.setDesignerPic(buf);	
				designerVO.setDesignerPic(rs.getBytes("designerPic"));
				designerVO.setApprovalStatus(rs.getString("approvalStatus"));
				designerVO.setApprovalTime(rs.getDate("approvalTime"));
				designerVO.setApprover(rs.getInt("approver"));
				designerVO.setDesignerStatus(rs.getBoolean("designerStatus"));
				
//				designerVO.setExpertiseVO(new ExpertiseVO(new Integer("555"),"YA"));
				list.add(designerVO); // Store the row in the list
			}
			//designerExpertiseVO.expertiseNo}-[${designerExpertiseVO.expertiseVO.expertiseName
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
	public void insertDesigner(DesignerVO designerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_DESIGNERINFO);
			// 使用 setBytes
			pstmt.setString(1, designerVO.getDesignerAccount());
			pstmt.setString(2, designerVO.getDesignerPassword());
			pstmt.setString(3, designerVO.getDesignerName());
			pstmt.setString(4, designerVO.getDesignerCompany());
			pstmt.setBytes(5, designerVO.getDesignerPic());
			pstmt.executeUpdate();

			System.out.println("新增成功++++++++++++++++++++");

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
//
//	@Override
//	public Set<DesignerExpertiseVO> getEmpsByDeptno(Integer designerExpertiseVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}