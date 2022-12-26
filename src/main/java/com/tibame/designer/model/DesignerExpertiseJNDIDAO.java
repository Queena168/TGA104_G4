package com.tibame.designer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DesignerExpertiseJNDIDAO implements DesignerExpertiseDAO_interface {

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
	private static final String GET_ALL_EXPERTISE = "select * from DesignerExpertise";
	private static final String DELETE = "";
	private static final String GET_MY_EXPERTISE = "select * from DesignerExpertise where designerNo=?";
	// private static final String UPDATE = "";

	@Override
	public void insert(DesignerExpertiseVO designerexpertiseVO) {
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

	@Override
	public void update(DesignerExpertiseVO designerexpertiseVO) {
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

	@Override
	public void delete(Integer designerExpertiseNo) {}

	@Override
	public DesignerExpertiseVO findDesignerExpertiseNo(Integer designerExpertiseNo) {
		DesignerExpertiseVO designerExpertiseVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_EXPERTISE);

			pstmt.setInt(1, designerExpertiseNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

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
		return designerExpertiseVO;
	}

	@Override
	public Set<DesignerExpertiseVO> getAll() {
		Set<DesignerExpertiseVO> set = new LinkedHashSet<DesignerExpertiseVO>();
		DesignerExpertiseVO designerExpertiseVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_EXPERTISE);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerExpertiseVO=new DesignerExpertiseVO();
				designerExpertiseVO.setDesignerExpertiseNo(rs.getInt("designerExpertiseNo"));
				designerExpertiseVO.setDesignerNo(rs.getInt("designerNo"));
				designerExpertiseVO.setExpertiseNo(rs.getInt("expertiseNo"));
				set.add(designerExpertiseVO);
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
		return set;
	}


	@Override
	public List<DesignerExpertiseVO> getMyExpertise(Integer designerNo) {
		List<DesignerExpertiseVO> list = new ArrayList<DesignerExpertiseVO>();
		DesignerExpertiseVO designerExpertiseVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_MY_EXPERTISE);
			pstmt.setInt(1, designerNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerExpertiseVO = new DesignerExpertiseVO();
				designerExpertiseVO.setDesignerExpertiseNo(rs.getInt("designerExpertiseNo"));
				designerExpertiseVO.setDesignerNo(rs.getInt("designerNo"));
				designerExpertiseVO.setExpertiseNo(rs.getInt("expertiseNo"));
				list.add(designerExpertiseVO);
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
	
	//===========================================================================================
	@Override
	public DesignerExpertiseVO getMyExpertises(Integer designerNo) {
		DesignerExpertiseVO designerExpertiseVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_MY_EXPERTISE);

			pstmt.setInt(1, designerNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				designerExpertiseVO = new DesignerExpertiseVO();
				designerExpertiseVO.setDesignerExpertiseNo(rs.getInt("designerExpertiseNo"));
				designerExpertiseVO.setDesignerNo(rs.getInt("designerNo"));
				designerExpertiseVO.setExpertiseNo(rs.getInt("expertiseNo"));

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
		return designerExpertiseVO;
	}

}
