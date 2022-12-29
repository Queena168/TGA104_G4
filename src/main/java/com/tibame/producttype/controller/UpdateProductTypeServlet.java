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

import com.tibame.productpic.model.ProductPicService;
import com.tibame.producttype.model.ProductTypeService;
import com.tibame.producttype.model.ProductTypeVO;


@WebServlet("/UpdateProductTypeServlet")
public class UpdateProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductTypeService productTypeSvc; 
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getProductType_For_Update".equals(action)) { // 來自selectProduct_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer productTypeNo = Integer.valueOf(req.getParameter("productTypeNo"));

			/*************************** 2.開始查詢資料 ****************************************/
//			ProductTypeService productTypeSvc = new ProductTypeService();
			ProductTypeVO productTypeVO = productTypeSvc.getOneProductType(productTypeNo);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("productTypeVO", productTypeVO); // 資料庫取出的productTypeVO物件,存入req
			String url = "/back-end/producttype/updateProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_productType_input.jsp
			successView.forward(req, res);
		}

		if ("updateProductType".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer productTypeNo = Integer.valueOf(req.getParameter("productTypeNo").trim());
			String productTypeName = req.getParameter("productTypeName");

			ProductTypeVO productTypeVO = new ProductTypeVO();
			productTypeVO.setProductTypeNo(productTypeNo);
			productTypeVO.setProductTypeName(productTypeName);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("productTypeVO", productTypeVO); // 含有輸入格式錯誤的productTypeVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/producttype/updateProductType.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ProductTypeService productTypeSvc = new ProductTypeService();
			productTypeVO = productTypeSvc.updateProductType(productTypeNo, productTypeName);
			
			List<ProductTypeVO> list = productTypeSvc.getAll();
			req.setAttribute("list", list);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("productTypeVO", productTypeVO); // 資料庫update成功後,正確的productTypeVO物件,存入req
			String url = "/back-end/producttype/listAllProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交selectProduct_page.jsp
			successView.forward(req, res);
		}
	}

}
