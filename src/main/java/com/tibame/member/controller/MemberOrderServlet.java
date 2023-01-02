package com.tibame.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tibame.designer.model.DesignerOrderPhaseVO;
import com.tibame.designer.model.DesignerOrderVO;
import com.tibame.designer.service.DesignerOrderPhaseService;
import com.tibame.designer.service.DesignerOrderService;
import com.tibame.member.model.MemberService;

/**
 * Servlet implementation class MemberOrderServlet
 */
@WebServlet("/front-end/member/MemberOrderServlet")
@MultipartConfig
public class MemberOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		if ("confirmedQuotation".equals(action)) { // 來自/front-end/member/designerOrederDetail.jsp 點擊 同意報價 按鈕的請求
			/*************************** 1.接收請求參數 **********************/
			Integer orderNo = Integer.valueOf(req.getParameter("orderNo"));
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
			String quotationStatus = "同意報價";
			String contractStatus = "確認中";

			DesignerOrderVO confirmrdOrderVO = new DesignerOrderVO();
			confirmrdOrderVO.setOrderNo(orderNo);
			confirmrdOrderVO.setQuotationStatus(quotationStatus);
			confirmrdOrderVO.setContractStatus(contractStatus);
			/*************************** 2.開始修改資料 *****************************************/
			// 修改報價狀態
			MemberService memberSvc = new MemberService();
			DesignerOrderService designerOrderSvc = new DesignerOrderService();
			memberSvc.confirmrdOrderVO(orderNo, quotationStatus);
			confirmrdOrderVO = designerOrderSvc.getDesignerOrder(orderNo);
			// 修改合約狀態
			memberSvc.confirmrdContract(orderNo, contractStatus);
			confirmrdOrderVO = designerOrderSvc.getDesignerOrder(orderNo);

			DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
			List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("findDesignerOrder", findDesignerOrder);
			req.setAttribute("desOrderList", desOrderList);
			req.setAttribute("designerOrderPhase", designerOrderPhase);

			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
			successView.forward(req, res);

		}

		if ("rejectQuotation".equals(action)) { // 來自/front-end/member/designerOrederDetail.jsp 點擊退回報價單按鈕的請求
			/*************************** 1.接收請求參數 **********************/
			Integer orderNo = Integer.valueOf(req.getParameter("orderNo"));
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
			String quotationStatus = "退回報價";

			DesignerOrderVO confirmrdOrderVO = new DesignerOrderVO();
			confirmrdOrderVO.setOrderNo(orderNo);
			confirmrdOrderVO.setQuotationStatus(quotationStatus);
			/*************************** 2.開始修改資料 *****************************************/
			// 修改報價單狀態
			MemberService memberSvc = new MemberService();
			DesignerOrderService designerOrderSvc = new DesignerOrderService();
			memberSvc.confirmrdOrderVO(orderNo, quotationStatus);
			confirmrdOrderVO = designerOrderSvc.getDesignerOrder(orderNo);

			DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
			List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("findDesignerOrder", findDesignerOrder);
			req.setAttribute("desOrderList", desOrderList);
			req.setAttribute("designerOrderPhase", designerOrderPhase);


			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
			successView.forward(req, res);

		}

		if ("confirmedContract".equals(action)) { // 來自/front-end/member/designerOrederDetail.jsp 點擊確認合約按鈕的請求
			/*************************** 1.接收請求參數 **********************/
			Integer orderNo = Integer.valueOf(req.getParameter("orderNo"));
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
			String contractStatus = "同意合約";

			DesignerOrderVO confirmrdContract = new DesignerOrderVO();
			confirmrdContract.setOrderNo(orderNo);
			confirmrdContract.setContractStatus(contractStatus);
			/*************************** 2.開始修改資料 *****************************************/
			//修改合約狀態
			MemberService memberSvc = new MemberService();
			DesignerOrderService designerOrderSvc = new DesignerOrderService();
			memberSvc.confirmrdContract(orderNo, contractStatus);
			confirmrdContract = designerOrderSvc.getDesignerOrder(orderNo);

			DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
			List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("findDesignerOrder", findDesignerOrder);
			req.setAttribute("desOrderList", desOrderList);
			req.setAttribute("designerOrderPhase", designerOrderPhase);


			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
			successView.forward(req, res);

		}

		if ("rejectContract".equals(action)) { // 來自/front-end/member/designerOrederDetail.jsp 點擊退回合約按鈕的請求
			/*************************** 1.接收請求參數 **********************/
			Integer orderNo = Integer.valueOf(req.getParameter("orderNo"));
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
			String contractStatus = "退回合約";

			DesignerOrderVO confirmrdContract = new DesignerOrderVO();
			confirmrdContract.setOrderNo(orderNo);
			confirmrdContract.setContractStatus(contractStatus);
			/*************************** 2.開始修改資料 *****************************************/
			//修改合約狀態
			MemberService memberSvc = new MemberService();
			DesignerOrderService designerOrderSvc = new DesignerOrderService();
			memberSvc.confirmrdContract(orderNo, contractStatus);
			confirmrdContract = designerOrderSvc.getDesignerOrder(orderNo);

			DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

			DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
			List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
			List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("findDesignerOrder", findDesignerOrder);
			req.setAttribute("desOrderList", desOrderList);
			req.setAttribute("designerOrderPhase", designerOrderPhase);
			

			RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
			successView.forward(req, res);

		}
		
		if("upload_paymentPic".equals(action)) { // 來自/front-end/member/designerOrederDetail.jsp 點擊 上傳 付款附件按鈕的請求 
			/*************************** 1.接收請求參數 **********************/
			Integer phaseNo = Integer.valueOf(req.getParameter("phaseNo"));
			Integer orderNo = Integer.valueOf(req.getParameter("orderNo"));
			Integer orderPhase = Integer.valueOf(req.getParameter("orderPhase"));
			Integer totalOrderPhase = Integer.valueOf(req.getParameter("totalOrderPhase"));
			
			if(orderPhase==totalOrderPhase) {
				MemberService memberSvc = new MemberService();
				DesignerOrderVO designerOrderVO = memberSvc.findDesignerOrder(orderNo);
				Integer memberNo = designerOrderVO.getMemberNo();
//				Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
				
				String paymentStatus = "完成付款";
				Boolean finishStatus = true;
				DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
				designerOrderPhaseVO.setPhaseNo(phaseNo);
				designerOrderPhaseVO.setPaymentStatus(paymentStatus);
				
				byte[] quotationAtt = req.getPart("quotationAtt").getInputStream().readAllBytes();
				if (quotationAtt.length == 0) {
					quotationAtt = null;
				}
//				Part part = req.getPart("quotationAtt");
//				InputStream in = part.getInputStream();
//				byte[] quotationAtt = new byte[in.available()];
//				in.read(quotationAtt);
//				in.close();
//				if (quotationAtt.length == 0) {
//					quotationAtt = null;
//				}
				/*************************** 2.開始修改資料 *****************************************/
				
				memberSvc.updatePharePayment(phaseNo, quotationAtt);
				memberSvc.updateOrderFinishStatus(orderNo, finishStatus);
				DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

				DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
				List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
				List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("findDesignerOrder", findDesignerOrder);
				req.setAttribute("desOrderList", desOrderList);
				req.setAttribute("designerOrderPhase", designerOrderPhase);
				

				RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
				successView.forward(req, res);
			}else {
				MemberService memberSvc = new MemberService();
				DesignerOrderVO designerOrderVO = memberSvc.findDesignerOrder(orderNo);
				Integer memberNo = designerOrderVO.getMemberNo();
//				Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));
				
				String paymentStatus = "完成付款";
				
				DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
				designerOrderPhaseVO.setPhaseNo(phaseNo);
				designerOrderPhaseVO.setPaymentStatus(paymentStatus);
				
				byte[] quotationAtt = req.getPart("quotationAtt").getInputStream().readAllBytes();
				if (quotationAtt.length == 0) {
					quotationAtt = null;
				}
//				Part part = req.getPart("quotationAtt");
//				InputStream in = part.getInputStream();
//				byte[] quotationAtt = new byte[in.available()];
//				in.read(quotationAtt);
//				in.close();
//				if (quotationAtt.length == 0) {
//					quotationAtt = null;
//				}
				/*************************** 2.開始修改資料 *****************************************/
				
				memberSvc.updatePharePayment(phaseNo, quotationAtt);
				
				DesignerOrderVO findDesignerOrder = memberSvc.findDesignerOrder(orderNo);

				DesignerOrderPhaseService designerOrderPhaseSvc = new DesignerOrderPhaseService();
				List<DesignerOrderVO> desOrderList = memberSvc.selectbyMemberNo(memberNo);
				List<DesignerOrderPhaseVO> designerOrderPhase = designerOrderPhaseSvc.getOrderPhase(orderNo);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("findDesignerOrder", findDesignerOrder);
				req.setAttribute("desOrderList", desOrderList);
				req.setAttribute("designerOrderPhase", designerOrderPhase);
				

				RequestDispatcher successView = req.getRequestDispatcher("/front-end/member/designerOrderDetailUpdate.jsp");
				successView.forward(req, res);
			}
		}

	}

}
