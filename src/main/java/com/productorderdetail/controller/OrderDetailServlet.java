package com.productorderdetail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.productorder.model.ProductOrderJDBCDAO;
import com.productorder.model.ProductOrderVO;
import com.productorderdetail.model.ProductOrderDetailVO;

//@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		try(PrintWriter out = res.getWriter()){
			Integer orderNo = Integer.valueOf(req.getParameter("id"));
			if(orderNo!=null) {
				ProductOrderJDBCDAO productOrderJDBCDAO = new ProductOrderJDBCDAO();
				List<ProductOrderDetailVO> list = productOrderJDBCDAO.findOrdersById(orderNo);
				req.setAttribute("ordersDetail", list);
				req.getRequestDispatcher("front-end/order/showOrderDetail.jsp").forward(req, res);
//				for (ProductOrderDetailVO aProductOrderVO : list) {
//					out.print(aProductOrderVO.getOrderNo() + ",");
//					out.print(aProductOrderVO.getProductNo() + ",");
//					out.print(aProductOrderVO.getQty() + ",");
//					out.print(aProductOrderVO.getPrice() + ",");
//					out.println();
//				}
//				req.setAttribute("ordersDetail", list);
//				req.getRequestDispatcher("/front-end/order/showOrdersDetail.jsp").forward(req, res);
			}
//			res.sendRedirect("http://localhost:8081/TGA104G4/front-end/order/showOrderDetail.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
