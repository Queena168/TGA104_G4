package com.tibame.portfolio.model;

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

public class PortfolioDAO implements PortfolioDAO_interface{

	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"insert into Portfolio (portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea) "
			+ "values (?, ?, ?, ?, ?, ?, ?, now(), now(), ?, ?, ? );";
	private static final String GET_ALL_STMT = 
			"select portfolioNo, portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea from Portfolio order by portfolioNo;";
	private static final String GET_ONE_STMT = 
			"select portfolioNo, portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea from Portfolio where portfolioNo = ?;";
	private static final String DELETE =
			"delete from Portfolio where portfolioNo = ?;";
	private static final String UPDATE = 
			"update Portfolio set portfolioName=?, designerNo=?, portfolioPic1=?, portfolioPic2=?, portfolioPic3=?, portfolioPic4=?, description=?, modificationTime=now(), houseAge=?, houseSize=?, houseArea=? where  portfolioNo = ?;";
	
	@Override
	public void insert(PortfolioVO portfolioVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, portfolioVO.getPortfolioName());
			pstmt.setInt(2, portfolioVO.getDesignerNo());
			pstmt.setBytes(3, portfolioVO.getPortfolioPic1());
			pstmt.setBytes(4, portfolioVO.getPortfolioPic2());
			pstmt.setBytes(5, portfolioVO.getPortfolioPic3());
			pstmt.setBytes(6, portfolioVO.getPortfolioPic4());
			pstmt.setString(7, portfolioVO.getDescription());
			pstmt.setString(8, portfolioVO.getHouseAge());
			pstmt.setString(9, portfolioVO.getHouseSize());
			pstmt.setString(10, portfolioVO.getHouseArea());
	
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
	public void update(PortfolioVO portfolioVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, portfolioVO.getPortfolioName());
			pstmt.setInt(2, portfolioVO.getDesignerNo());
			pstmt.setBytes(3, portfolioVO.getPortfolioPic1());
			pstmt.setBytes(4, portfolioVO.getPortfolioPic2());
			pstmt.setBytes(5, portfolioVO.getPortfolioPic3());
			pstmt.setBytes(6, portfolioVO.getPortfolioPic4());
			pstmt.setString(7, portfolioVO.getDescription());
			pstmt.setString(8, portfolioVO.getHouseAge());
			pstmt.setString(9, portfolioVO.getHouseSize());
			pstmt.setString(10, portfolioVO.getHouseArea());
			pstmt.setInt(11, portfolioVO.getPortfolioNo());
			
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
	public void delete(Integer portfolioNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, portfolioNo);
			
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
	public PortfolioVO findByPrimaryKey(Integer portfolioNo) {
		PortfolioVO portfolioVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, portfolioNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				portfolioVO = new PortfolioVO();
				portfolioVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioVO.setPortfolioName(rs.getString("portfolioName"));
				portfolioVO.setDesignerNo(rs.getInt("designerNo"));
				portfolioVO.setPortfolioPic1(rs.getBytes("portfolioPic1"));
				portfolioVO.setPortfolioPic2(rs.getBytes("portfolioPic2"));
				portfolioVO.setPortfolioPic3(rs.getBytes("portfolioPic3"));
				portfolioVO.setPortfolioPic4(rs.getBytes("portfolioPic4"));
				portfolioVO.setDescription(rs.getString("description"));
				portfolioVO.setCreateTime(rs.getTimestamp("createTime"));
				portfolioVO.setModificationTime(rs.getTimestamp("modificationTime"));
				portfolioVO.setHouseAge(rs.getString("houseAge"));
				portfolioVO.setHouseSize(rs.getString("houseSize"));
				portfolioVO.setHouseArea(rs.getString("houseArea"));
				
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
		
		return portfolioVO;
	}

