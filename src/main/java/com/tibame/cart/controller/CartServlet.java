package com.tibame.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.tibame.cart.model.Cart;
import com.tibame.cart.model.ShopProductService;
import com.tibame.product.model.ProductService;
import com.tibame.product.model.ProductVO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	@Autowired
//	private ProductService productService;

	// 外部Server
//	@Override
//	public void init() throws ServletException {
//		ServletContext application = this.getServletContext();
//		ApplicationContext context = (ApplicationContext) application
//				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		this.productService = context.getBean("productService", ProductService.class);
//	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");

		try (PrintWriter out = res.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<Cart>();

			int id = Integer.parseInt(req.getParameter("id"));

			// 不符合商品編號
			if (id < 0 || id > 18) {
				req.getRequestDispatcher("ShowShop").forward(req, res);
			}
			
			ProductService productService = new ProductService();
			ProductVO productVO = productService.getOneProduct(id);
			Cart cart = new Cart();
			cart.setProductNo(id);
			cart.setProductName(productVO.getProductName());
			cart.setPrice(productVO.getPrice());
			cart.setQuantity(1);

			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
				req.getRequestDispatcher("ShowShop").forward(req, res);
//				res.sendRedirect("/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//				String url = "/front-end/cart/cart.jsp";
//				RequestDispatcher rd = req.getRequestDispatcher(url);
//				rd.forward(req, res);
			} else {
				cartList = cart_list;
				boolean exist = false;

				for (Cart c : cartList) {
					if (c.getProductNo() == id) {
						exist = true;
						c.setQuantity(c.getQuantity() + 1);
						req.getRequestDispatcher("ShowShop").forward(req, res);
//						res.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp"); // shopProduct.jsp
//						out.println("<h3 style='color:crimson; text-align:center'> Item already exist in Cart.<a href='http://localhost:8081/TGA104G4/front-end/cart/cart.jsp'>Go to Cart Page</a></h3>");
					}
//					String url = "/front-end/cart/cart.jsp";
//					RequestDispatcher rd = req.getRequestDispatcher(url);
//					rd.forward(req, res);
				}
				if (!exist) {
					cartList.add(cart);
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
