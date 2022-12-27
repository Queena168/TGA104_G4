package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.cart.model.Cart;
import com.tibame.product.model.ProductService;
import com.tibame.product.model.ProductVO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductService psSvc;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = res.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<Cart>();
			
			int id = Integer.parseInt(req.getParameter("id"));
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
				req.setAttribute("message","<script type='text/javascript'>alert('加入購物車成功!')</script>");
				req.getRequestDispatcher("ShowShop").forward(req, res);
//				res.sendRedirect("/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
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
						req.setAttribute("message","<script type='text/javascript'>alert('加入购物车成功，请前去付款!')</script>");
						req.getRequestDispatcher("ShowShop").forward(req, res);
//						res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//						out.println("<h3 style='color:crimson; text-align:center'> Item already exist in Cart.<a href='http://localhost:8081/TGA104G4/front-end/cart/cart.jsp'>Go to Cart Page</a></h3>");
					}
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
				if(!exist) {
					cartList.add(cart);
					req.setAttribute("message","<script type='text/javascript'>alert('加入购物车成功，请前去付款!')</script>");
					req.getRequestDispatcher("ShowShop").forward(req, res);
//					res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
			}
		}
		
	}
}
