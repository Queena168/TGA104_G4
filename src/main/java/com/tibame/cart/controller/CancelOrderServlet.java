package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.productorder.model.ProductOrderJDBCDAO;
import com.tibame.productorder.model.ProductOrderVO;


@WebServlet("/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try(PrintWriter out = res.getWriter()){
			Integer id = Integer.valueOf(req.getParameter("id").trim());
			String OrderStatus = "已取消";
			if(id!=null) {
				ProductOrderVO productOrderVO = new ProductOrderVO();
				productOrderVO.setOrderNo(id);
				productOrderVO.setOrderStatus(OrderStatus);
				ProductOrderJDBCDAO productOrderJDBCDAO = new ProductOrderJDBCDAO();
				productOrderJDBCDAO.delete(productOrderVO);
			}
			res.sendRedirect("SelectOrder"); // order.jsp
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
