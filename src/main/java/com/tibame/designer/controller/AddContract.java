package designer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import designer.model.DesignerOrderPhaseVO;
import designer.model.DesignerOrderVO;
import designer.service.DesignerOrderPhaseService;
import designer.service.DesignerOrderService;

@WebServlet("/AddContract")
public class AddContract extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("designerOrderVO");
		String action =  req.getParameter("action");
		
		
		
		/*
		 * addContract.jsp點擊新增合約時，執行以下程式
		 * 此不是新增資料進資料庫，而是導向要輸入資料的頁面
		
		 * */
			
		if("insertcontract".equals(action)) {
			
			String str = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				System.out.print("AddContract的designerOrderNo為空值");
			}

			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			//List <DesignerOrderPhaseVO> designerOrderPhaselist  = designerOrderPhaseSvc.getOrderPhase(designerOrderNo);
			//System.out.println("addcontract.java之designerOrderPhaselist內容"+designerOrderPhaselist.size());
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			session.setAttribute("designerOrderVO", designerOrderVO);	
			//session.setAttribute("designerOrderPhaselist", designerOrderPhaselist);
		    String url = "/front-end/designer/addContract.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
		
		
		//================================================================
		/*
		 * addContract.jsp點擊修改合約時，執行以下程式
		 * 此不是新增資料進資料庫，而是導向要輸入資料的頁面
		
		 * */
		
		
		if("updatecontract".equals(action)) {
			
			String str = req.getParameter("orderNo");
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			
			

			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			session.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/designer/addContract.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
	
	}

}
