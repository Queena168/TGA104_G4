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
import designer.service.DesignerOrderPhaseService;

@WebServlet("/SendOrderPhase")
public class SendOrderPhase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		session.getAttribute("list");
		String constructionStatus = req.getParameter("constructionStatus");
		String orderPhaseDetail = req.getParameter("orderPhaseDetail");
		String strorderNo = req.getParameter("orderNo");
		Integer orderNo = Integer.valueOf(strorderNo);
		DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
	    designerOrderPhaseSvc.InsertDesignerOrderPhaseConstruction(orderNo, constructionStatus, orderPhaseDetail);
		List<DesignerOrderPhaseVO> list = designerOrderPhaseSvc.getOrderPhase(orderNo);
		System.out.println("sendorderphase之designerOrderPhaseVO內容:"+list);
		session.setAttribute("list", list);
		String url = "/front-end/designer/listOneOrder.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
	}

}
