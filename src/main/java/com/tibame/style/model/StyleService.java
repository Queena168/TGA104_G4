package com.tibame.style.model;

import java.util.List;

public class StyleService {
	private StyleDAO_interface dao;
	
	public StyleService() {
		dao = new StyleDAO();
	}
	
	public StyleVO addStyle(String styleName) {
		StyleVO styleVO = new StyleVO();
	
		styleVO.setStyleName(styleName);
		dao.insert(styleVO)
		;
		return styleVO;
	}
	
	public StyleVO updateStyle(String styleName) {
		StyleVO styleVO = new StyleVO();
		
		styleVO.setStyleName(styleName);
		dao.update(styleVO);
		
		return styleVO;
	}
	
	public void deleteStyle(Integer styleNo) {
		dao.delete(styleNo);
	}
	
	public StyleVO getOneStyle(Integer styleNo) {
		return dao.findByPrimaryKey(styleNo);
	}
	
	public List<StyleVO> getAll(){
		return dao.getAll();
	}
}
