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

@WebServlet("/ShowOneContractDetail")
public class ShowOneContractDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String action=req.getParameter("action");
		if("getMyContract".equals(action)) {
			HttpSession session =  req.getSession();
			session.getAttribute("list");	 
			session.getAttribute("designerOrderVO");
			String str = req.getParameter("orderNo");
			if (str == null || (str.trim()).length() == 0) {}			
			Integer OrderNo = null;
			try {
				OrderNo = Integer.valueOf(str);
				System.out.println("OrderNo:"+OrderNo);
			} catch (Exception e) {
				
			}
			
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(OrderNo);
//			System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO);
//			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
//			List<DesignerOrderPhaseVO> listOrderPhase=designerOrderPhaseSvc.getOrderPhase(OrderNo);
//			System.out.println("sendContract的designerOrderPhaseVO內容:"+listOrderPhase.toString());	
			//System.out.println("取得報價金額:"+listOrderPhase.get(0).getOrderPhase());	
			
			session.setAttribute("designerOrderVO", designerOrderVO);
			//session.setAttribute("listOrderPhase", listOrderPhase);
		    String url = "/front-end/designer/listOneContract.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			System.out.println("有執行HAHAHA");
		    successView.forward(req, res);
		}
		
		
		
		//===================================================================================
		
		
		if("getmemberMyContract".equals(action)) {
			HttpSession session =  req.getSession();
			session.getAttribute("list");
			String str = req.getParameter("orderNo");
			if (str == null || (str.trim()).length() == 0) {
				
			}
			Integer designerOrderNo = null;
			try {
				designerOrderNo = Integer.valueOf(str);
			} catch (Exception e) {
				
			}
			DesignerOrderService designerOrderScv = new DesignerOrderService();
			DesignerOrderVO designerOrderVO=designerOrderScv.getMyOrder(designerOrderNo);
			//System.out.println("showOneOrderDetail之designerOrderVO物件內容:"+designerOrderVO.toString());
			
			session.setAttribute("designerOrderVO", designerOrderVO);			
		    String url = "/front-end/member/listOneContract.jsp";
		    RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneDesigner.jsp
			successView.forward(req, res);
		}
	
	}

}