	@Override
	public List<PortfolioVO> getAll() {
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		PortfolioVO portfolioVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				portfolioVO = new PortfolioVO();
				portfolioVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioVO.setPortfolioName(rs.getString("portfolioName"));
				portfolioVO.setDesignerNo(rs.getInt("designerNo"));
				portfolioVO.setPortfolioPic1(rs.getBytes("portfolioPic1"));
				portfolioVO.setPortfolioPic2(rs.getBytes("portfolioPic2"));
				portfolioVO.setPortfolioPic3(rs.getBytes("portfolioPic3"));
				portfolioVO.setPortfolioPic4(rs.getBytes("portfolioPic4"));
				portfolioVO.setDescription(rs.getString("description"));
				portfolioVO.setCreateTime(rs.getTimestamp("createTime"));
				portfolioVO.setModificationTime(rs.getTimestamp("modificationTime"));
				portfolioVO.setHouseAge(rs.getString("houseAge"));
				portfolioVO.setHouseSize(rs.getString("houseSize"));
				portfolioVO.setHouseArea(rs.getString("houseArea"));
				list.add(portfolioVO);
				
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
	
	private static final String GET_ALL_BYDESIGNER = 
			"select portfolioNo, portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea from Portfolio where designerNo = ? order by portfolioNo;";
	
	public List<PortfolioVO> getAllbyDesign(Integer designerNo) {
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		PortfolioVO portfolioVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_BYDESIGNER);
			pstmt.setInt(1, designerNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				portfolioVO = new PortfolioVO();
				portfolioVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioVO.setPortfolioName(rs.getString("portfolioName"));
				portfolioVO.setDesignerNo(rs.getInt("designerNo"));
				portfolioVO.setPortfolioPic1(rs.getBytes("portfolioPic1"));
				portfolioVO.setPortfolioPic2(rs.getBytes("portfolioPic2"));
				portfolioVO.setPortfolioPic3(rs.getBytes("portfolioPic3"));
				portfolioVO.setPortfolioPic4(rs.getBytes("portfolioPic4"));
				portfolioVO.setDescription(rs.getString("description"));
				portfolioVO.setCreateTime(rs.getTimestamp("createTime"));
				portfolioVO.setModificationTime(rs.getTimestamp("modificationTime"));
				portfolioVO.setHouseAge(rs.getString("houseAge"));
				portfolioVO.setHouseSize(rs.getString("houseSize"));
				portfolioVO.setHouseArea(rs.getString("houseArea"));
				list.add(portfolioVO);
				
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
	
	
	private static final String GET_ALL_MATCH = 
			"select portfolioNo, portfolioName, designerNo, portfolioPic1, portfolioPic2, portfolioPic3, portfolioPic4, description, createTime, modificationTime, houseAge, houseSize, houseArea from Portfolio where portfolioName like ? order by portfolioNo;";
	
	public List<PortfolioVO> selectMatch(String select) {
		List<PortfolioVO> list = new ArrayList<PortfolioVO>();
		PortfolioVO portfolioVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MATCH);
			pstmt.setString(1, select);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				portfolioVO = new PortfolioVO();
				portfolioVO.setPortfolioNo(rs.getInt("portfolioNo"));
				portfolioVO.setPortfolioName(rs.getString("portfolioName"));
				portfolioVO.setDesignerNo(rs.getInt("designerNo"));
				portfolioVO.setPortfolioPic1(rs.getBytes("portfolioPic1"));
				portfolioVO.setPortfolioPic2(rs.getBytes("portfolioPic2"));
				portfolioVO.setPortfolioPic3(rs.getBytes("portfolioPic3"));
				portfolioVO.setPortfolioPic4(rs.getBytes("portfolioPic4"));
				portfolioVO.setDescription(rs.getString("description"));
				portfolioVO.setCreateTime(rs.getTimestamp("createTime"));
				portfolioVO.setModificationTime(rs.getTimestamp("modificationTime"));
				portfolioVO.setHouseAge(rs.getString("houseAge"));
				portfolioVO.setHouseSize(rs.getString("houseSize"));
				portfolioVO.setHouseArea(rs.getString("houseArea"));
				list.add(portfolioVO);
				
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
