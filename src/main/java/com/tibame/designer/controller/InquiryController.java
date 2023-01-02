package com.tibame.designer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tibame.designer.model.DesignerExpertiseVO;
import com.tibame.designer.model.DesignerVO;
import com.tibame.designer.service.DesignerExpertiseService;
import com.tibame.designer.service.DesignerOrderService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@WebServlet("/inquiryController")
public class InquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		DesignerVO designerVO =(DesignerVO) session.getAttribute("designerVO");
		String action = req.getParameter("action");
		if("insertinquiry".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			//System.out.println("有進來inquiry1===================");
			String strmember = req.getParameter("memberNo");
			System.out.println("inquirycontroller之strmember:"+strmember);
			Integer memberNo = null;
			try {
				memberNo = Integer.valueOf(strmember);
			} catch (Exception e) {
				
			}
					
		
//			String strdesignerNo = req.getParameter("designerNo");
//			System.out.println("inquirycontroller之strdesignerNo:"+strdesignerNo);
			//Integer designerNo = Integer.valueOf(strdesignerNo);
			Integer designerNo = designerVO.getDesignerNo();

			System.out.println("有進來inquiry3===================");
			String MemberName = req.getParameter("membername").trim();
			String MemberNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if(MemberName==null||MemberName.trim().length()==0) {
				errorMsgs.add("會員姓名: 請勿空白");
			}else if (!MemberName.trim().matches(MemberNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");

			}
//			System.out.println("有進來inquiry4===================");
//			String MemberPhone = req.getParameter("memberphone").trim();
//			String phoneReg = "^[0][9][0-9]{8}$";
//			if (MemberPhone == null || MemberPhone.trim().length() == 0) {
//				errorMsgs.add("請勿空白，請填寫手機號碼，以利我們團隊方便聯繫到您");
//			} else if (!MemberPhone.trim().matches(phoneReg)) {
//				errorMsgs.add("請填寫正確手機號碼格式");
//			}				
			//System.out.println("有進來inquiry5===================");
			String strsize=req.getParameter("inquirysize");
			System.out.println("inquirycontroller之strsize:"+strsize);
			Integer inquirySize = null;
			try {
			inquirySize = Integer.valueOf(strsize);
			} catch (Exception e) {
				errorMsgs.add("諮詢坪數請勿空白");
			}
			//System.out.println("有進來inquiry6===================");
			String strbudget = req.getParameter("inquirybudget");
			System.out.println("inquirycontroller之strbudget:"+strbudget);
			Integer inquiryBudget=null;
			try {
			inquiryBudget = Integer.valueOf(strbudget);
			} catch (Exception e) {
				errorMsgs.add("諮詢預算請勿空白");
			}
			//System.out.println("有進來inquiry7===================");
			String inquiryDetail = req.getParameter("inquiryDetail").trim();
			if(inquiryDetail==null||inquiryDetail.trim().length()==0) {
				errorMsgs.add("諮詢內容請勿空白");
			}
			
			if (!errorMsgs.isEmpty()) {
				//System.out.println("inquiry-done1=============================");
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/designer/inquiryPage.jsp");
				failureView.forward(req, res);
				return;
			}
			
			DesignerOrderService designerOrderSvc = new DesignerOrderService();
			designerOrderSvc.insertOrderInquiry(designerNo, memberNo, inquiryBudget, inquirySize, inquiryDetail);
			//將findDesigner頁面的設計師資訊回填
			DesignerExpertiseService designerExpertiseScv = new DesignerExpertiseService();
			Set<DesignerExpertiseVO> set = designerExpertiseScv.getAll();
			session.setAttribute("set", set);
			PrintWriter out = res.getWriter();
			out.print("<meta http-equiv='refresh' content='1;URL=" + req.getContextPath()
					+ "/front-end/designer/findDesigner.jsp'>");// redirects after 1 seconds
			res.getWriter().print("<script>alert('諮詢資料已送出，請等待設計師與您回覆，謝謝!');</script>");
			return;
		}

	}

}
