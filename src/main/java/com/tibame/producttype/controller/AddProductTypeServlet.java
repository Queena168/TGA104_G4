package com.tibame.producttype.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.tibame.producttype.model.ProductTypeService;
import com.tibame.producttype.model.ProductTypeVO;

@WebServlet("/AddProductTypeServlet")
public class AddProductTypeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
//	@Autowired 
//	private ProductTypeService productTypeSvc;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("insertProductType".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			
			String productTypeName = req.getParameter("productTypeName").trim();
			String productTypeNameReg = "^[(\\u4e00-\\u9fa5)(0-9)]$";
			if (productTypeName == null || productTypeName.trim().length() == 0) {
				errorMsgs.add("商品類別名稱請勿空白");
			} else if(!productTypeName.trim().matches(productTypeName)) { 
				errorMsgs.add("商品類別名稱只能包含中文字與數字");
            }
			
			ProductTypeVO productTypeVO = new ProductTypeVO();
			productTypeVO.setProductTypeName(productTypeName);
			

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productTypeVO", productTypeVO); // 含有輸入格式錯誤的productType物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/producttype/addProductType.jsp");
				failureView.forward(req, res);
				return;
			}

			
			ProductTypeService productTypeSvc = new ProductTypeService();
			productTypeVO = productTypeSvc.addProductType(productTypeName);
			
			List<ProductTypeVO> list = productTypeSvc.getAll();
			req.setAttribute("list", list);
			
			String url = "SelectAllProductType";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交selectProduct_page.jsp
			successView.forward(req, res);
		}
	}

}
