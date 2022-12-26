package com.tibame.portfolio.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/PortfolioPic1")
public class PortfolioPic1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
    public PortfolioPic1() {
        super();
    }
    
    public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		try {
			Statement stmt = con.createStatement();
			String portfolioNo = req.getParameter("portfolioNo").trim();
			ResultSet rs = stmt.executeQuery(
					"SELECT portfolioPic1 from Portfolio WHERE portfolioNo = " + portfolioNo);
			
			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("portfolioPic1"));
				byte[] buf = in.readAllBytes();
				out.write(buf);
				in.close();
			} else {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			rs.close();
			stmt.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}
	
	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
