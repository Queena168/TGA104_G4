package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.model.Cart;
import com.cart.model.User;
import com.cart.model.UserJDBCDAO;
import com.productorder.model.ProductOrderJDBCDAO;
import com.productorder.model.ProductOrderService;
import com.product.model.ProductService;
import com.product.model.ProductVO;
import com.productorder.model.ProductOrderVO;

/**
 * Servlet implementation class OrderNowServlet
 */
//@WebServlet("/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
				res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp"); // shopProduct.jsp
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
						res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp"); // shopProduct.jsp
//						out.println("<h3 style='color:crimson; text-align:center'> Item already exist in Cart.<a href='http://localhost:8081/TGA104G4/front-end/cart/cart.jsp'>Go to Cart Page</a></h3>");
					}
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
				if(!exist) {
					cartList.add(cart);
					res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp"); // shopProduct.jsp
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
			}
		}
		
	}

//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		try(PrintWriter out = res.getWriter()){
//
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//			Date date = new Date();
//			User auth = (User) req.getSession().getAttribute("auth");
//
//			if(auth != null) {
//				String productNo = req.getParameter("id");
//				int productQuantity = Integer.parseInt(req.getParameter("quantity"));
//				if(productQuantity <= 0) {
//					productQuantity = 1;
//				}
//
//				ProductOrderVO productOrderVO = new ProductOrderVO();
//				productOrderVO.setProductNo(Integer.parseInt(productNo));
//				productOrderVO.setMemberNo(auth.getUserNo());
//				productOrderVO.setQuantity(productQuantity);
//				productOrderVO.setPaidDate(formatter.format(date));
//				
//				ProductOrderJDBCDAO productOrderJDBCDAO = new ProductOrderJDBCDAO(); 
//				boolean result = productOrderJDBCDAO.insertOrder(productOrderVO);
//				
//				if(result) {
//					ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart_list");
//					if(cart_list != null) {
//						for(Cart c:cart_list) {
//							if(c.getProductNo() == Integer.parseInt(productNo)) {
//								cart_list.remove(cart_list.indexOf(c));
//								break;
//							}
//						}
//					}
//					res.sendRedirect("http://localhost:8081/TGA104G4/front-end/order/order.jsp"); // order.jsp
//				}else {
//					out.println("order failed");
//				}
//			}else {
//				res.sendRedirect("http://localhost:8081/TGA104G4/front-end/cart/login.jsp"); // login.jsp
//			}
//
//
//					
////					
////				}else {
////					out.println("fail");
////			    }
////			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
