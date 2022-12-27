package designer.service;

import java.util.List;

import designer.model.DesignerOrderPhaseDAO_interface;
import designer.model.DesignerOrderPhaseJNDIDAO;
import designer.model.DesignerOrderPhaseVO;

public class DesignerOrderPhaseService {

	private DesignerOrderPhaseDAO_interface dao;

	public DesignerOrderPhaseService() {
		dao = new DesignerOrderPhaseJNDIDAO();
	}
	
	
	public  DesignerOrderPhaseVO insertDesignerOrderPhase(Integer orderNo, Integer orderPhase, Integer amount, byte[] contractAtt) {

		DesignerOrderPhaseVO designerOrderPhaseVO = new DesignerOrderPhaseVO();
		designerOrderPhaseVO.setOrderNo(orderNo);
		designerOrderPhaseVO.setOrderPhase(orderPhase);
		designerOrderPhaseVO.setAmount(amount);
		
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
