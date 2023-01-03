package com.tibame.designer.service;

import java.util.List;

import com.tibame.designer.model.DesignerDAO_interface;
import com.tibame.designer.model.DesignerJNDIDAO;
import com.tibame.designer.model.DesignerVO;


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
			String designerCompany, byte[] designerPic,String phone,String designerDetail) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
		designerVO.setDesignerPic(designerPic);
		designerVO.setPhone(phone);
		designerVO.setDesignerDetail(designerDetail);
		dao.insertDesigner(designerVO);
		return designerVO;
	}
	
	public DesignerVO updateDesigner(Integer designerNo, String designerAccount, String designerPassword, String designerName,
			String designerCompany, byte[] designerPic,String designerDetail) {
		DesignerVO designerVO = new DesignerVO();
		designerVO.setDesignerNo(designerNo);
		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
		designerVO.setDesignerPic(designerPic);
		designerVO.setDesignerDetail(designerDetail);
		dao.update(designerVO);
		return dao.findByPrimaryKey(designerNo);
	}
	
	

	public DesignerVO updateDesignerNOPic(Integer designerNo, String designerAccount, String designerPassword, String designerName,
			String designerCompany,String designerDetail) {

		DesignerVO designerVO = new DesignerVO();

		designerVO.setDesignerNo(designerNo);
		designerVO.setDesignerAccount(designerAccount);
		designerVO.setDesignerPassword(designerPassword);
		designerVO.setDesignerName(designerName);
		designerVO.setDesignerCompany(designerCompany);
        designerVO.setDesignerDetail(designerDetail); 
		dao.updatenoPic(designerVO);
		return dao.findByPrimaryKey(designerNo);
	}


	public void deleteDesigner(Integer designerNo) {
		dao.delete(designerNo);
	}

	public DesignerVO getOneDesigner(Integer designerNo) {
		return dao.findByPrimaryKey(designerNo);
	}
	
	public DesignerVO getOneDesignerinfo(Integer designerNo) {
		return dao.findByPrimaryKey(designerNo);
	}
	
	
	public DesignerVO logindesigner(String designerAccount,String designerPassword) {
		return dao.login(designerAccount, designerPassword);
		
	}

	

	public List<DesignerVO> getAll() {
		return dao.getAll();
	}
	
	public void updatedesignersuccess(Integer designerNo) {
	dao.updatesuccess(designerNo);
}
	
	public void updatedesignerfail(Integer designerNo) {

	    dao.updatefail(designerNo);
}
	


}
