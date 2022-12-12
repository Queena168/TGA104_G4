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

//	public DesignerOrderVO addDesigner(String designerAccount, String designerPassword, String designerName,
//			String designerCompany, byte[] designerPic, String approvalStatus, java.sql.Date approvalTime,
//			Integer approver, Boolean designerStatus) {
//
//		DesignerOrderVO designerOrderVO = new DesignerOrderVO();
//
//		designerOrderVO.setDesignerAccount(designerAccount);
//		designerOrderVO.setDesignerPassword(designerPassword);
//		designerOrderVO.setDesignerName(designerName);
//		designerOrderVO.setDesignerCompany(designerCompany);
//		designerOrderVO.setDesignerPic(designerPic);
//		designerOrderVO.setApprovalStatus(approvalStatus);
//		designerOrderVO.setApprovalTime(approvalTime);
//		designerOrderVO.setApprover(approver);
//		designerOrderVO.setDesignerStatus(designerStatus);
//		dao.insert(designerOrderVO);
//
//		return designerOrderVO;
//	}

//	// 預留給 Struts 2 或 Spring MVC 用
//	public void addDesigner(designerOrderVO designerOrderVO) {
//		dao.insert(designerOrderVO);
//	}
//	

	public DesignerOrderVO updateDesignerOrder(Integer orderNo,Integer quotationAmount,String quotationDetail,Date quotationSendTime,byte[] quotationAtt,String quotationStatus,String contractDetail,byte[] contractAtt,String contractStatus,Date contractApprovalTime,Date contractModificationTime,String quotationNote,String contractNote,Boolean finishStatus) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setQuotationAmount(quotationAmount);;
		designerOrderVO.setQuotationDetail(quotationDetail);;
		designerOrderVO.setQuotationSendTime(quotationSendTime);;
		designerOrderVO.setQuotationAtt(quotationAtt);;
		designerOrderVO.setQuotationStatus(quotationStatus);;
		designerOrderVO.setContractDetail(contractDetail);;
		designerOrderVO.setContractAtt(contractAtt);;
		designerOrderVO.setContractStatus(contractStatus);;
		designerOrderVO.setContractApprovalTime(contractApprovalTime);
		designerOrderVO.setContractModificationTime(contractModificationTime);
		designerOrderVO.setQuotationNote(quotationNote);
		designerOrderVO.setContractNote(contractNote);
		designerOrderVO.setFinishStatus(finishStatus);
		dao.update(designerOrderVO);

		return dao.findDesignerOrder(orderNo);
	}

	// 預留給 Struts 2 用的
//	public void updatedesigner(designerOrderVO designerOrderVO) {
//		dao.update(designerOrderVO);
//	}
	
	public DesignerOrderVO getMyOrder(Integer designerOrderNo) {
		return dao.findDesignerOrder(designerOrderNo);
	}


	public DesignerOrderVO getDesignerOrder(Integer designerOrderNo) {
		return dao.findDesignerOrder(designerOrderNo);
	}
	
	public List<DesignerOrderVO> getAll(){
		return dao.getAll();
	}

	public List<DesignerOrderVO> getAllMyOrder(Integer designerNo) {
		return dao.getAllMyOrder(designerNo);
	}

}
