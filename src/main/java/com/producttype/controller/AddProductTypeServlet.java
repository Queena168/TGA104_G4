package com.producttype.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.producttype.model.ProductTypeService;
import com.producttype.model.ProductTypeVO;

@WebServlet("/back-end/producttype/AddProductTypeServlet")
public class AddProductTypeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insertProductType".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String productTypeName = req.getParameter("productTypeName").trim();
			if (productTypeName == null || productTypeName.trim().length() == 0) {
				errorMsgs.add("商品類別名稱請勿空白");
			}
			
			ProductTypeVO productTypeVO = new ProductTypeVO();
			productTypeVO.setProductTypeName(productTypeName);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productTypeVO", productTypeVO); // 含有輸入格式錯誤的productType物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/producttype/addProductType.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
			ProductTypeService productTypeSvc = new ProductTypeService();
			productTypeVO = productTypeSvc.addProductType(productTypeName);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/producttype/listAllProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交selectProduct_page.jsp
			successView.forward(req, res);
		}
	}

}
