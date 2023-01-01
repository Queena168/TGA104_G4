package com.tibame.product.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tibame.product.model.ProductService;
import com.tibame.product.model.ProductVO;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insertProduct".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer productTypeNo = Integer.valueOf(req.getParameter("productTypeNo"));
			if (productTypeNo == null) {
				errorMsgs.add("商品類別編號請勿空白");
			}
			
			String productName = req.getParameter("productName").trim();
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.add("商品名稱請勿空白");
			}
			
			Integer stock = null;
			try {
			stock = Integer.valueOf(req.getParameter("stock"));
			}catch (NumberFormatException e) {
				stock = 0;
				errorMsgs.add("庫存量請填數字.");
			}
			
			Integer price = null;
			try {
			price = Integer.valueOf(req.getParameter("price"));
			}catch (NumberFormatException e) {
				stock = 0;
				errorMsgs.add("價格請填數字.");
			}
			
			String productDescription = req.getParameter("productDescription");
			
			String productStatus = req.getParameter("productStatus");
			if (productStatus == null || productStatus.trim().length() == 0) {
				errorMsgs.add("商品狀態請勿空白");
			}
			
			Integer adminNo = Integer.valueOf(req.getParameter("adminNo").trim());


			ProductVO productVO = new ProductVO();
			productVO.setProductTypeNo(productTypeNo);
			productVO.setProductName(productName);
			productVO.setStock(stock);
			productVO.setPrice(price);
			productVO.setProductDescription(productDescription);
			productVO.setProductStatus(productStatus);
			productVO.setAdminNo(adminNo);


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/product/addProduct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductService productSvc = new ProductService();
			productVO = productSvc.addProduct(productTypeNo, productName, stock, price, productDescription,
					productStatus, adminNo);
			
			List<ProductVO> list = productSvc.getAll();
			req.setAttribute("list", list);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		}

}
