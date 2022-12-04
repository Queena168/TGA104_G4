package com.designer.service;

import java.util.List;

import com.designer.model.DesignerDAO_interface;
import com.designer.model.DesignerJNDIDAO;
import com.designer.model.DesignerVO;

public class DesignerService {

	private DesignerDAO_interface dao;

	public DesignerService() {
		dao = new DesignerJNDIDAO();
	}

	public DesignerVO addDesigner(String designerAccount, String designerPassword, String designerName,
			String designerCompany, byte[] designerPic, String approvalStatus, java.sql.Date approvalTime,
			Integer approver, Boolean designerStatus) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
		designerVO.setDesignerPic(designerPic);
		designerVO.setApprovalStatus(approvalStatus);
		designerVO.setApprovalTime(approvalTime);
		designerVO.setApprover(approver);
		designerVO.setDesignerStatus(designerStatus);
		dao.insert(designerVO);

		return designerVO;
	}
	
	
	
	
	public DesignerVO addDesignerinfo(String designerAccount, String designerPassword, String designerName,
			String designerCompany, byte[] designerPic) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
		designerVO.setDesignerPic(designerPic);
		dao.insertDesigner(designerVO);

		return designerVO;
	}


//	// 預留給 Struts 2 或 Spring MVC 用
//	public void addDesigner(DesignerVO designerVO) {
//		dao.insert(designerVO);
//	}
//	
	
	
	public DesignerVO updateDesigner(Integer designerNo, String designerAccount, String designerPassword, String designerName,
			String designerCompany, byte[] designerPic/*, String approvalStatus, java.sql.Date approvalTime,
			Integer approver, Boolean designerStatus*/) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerNo(designerNo);
		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
		designerVO.setDesignerPic(designerPic);
//		designerVO.setApprovalStatus(approvalStatus);
//		designerVO.setApprovalTime(approvalTime);
//		designerVO.setApprover(approver);
//		designerVO.setDesignerStatus(designerStatus);    
		dao.update(designerVO);

		return dao.findByPrimaryKey(designerNo);
	}
	
	
	
	
	
	
	
	

	public DesignerVO updateDesignerNOPic(Integer designerNo, String designerAccount, String designerPassword, String designerName,
			String designerCompany/*, byte[] designerPic, String approvalStatus, java.sql.Date approvalTime,
			Integer approver, Boolean designerStatus*/) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerNo(designerNo);
		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
//		designerVO.setDesignerPic(designerPic);
//		designerVO.setApprovalStatus(approvalStatus);
//		designerVO.setApprovalTime(approvalTime);
//		designerVO.setApprover(approver);
//		designerVO.setDesignerStatus(designerStatus);    
		dao.updatenoPic(designerVO);

		return dao.findByPrimaryKey(designerNo);
	}

	// 預留給 Struts 2 用的
//	public void updatedesigner(DesignerVO designerVO) {
//		dao.update(designerVO);
//	}

	public void deleteDesigner(Integer designerVO) {
		dao.delete(designerVO);
	}

	public DesignerVO getOneDesigner(Integer designerVO) {
		return dao.findByPrimaryKey(designerVO);
	}
	
	public DesignerVO getOneDesignerinfo(Integer designerVO) {
		return dao.findByPrimaryKey(designerVO);
	}

	

	public List<DesignerVO> getAll() {
		return dao.getAll();
	}
	


}
