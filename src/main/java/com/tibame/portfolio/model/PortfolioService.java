package com.tibame.portfolio.model;

import java.util.List;

public class PortfolioService {
	private PortfolioDAO_interface dao;

	public PortfolioService() {
		dao = new PortfolioDAO();
	}

	public PortfolioVO addPortfolio(String portfolioName, Integer designerNo, byte[] portfolioPic1,
			byte[] portfolioPic2, byte[] portfolioPic3, byte[] portfolioPic4, String description, String houseAge,
			String houseSize, String houseArea) {

		PortfolioVO portfolioVO = new PortfolioVO();

		portfolioVO.setPortfolioName(portfolioName);
		portfolioVO.setDesignerNo(designerNo);
		portfolioVO.setPortfolioPic1(portfolioPic1);
		portfolioVO.setPortfolioPic2(portfolioPic2);
		portfolioVO.setPortfolioPic3(portfolioPic3);
		portfolioVO.setPortfolioPic4(portfolioPic4);
		portfolioVO.setDescription(description);
		portfolioVO.setHouseAge(houseAge);
		portfolioVO.setHouseSize(houseSize);
		portfolioVO.setHouseArea(houseArea);
		dao.insert(portfolioVO);

		return portfolioVO;
	}

	public PortfolioVO updatePortfolio(Integer portfolioNo, String portfolioName, Integer designerNo,
			byte[] portfolioPic1, byte[] portfolioPic2, byte[] portfolioPic3, byte[] portfolioPic4, String description,
			String houseAge, String houseSize, String houseArea) {

		PortfolioVO portfolioVO = new PortfolioVO();

		portfolioVO.setPortfolioNo(portfolioNo);
		portfolioVO.setPortfolioName(portfolioName);
		portfolioVO.setDesignerNo(designerNo);
		portfolioVO.setPortfolioPic1(portfolioPic1);
		portfolioVO.setPortfolioPic2(portfolioPic2);
		portfolioVO.setPortfolioPic3(portfolioPic3);
		portfolioVO.setPortfolioPic4(portfolioPic4);
		portfolioVO.setDescription(description);
		portfolioVO.setHouseAge(houseAge);
		portfolioVO.setHouseSize(houseSize);
		portfolioVO.setHouseArea(houseArea);
		dao.update(portfolioVO);

		return portfolioVO;
	}

	public void deletePortfolio(Integer portfolioNo) {
		dao.delete(portfolioNo);
	}

	public PortfolioVO getOnePortfolio(Integer portfolioNo) {
		return dao.findByPrimaryKey(portfolioNo);
	}

	public List<PortfolioVO> getAll() {
		return dao.getAll();
	}

	public List<PortfolioVO> getAllbyDesign(Integer designerNo) {
		PortfolioDAO getAll = new PortfolioDAO();
		return getAll.getAllbyDesign(designerNo);
	}

	public List<PortfolioVO> selectportfolio(String select) {
		PortfolioDAO selectdao = new PortfolioDAO();
		List<PortfolioVO> selectList = selectdao.selectMatch(select);
		return selectList;
	}


}
