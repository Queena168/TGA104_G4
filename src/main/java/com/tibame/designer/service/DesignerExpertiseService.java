package com.tibame.designer.service;

import java.util.List;
import java.util.Set;

import com.tibame.designer.model.DesignerExpertiseDAO_interface;
import com.tibame.designer.model.DesignerExpertiseJNDIDAO;
import com.tibame.designer.model.DesignerExpertiseVO;

public class DesignerExpertiseService {

	private DesignerExpertiseDAO_interface dao;

	public DesignerExpertiseService() {
		dao = new DesignerExpertiseJNDIDAO();
	}

		
	public Set<DesignerExpertiseVO> getAll() {
		return dao.getAll();
	}
	
	
	public List<DesignerExpertiseVO> getMyExpertise(Integer designerNo){
		return dao.getMyExpertise(designerNo);
	}
	
	
	public DesignerExpertiseVO getMyExpertises(Integer designerNo) {
		return dao.getMyExpertises(designerNo);
	}
	
	public Set<DesignerExpertiseVO> getExpertiseDesigner(Integer expertiseNo){
		return dao.getExpertiseDesigner(expertiseNo);
	}


}
