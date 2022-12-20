package com.designer.service;

import java.sql.Date;
import java.util.List;

import com.designer.model.DesignerOrderDAO_interface;
import com.designer.model.DesignerOrderJNDIDAO;
import com.designer.model.DesignerOrderVO;

public class DesignerOrderService {

	private DesignerOrderDAO_interface dao;

	public DesignerOrderService() {
		dao = new DesignerOrderJNDIDAO();
	}


	public DesignerOrderVO updateDesignerOrder(Integer orderNo, Integer quotationAmount, String quotationDetail,
			Date quotationSendTime, byte[] quotationAtt, String quotationStatus, String contractDetail,
			byte[] contractAtt, String contractStatus, Date contractApprovalTime, Date contractModificationTime,
			String quotationNote, String contractNote, Boolean finishStatus) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setQuotationAmount(quotationAmount);	
		designerOrderVO.setQuotationDetail(quotationDetail);		
		designerOrderVO.setQuotationSendTime(quotationSendTime);	
		designerOrderVO.setQuotationAtt(quotationAtt);	
		designerOrderVO.setQuotationStatus(quotationStatus);		
		designerOrderVO.setContractDetail(contractDetail);	
		designerOrderVO.setContractAtt(contractAtt);		
		designerOrderVO.setContractStatus(contractStatus);		
		designerOrderVO.setContractApprovalTime(contractApprovalTime);
		designerOrderVO.setContractModificationTime(contractModificationTime);
		designerOrderVO.setQuotationNote(quotationNote);
		designerOrderVO.setContractNote(contractNote);
		designerOrderVO.setFinishStatus(finishStatus);
		dao.update(designerOrderVO);

		return dao.findDesignerOrder(orderNo);
	}

	// ========================================================================================
	
	
	public DesignerOrderVO updateQuotation(Integer orderNo,Integer quotationAmount,String quotationDetail) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setQuotationAmount(quotationAmount);	
		designerOrderVO.setQuotationDetail(quotationDetail);			
		dao.updateQuotation(designerOrderVO);

		return designerOrderVO;    /*dao.findDesignerOrder(orderNo);*/
	}
	
	
	//====================================================================================
	
	public DesignerOrderVO updateContract(Integer orderNo,String contractDetail) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setContractDetail(contractDetail);			
		dao.updateContract(designerOrderVO);

		return designerOrderVO;    /*dao.findDesignerOrder(orderNo);*/
	}
	
    //===================================================================================
	public DesignerOrderVO insertOrderInquiry(Integer designerNo, Integer memberNo, Integer inquiryBudget,
			Integer inquirySize, String inquiryDetail) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();
		designerOrderVO.setDesignerNo(designerNo);
		designerOrderVO.setMemberNo(memberNo);
		designerOrderVO.setInquiryBudget(inquiryBudget);
		designerOrderVO.setInquirySize(inquirySize);
		designerOrderVO.setInquiryDetail(inquiryDetail);
		dao.insertinquiry(designerOrderVO);
		return designerOrderVO;
	}

	// ========================================================================================

	public DesignerOrderVO getMyOrder(Integer designerOrderNo) {
		return dao.findDesignerOrder(designerOrderNo);
	}

	public DesignerOrderVO getDesignerOrder(Integer designerOrderNo) {
		return dao.findDesignerOrder(designerOrderNo);
	}

	public List<DesignerOrderVO> getAll() {
		return dao.getAll();
	}
	
	
	
	
    //查詢該設計師的所有案件
	public List<DesignerOrderVO> getAllMyOrder(Integer designerNo) {
		return dao.getAllMyOrder(designerNo);
	}
	
	
    //查詢該設計師的進行中案件
//	public List<DesignerOrderVO> getAllMyINGOrder(Integer designerNo) {
//		return dao.getAllMyINGOrder(designerNo);
//	}
//	
	 //如結案狀態為未結案則取得設計師進行中訂單，如結案狀態為結案則取得設計師結案訂單
	public List<DesignerOrderVO> getAllMyisFinishOrder(Integer designerNo) {
		return dao.getAllMyisFinishOrder(designerNo);
	}
	
	
    //查詢該使用者的所有裝潢訂單	
	public List<DesignerOrderVO> getMemberAllMyOrder(Integer memberNo) {
		return dao.getMemberAllMyOrder(memberNo);
	}
	
	  //查詢該設計師的所有報價
	public List<DesignerOrderVO> getAllMyQuotation(Integer designerNo) {
		return dao.getAllMyQuotation(designerNo);
	}
	
	   //查詢該使用者的所有裝潢報價	
		public List<DesignerOrderVO> getMemberAllMyQuotation(Integer memberNo) {
			return dao.getMemberAllMyQuotation(memberNo);
		}
	
		
		  //查詢該設計師的所有合約
		public List<DesignerOrderVO> getAllMyContract(Integer designerNo) {
			return dao.getAllMyContract(designerNo);
		}
		
		   //查詢該使用者的所有裝潢合約	
			public List<DesignerOrderVO> getMemberAllMyContract(Integer memberNo) {
				return dao.getMemberAllMyContract(memberNo);
			}
	
	

}
