package com.tibame.productorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.cart.model.User;
import com.tibame.productorder.model.ProductOrderJDBCDAO;
import com.tibame.productorder.model.ProductOrderVO;

/**
 * Servlet implementation class SelectOrder
 */
@WebServlet("/front-end/order/SelectOrder")
public class SelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User auth = (User)req.getSession().getAttribute("auth");
		List<ProductOrderVO> orders = null;
		if(auth!=null){
			req.setAttribute("auth", auth);
//		     orders = new ProductOrderJDBCDAO().useOrders(auth.getUserNo());
			   orders = new ProductOrderJDBCDAO().userOrders(auth.getUserNo());
			   req.setAttribute("orders", orders);
			   String url = "/front-end/order/order.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}else{
			res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
