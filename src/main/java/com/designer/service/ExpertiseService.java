package com.designer.service;

import java.util.List;

import com.designer.model.ExpertiseDAO_interface;
import com.designer.model.ExpertiseJNDIDAO;
import com.designer.model.ExpertiseVO;

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
