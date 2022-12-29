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
		designerOrderPhaseVO.setTotalamount(totalamount);	
		System.out.println("正要開始執行insert");
		dao.insert(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
	public  DesignerOrderPhaseVO InsertDesignerOrderPhaseConstruction(Integer orderNo,String constructionStatus,String contractDetail) {
		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setConstructionStatus(constructionStatus);
		designerOrderPhaseVO.setOrderPhaseDetail(contractDetail);
		dao.InsertDesignerOrderPhaseConstruction(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
	public  DesignerOrderPhaseVO InsertDesignerOrderPhasePayment(Integer orderNo,String paymentStatus) {
		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setPaymentStatus(paymentStatus);
		dao.InsertDesignerOrderPhasePayment(designerOrderPhaseVO);
		return designerOrderPhaseVO;
	}
	
	public List<DesignerOrderPhaseVO> getOrderPhase(Integer orderNo) {
		return dao.findDesignerOrderPhase(orderNo);
		
	}
	public DesignerOrderPhaseVO getOneOrderPhase(Integer orderNo) {
		return dao.findOneDesignerOrderPhase(orderNo);
	}

}
