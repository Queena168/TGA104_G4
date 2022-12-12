package com.expertise.Service;

import java.util.List;
import com.expertise.model.ExpertiseDAO_interface;
import com.expertise.model.ExpertiseJNDIDAO;
import com.expertise.model.ExpertiseVO;

public class ExpertiseService {

	private ExpertiseDAO_interface dao;

	public ExpertiseService() {
		dao = new ExpertiseJNDIDAO();
	}

	public List<ExpertiseVO> getAll() {
		return dao.getAll();
	}

	public ExpertiseVO getOneExpertise(Integer expertiseNo) {
		return dao.findExpertiseNo(expertiseNo);
	}


}
