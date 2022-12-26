package com.tibame.portfoliostyle.model;

import java.util.List;

public class PortfolioStyleService {
	private PortfolioStyleDAO_interface dao;
	
	public PortfolioStyleService() {
		dao = new PortfolioStyleDAO();
	}
	
	public PortfolioStyleVO addPortfolioStyle (Integer portfolioNo, Integer styleNo) {
		PortfolioStyleVO portfolioStyleVO = new PortfolioStyleVO();
		
		portfolioStyleVO.setPortfolioNo(portfolioNo);
		portfolioStyleVO.setStyleNo(styleNo);
		dao.insert(portfolioStyleVO);
		
		return portfolioStyleVO;
	}
	
	public PortfolioStyleVO updatePortfolioStyle (Integer portfolioStyleNO, Integer portfolioNo, Integer styleNo) {
		PortfolioStyleVO portfolioStyleVO = new PortfolioStyleVO();
	
		portfolioStyleVO.setPortfolioStyleNO(portfolioStyleNO);
		portfolioStyleVO.setPortfolioNo(portfolioNo);
		portfolioStyleVO.setStyleNo(styleNo);
		dao.update(portfolioStyleVO);
		
		return portfolioStyleVO;
	}
	
	public void deletePortfolioStyle(Integer portfolioStyleNO) {
		dao.delete(portfolioStyleNO);
	}
	
	public PortfolioStyleVO getOnePortfolioStyle(Integer portfolioStyleNO) {
		return dao.findByPrimaryKey(portfolioStyleNO);
	}
	
	public List<PortfolioStyleVO> getAll(){
		return dao.getAll();
	}
}

