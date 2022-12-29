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

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getProduct_For_Update".equals(action)) { // 來自listAllProduct.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer productNo = Integer.valueOf(req.getParameter("productNo"));

			/*************************** 2.開始查詢資料 ****************************************/
			ProductService productSvc = new ProductService();
			ProductVO productVO = productSvc.getOneProduct(productNo);
			
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("productVO", productVO); // 資料庫取出的productVO物件,存入req
			String url = "/back-end/product/updateProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("updateProduct".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer productNo = Integer.valueOf(req.getParameter("productNo").trim());

			Integer productTypeNo = Integer.valueOf(req.getParameter("productTypeNo").trim());

			String productName = req.getParameter("productName");
			if (productName == null || productName.trim().length() == 0) {
				errorMsgs.add("商品名稱請勿空白");
			}

			Integer stock = null;
			try {
				stock = Integer.valueOf(req.getParameter("stock").trim());
			} catch (NumberFormatException e) {
				stock = 0;
				errorMsgs.add("庫存量請填數字");
			}

			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price").trim());
			} catch (NumberFormatException e) {
				price = 0;
				errorMsgs.add("價格請填數字");
			}
			String productDescription = req.getParameter("productDescription");

			String productStatus = req.getParameter("productStatus");
			if (productStatus == null || productStatus.trim().length() == 0) {
				errorMsgs.add("商品狀態請勿空白");
			}

			Integer adminNo = Integer.valueOf(req.getParameter("adminNo").trim());

			ProductVO productVO = new ProductVO();
			productVO.setProductNo(productNo);
			productVO.setProductTypeNo(productTypeNo);
			productVO.setProductName(productName);
			productVO.setStock(stock);
			productVO.setPrice(price);
			productVO.setProductDescription(productDescription);
			productVO.setProductStatus(productStatus);
			productVO.setAdminNo(adminNo);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productVO", productVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/product/update_product_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProductService productSvc = new ProductService();
			productVO = productSvc.updateProduct(productNo, productTypeNo, productName, stock, price,
					productDescription, productStatus, adminNo);
			List<ProductVO> list = productSvc.getAll();
			req.setAttribute("list", list);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("productVO", productVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/product/listAllProduct.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
	}
}
