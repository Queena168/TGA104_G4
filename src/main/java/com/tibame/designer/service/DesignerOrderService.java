package designer.service;

import java.util.List;

import designer.model.DesignerOrderDAO_interface;
import designer.model.DesignerOrderJNDIDAO;
import designer.model.DesignerOrderVO;

public class DesignerOrderService {

	private DesignerOrderDAO_interface dao;

	public DesignerOrderService() {
		dao = new DesignerOrderJNDIDAO();
	}

	
	public DesignerOrderVO updateQuotation(Integer orderNo,Integer quotationAmount,String quotationDetail,byte[] quotationAtt) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setQuotationAmount(quotationAmount);	
		designerOrderVO.setQuotationDetail(quotationDetail);
		designerOrderVO.setQuotationAtt(quotationAtt);
		dao.updateQuotation(designerOrderVO);

		return designerOrderVO; 
	}
	
	
	//====================================================================================
	
	public DesignerOrderVO updateContract(Integer orderNo,String contractDetail,byte[] contractAtt) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);
		designerOrderVO.setContractDetail(contractDetail);	
		designerOrderVO.setContractAtt(contractAtt);
		dao.updateContract(designerOrderVO);

		return designerOrderVO; 
	}

	//===================================================================================
	
	
	public DesignerOrderVO updateFinishedStatus(Integer orderNo) {

		DesignerOrderVO designerOrderVO = new DesignerOrderVO();

		designerOrderVO.setOrderNo(orderNo);		
		dao.updateFinished(designerOrderVO);
		return designerOrderVO; 
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

	
    //查詢該設計師的所有案件
	public List<DesignerOrderVO> getAllMyOrder(Integer designerNo) {
		return dao.getAllMyOrder(designerNo);
	}
	
	
    //查詢該設計師的進行中案件
	public List<DesignerOrderVO> getAllMyINGOrder(Integer designerNo) {
		return dao.getAllMyINGOrder(designerNo);
	}
	
	 //如結案狀態為結案則取得設計師結案訂單
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
