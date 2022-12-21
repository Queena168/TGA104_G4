package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.model.Cart;
import com.cart.model.ShopProduct;
import com.product.model.ProductService;
import com.product.model.ProductVO;


public class CartServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = res.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<Cart>();
			
			int id = Integer.parseInt(req.getParameter("id"));
			ProductService psSvc = new ProductService();
			ProductVO productVO = psSvc.getOneProduct(id);
			Cart cart = new Cart();
			cart.setProductNo(id);
			cart.setProductName(productVO.getProductName());
			cart.setPrice(productVO.getPrice());
			cart.setQuantity(1);
			
			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			if(cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//				String url = "/front-end/cart/cart.jsp";
//				RequestDispatcher rd = req.getRequestDispatcher(url);
//				rd.forward(req, res);
			}else {
				cartList = cart_list;
				boolean exist = false;
				
				for(Cart c:cartList) {
					if(c.getProductNo() == id) {
						exist = true;
						c.setQuantity(c.getQuantity() + 1);
						res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//						out.println("<h3 style='color:crimson; text-align:center'> Item already exist in Cart.<a href='http://localhost:8081/TGA104G4/front-end/cart/cart.jsp'>Go to Cart Page</a></h3>");
					}
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
				if(!exist) {
					cartList.add(cart);
					res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
			}
		}
		
	}
}
