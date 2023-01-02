package com.tibame.designer.service;

import java.util.List;

import com.tibame.designer.model.DesignerOrderPhaseDAO_interface;
import com.tibame.designer.model.DesignerOrderPhaseJNDIDAO;
import com.tibame.designer.model.DesignerOrderPhaseVO;

public class DesignerOrderPhaseService {

	private DesignerOrderPhaseDAO_interface dao;

	public DesignerOrderPhaseService() {
		dao = new DesignerOrderPhaseJNDIDAO();
	}
	
	
	public  DesignerOrderPhaseVO insertDesignerOrderPhase(Integer orderNo, Integer totalOrderPhase, Integer totalamount) {

		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setTotalOrderPhase(totalOrderPhase);
		designerOrderPhaseVO.setTotalAmount(totalamount);	
		dao.insert(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
//	public  DesignerOrderPhaseVO insertDesignerOrderPhaseConstruction(Integer orderNo,Integer totalOrderPhase,Integer orderPhase,String constructionStatus,String contractDetail,byte[] orderPhaseAtt) {
//		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
//		designerOrderPhaseVO.setOrderNo(orderNo);
//		designerOrderPhaseVO.setTotalOrderPhase(totalOrderPhase);
//		designerOrderPhaseVO.setOrderPhase(orderPhase);
//		designerOrderPhaseVO.setConstructionStatus(constructionStatus);
//		designerOrderPhaseVO.setOrderPhaseDetail(contractDetail);
//		designerOrderPhaseVO.setOrderPhaseAtt(orderPhaseAtt);
//		//System.out.println("你好友執行到1");
//		dao.insertDesignerOrderPhaseConstruction(designerOrderPhaseVO);
//		return designerOrderPhaseVO;
//	}
	
	
	//==========================================================
	public  DesignerOrderPhaseVO insertDesignerOrderPhaseConstruction(Integer orderNo,Integer totalOrderPhase,Integer orderPhase, Integer totalAmount,String constructionStatus,String contractDetail) {
		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setTotalOrderPhase(totalOrderPhase);
		designerOrderPhaseVO.setOrderPhase(orderPhase);
		designerOrderPhaseVO.setTotalAmount(totalAmount);
		designerOrderPhaseVO.setConstructionStatus(constructionStatus);
		designerOrderPhaseVO.setOrderPhaseDetail(contractDetail);
		//designerOrderPhaseVO.setOrderPhaseAtt(orderPhaseAtt);
		dao.insertDesignerOrderPhaseConstruction(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
	
	
	//=============================================================
	
	
	
//	
//	public  DesignerOrderPhaseVO updateDesignerOrderPhasePayment(Integer orderNo,String paymentStatus) {
//		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
//		designerOrderPhaseVO.setOrderNo(orderNo);
//		designerOrderPhaseVO.setPaymentStatus(paymentStatus);
//		dao.updateDesignerOrderPhasePayment(designerOrderPhaseVO);
//		return designerOrderPhaseVO;
//	}
	
	//===================================================================================
	
	
	public  DesignerOrderPhaseVO updateDesignerOrderPhasePayment(Integer orderNo,String paymentStatus ,Integer orderPhase,String constructionStatus,Integer paymentnumber) {
		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setPaymentStatus(paymentStatus);
		designerOrderPhaseVO.setOrderPhase(orderPhase);
		designerOrderPhaseVO.setConstructionStatus(constructionStatus);
		designerOrderPhaseVO.setAmount(paymentnumber);
		dao.updateDesignerOrderPhasePayment(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
	
	
	//===================================================================================
	
	public List<DesignerOrderPhaseVO> getOrderPhase(Integer orderNo) {
		return dao.findDesignerOrderPhase(orderNo);
		
	}
	public DesignerOrderPhaseVO getOneOrderPhase(Integer orderNo) {
		return dao.findOneDesignerOrderPhase(orderNo);
	}
	
	public List<DesignerOrderPhaseVO> getOrderPhase() {
		return dao.testfindDesignerOrderPhase();
		
	}

}
