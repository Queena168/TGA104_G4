package com.portfolio.model;

import java.util.List;

public interface PortfolioDAO_interface {
	public void insert(PortfolioVO portfolioVO);
	public void update(PortfolioVO portfolioVO);
	public void delete(Integer portfolioNo);
	public PortfolioVO findByPrimaryKey(Integer portfolioNo);
	public List<PortfolioVO> getAll();
	
}
