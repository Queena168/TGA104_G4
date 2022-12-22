package com.productorderdetail.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.ProductService;
import com.product.model.ProductVO;
import com.productorder.model.ProductOrderVO;


//@WebServlet("/AddOrderInformServlet")
public class AddOrderInformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insertReceive".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String receiverName = req.getParameter("rname").trim();
			if (receiverName == null || receiverName.trim().length() == 0) {
				errorMsgs.add("姓名請勿空白");
			}
			
			String receiverPhone = req.getParameter("rphone").trim();
			if (receiverPhone == null || receiverPhone.trim().length() == 0) {
				errorMsgs.add("電話請勿空白");
			}
			
			String receiverAddress = req.getParameter("raddress").trim();
			if (receiverAddress == null || receiverAddress.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}
			

			ProductOrderVO productOrderVO = new ProductOrderVO();
			productOrderVO.setReceiverName(receiverName);
			productOrderVO.setReceiverPhone(receiverPhone);
			productOrderVO.setReceiverAddress(receiverAddress);


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/product/addProduct.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
//			ProductService productSvc = new ProductService();
//			productVO = productSvc.addProduct(productTypeNo, productName, stock, price, productDescription,
//					productStatus, adminNo);
//
//			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			String url = "/back-end/product/listAllProduct.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//			successView.forward(req, res);
		}
		}
}
