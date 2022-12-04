package com.portfoliostyle.model;

import java.util.List;

public interface PortfolioStyleDAO_interface {
	public void insert(PortfolioStyleVO portfolioStyleVO);
	public void update(PortfolioStyleVO portfolioStyleVO);
	public void delete(Integer portfolioStyleNO);
	public PortfolioStyleVO findByPrimaryKey(Integer portfolioStyleNO);
	public List<PortfolioStyleVO> getAll();
	
}
