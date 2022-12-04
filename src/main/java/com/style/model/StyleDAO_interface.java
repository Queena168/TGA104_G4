package com.style.model;

import java.util.List;

public interface StyleDAO_interface {
	public void insert(StyleVO styleVO);
	public void update(StyleVO styleVO);
	public void delete(Integer styleNo);
	public StyleVO findByPrimaryKey(Integer styleNo);
	public List<StyleVO> getAll();
}
