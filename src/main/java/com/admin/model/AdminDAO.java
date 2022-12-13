package com.admin.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class AdminDAO implements AdminDAO_interface{
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
		"insert into Admin (adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader) values (?, ?, ?, ? , ?, now(), ?)";
	private static final String GET_ALL_STMT =
		"select adminNo, adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader from Admin order by adminNo";
	private static final String GET_ONE_STMT = 
		"select adminNo, adminEmail, adminPassword, adminName, adminPic, adminPrivilege, createTime, uploader from Admin where adminNo = ?";
	private static final String DELETE = 
		"delete from Admin where adminNo = ?";
	private static final String UPDATE = 
		"update Admin set adminEmail=?, adminPassword=?, adminName=?, adminPic=?, adminPrivilege=? where adminNo = ? ";
	private static final String SELECT_FOR_LOGIN = 
		"select * from admin where adminEmail = ? and adminPassword = ?";
	private static final String UPDATE_FOR_ADMINPRIVILEGE = 
		"update Admin set adminPrivilege=? where (adminNo = ? and adminEmail = ? and adminPassword = ?)";
	
	@Override
	public void insert(AdminVO adminVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, adminVO.getAdminEmail());
			pstmt.setString(2, adminVO.getAdminPassword());
			pstmt.setString(3, adminVO.getAdminName());
			pstmt.setBytes(4, adminVO.getAdminPic());
			pstmt.setString(5, adminVO.getAdminPrivilege());
//			pstmt.setTimestamp(6, adminVO.getCreateTime());
			pstmt.setInt(6, adminVO.getUploader());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void update(AdminVO adminVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			

			pstmt.setString(1, adminVO.getAdminEmail());
			pstmt.setString(2, adminVO.getAdminPassword());
			pstmt.setString(3, adminVO.getAdminName());
			pstmt.setBytes(4, adminVO.getAdminPic());
			pstmt.setString(5, adminVO.getAdminPrivilege());
			pstmt.setInt(6, adminVO.getAdminNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(Integer AdminNo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, AdminNo);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public AdminVO findByPrimaryKey(Integer AdminNo) {
		
		AdminVO adminVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, AdminNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				adminVO = new AdminVO();
				adminVO.setAdminNo(rs.getInt("adminNo"));
				adminVO.setAdminEmail(rs.getString("AdminEmail"));
				adminVO.setAdminPassword(rs.getString("adminPassword"));
				adminVO.setAdminName(rs.getString("adminName"));
				adminVO.setAdminPic(rs.getBytes("adminPic"));
				adminVO.setAdminPrivilege(rs.getString("adminPrivilege"));
				adminVO.setCreateTime(rs.getTimestamp("createTime"));
				adminVO.setUploader(rs.getInt("uploader"));
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		return adminVO;
	}

	@Override
	public List<AdminVO> getAll() {
		List<AdminVO> list = new ArrayList<AdminVO>();
		AdminVO adminVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adminVO = new AdminVO();
				adminVO.setAdminNo(rs.getInt("adminNo"));
				adminVO.setAdminEmail(rs.getString("adminEmail"));
				adminVO.setAdminPassword(rs.getString("adminPassword"));
				adminVO.setAdminName(rs.getString("adminName"));
				adminVO.setAdminPic(rs.getBytes("adminPic"));
				adminVO.setAdminPrivilege(rs.getString("adminPrivilege"));
				adminVO.setCreateTime(rs.getTimestamp("createTime"));
				adminVO.setUploader(rs.getInt("uploader"));
				list.add(adminVO); 
				
			}
			
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	
	
	public AdminVO adminLogin (AdminVO adminVO) {
		boolean status = false; // 利用布林值確認帳號密碼是否匹配 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_FOR_LOGIN);
			
			pstmt.setString(1, adminVO.getAdminEmail());
			pstmt.setString(2, adminVO.getAdminPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				status = true;
				
				adminVO = new AdminVO();
				adminVO.setAdminNo(rs.getInt("adminNo"));
				adminVO.setAdminEmail(rs.getString("adminEmail"));
				adminVO.setAdminPassword(rs.getString("adminPassword"));
				adminVO.setAdminName(rs.getString("adminName"));
				adminVO.setAdminPic(rs.getBytes("adminPic"));
				adminVO.setAdminPrivilege(rs.getString("adminPrivilege"));
				adminVO.setCreateTime(rs.getTimestamp("createTime"));
				adminVO.setUploader(rs.getInt("uploader"));
			}
			
		} catch (SQLException se) {
			// process sql exception
			se.printStackTrace(System.err);
		}
		
		return adminVO;
	}
	
	

	// 使用InputStream資料流方式
	public static InputStream getPictureStream(String path)  throws IOException{
		FileInputStream fis = new FileInputStream(path);
		return fis;
	} 
	// 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	@Override
	public void updatePrivilege(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_FOR_ADMINPRIVILEGE);
			//private static final String UPDATE_FOR_ADMINPRIVILEGE = 
			//		"update Admin set adminPrivilege=? where (adminNo = ? and adminEmail = ? and adminPassword = ?)";
			pstmt.setString(1, adminVO.getAdminPrivilege());
			pstmt.setInt(2, adminVO.getAdminNo());
			pstmt.setString(3, adminVO.getAdminEmail());
			pstmt.setString(4, adminVO.getAdminPassword());
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	
	
	
}
