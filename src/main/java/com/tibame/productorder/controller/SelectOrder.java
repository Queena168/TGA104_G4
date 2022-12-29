package com.tibame.productorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.cart.model.ShopProductService;
import com.tibame.cart.model.User;
import com.tibame.productorder.model.ProductOrderJDBCDAO;
import com.tibame.productorder.model.ProductOrderVO;
import com.tibame.productorderdetail.model.ProductOrderDetailVO;

/**
 * Servlet implementation class SelectOrder
 */
@WebServlet("/SelectOrder")
public class SelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@Autowired
//	private ProductOrderJDBCDAO productOrderJDBCDAO;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User auth = (User)req.getSession().getAttribute("auth");
		List<ProductOrderVO> orders = null;
		if(auth!=null){
			req.setAttribute("auth", auth);
			ProductOrderJDBCDAO productOrderJDBCDAO = new ProductOrderJDBCDAO();
			   orders = productOrderJDBCDAO.userOrders(auth.getUserNo());
			   req.setAttribute("orders", orders);
			   String url = "/front-end/order/order.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}else{
			res.sendRedirect("/front-end/cart/login.jsp");
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
