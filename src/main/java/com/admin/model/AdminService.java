package com.admin.model;

import java.sql.Timestamp;
import java.util.List;

public class AdminService {
	private AdminDAO_interface dao;
	
	public AdminService() {
		dao = new AdminDAO();
	}
	
	public AdminVO addAdmin (String adminEmail, String adminPassword, 
			String adminName, byte[] adminPic, String adminPrivilege, Integer uploader) {
		
		AdminVO adminVO = new AdminVO();
		
		adminVO.setAdminEmail(adminEmail);
		adminVO.setAdminPassword(adminPassword);
		adminVO.setAdminName(adminName);
		adminVO.setAdminPic(adminPic);
		adminVO.setAdminPrivilege(adminPrivilege);
		adminVO.setUploader(uploader);
		dao.insert(adminVO);
		
		return adminVO;
	}
	
	
	public AdminVO updateAdmin (Integer adminNo, String adminEmail, String adminPassword, 
			String adminName, byte[] adminPic, String adminPrivilege) {
		
		AdminVO adminVO = new AdminVO();
		
		adminVO.setAdminNo(adminNo);
		adminVO.setAdminEmail(adminEmail);
		adminVO.setAdminPassword(adminPassword);
		adminVO.setAdminName(adminName);
		adminVO.setAdminPic(adminPic);
		adminVO.setAdminPrivilege(adminPrivilege);
//		adminVO.setUploader(uploader);
		dao.update(adminVO);
		
		return adminVO;
	}
	
	public void deleteAdmin(Integer adminNo) {
		dao.delete(adminNo);
	}
	
	public AdminVO getOneAdmin(Integer adminNo) {
		return dao.findByPrimaryKey(adminNo);
	}
	
	public List<AdminVO> getAll(){
		return dao.getAll();
	}
}
