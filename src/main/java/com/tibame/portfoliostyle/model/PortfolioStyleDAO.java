package com.tibame.portfoliostyle.model;

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

public class PortfolioStyleDAO implements PortfolioStyleDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"insert into PortfolioStyle (portfolioNo, styleNo) values (?, ?);";
	private static final String GET_ALL_STMT =
			"select portfolioStyleNO, portfolioNo, styleNo from PortfolioStyle order by portfolioStyleNO;";
	private static final String GET_ONE_STMT = 
			"select portfolioStyleNO, portfolioNo, styleNo from PortfolioStyle where portfolioStyleNO = ?;";
	private static final String DELETE = 
			"delete from PortfolioStyle where portfolioStyleNO = ?;";
	private static final String UPDATE = 
			"update PortfolioStyle set portfolioNo=?, styleNo=? where portfolioStyleNO = ?;";
	
	@Override
	public void insert(PortfolioStyleVO portfolioStyleVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, portfolioStyleVO.getPortfolioNo());
			pstmt.setInt(2, portfolioStyleVO.getStyleNo());
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
	public void update(PortfolioStyleVO portfolioStyleVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try { 
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, portfolioStyleVO.getPortfolioNo());
			pstmt.setInt(2, portfolioStyleVO.getStyleNo());
			pstmt.setInt(3, portfolioStyleVO.getPortfolioStyleNO());
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
	public void delete(Integer portfolioStyleNO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, portfolioStyleNO);
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
	public PortfolioStyleVO findByPrimaryKey(Integer portfolioStyleNO) {
		
		PortfolioStyleVO portfolioStyleVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, portfolioStyleNO);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				portfolioStyleVO = new PortfolioStyleVO();
				portfolioStyleVO.setPortfolioStyleNO(rs.getInt("portfolioStyleVO"));
				portfolioStyleVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioStyleVO.setStyleNo(rs.getInt("styleNo"));
			}
			
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
		
		return portfolioStyleVO;
	}

	@Override
	public List<PortfolioStyleVO> getAll() {
		List<PortfolioStyleVO> list = new ArrayList<PortfolioStyleVO>();
		PortfolioStyleVO portfolioStyleVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				portfolioStyleVO = new PortfolioStyleVO();
				portfolioStyleVO.setPortfolioStyleNO(rs.getInt("portfolioStyleVO"));
				portfolioStyleVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioStyleVO.setStyleNo(rs.getInt("styleNo"));
				list.add(portfolioStyleVO);
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

}
