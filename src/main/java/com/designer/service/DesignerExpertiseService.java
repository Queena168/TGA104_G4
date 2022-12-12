package com.designerExpertise.Service;

import java.util.List;
import java.util.Set;
import com.designerExpertise.model.DesignerExpertiseDAO_interface;
import com.designerExpertise.model.DesignerExpertiseJNDIDAO;
import com.designerExpertise.model.DesignerExpertiseVO;

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


}
