package com.designer.model;

import java.util.*;

import com.designer.model.DesignerVO;

public interface ExpertiseDAO_interface {
	public void insert(ExpertiseVO expertiseVO);
	public void update(ExpertiseVO expertiseVO);
	public void delete(Integer expertiseNo);
	public ExpertiseVO findExpertiseNo(Integer expertiseNo);
	public List<ExpertiseVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//     public List<EmpVO> getAll(Map<String, String[]> map); 

}
