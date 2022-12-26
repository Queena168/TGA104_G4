package com.tibame.productorderdetail.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.cart.model.Cart;
import com.tibame.cart.model.ShopProductService;
import com.tibame.cart.model.User;
import com.tibame.productorder.model.ProductOrderJDBCDAO;
import com.tibame.productorder.model.ProductOrderVO;

@WebServlet("/ShowOrderDetail")
public class ShowOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 先確認是否已登入
		User auth = (User) req.getSession().getAttribute("auth");
		List<ProductOrderVO> orders = null;
		if (auth != null) {
			req.setAttribute("auth", auth);
			orders = new ProductOrderJDBCDAO().userOrders(auth.getUserNo());
		} else {
//			res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp");
			String url = "/front-end/cart/login.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listAllProductType.jsp
			successView.forward(req, res);
			return;
		}

		Cart cart = (Cart) req.getAttribute("cart");
		HttpSession session = req.getSession();
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
		List<Cart> cartProduct = null;
		if (cart_list != null) {
			ShopProductService shopProductService = new ShopProductService();
			cartProduct = shopProductService.getCartProducts(cart_list);
			req.setAttribute("cart_list", cart_list);

			Integer total = shopProductService.getTotalCartPrice(cart_list);
			req.setAttribute("total", total);
		}

		String url = "/front-end/order/orderDetail.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listAllProductType.jsp
		successView.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
