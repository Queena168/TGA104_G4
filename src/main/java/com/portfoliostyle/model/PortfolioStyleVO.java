package com.portfoliostyle.model;

public class PortfolioStyleVO implements java.io.Serializable{
	private Integer portfolioStyleNO;
	private Integer portfolioNo;
	private Integer styleNo;
	
	/*
	portfolioStyleNO  int auto_increment not null comment'作品風格編號',
    portfolioNo       int not null comment'作品編號',
    styleNo           int not null comment'風格編號',
	*/
	
	public Integer getPortfolioStyleNO() {
		return portfolioStyleNO;
	}
	public void setPortfolioStyleNO(Integer portfolioStyleNO) {
		this.portfolioStyleNO = portfolioStyleNO;
	}
	public Integer getPortfolioNo() {
		return portfolioNo;
	}
	public void setPortfolioNo(Integer portfolioNo) {
		this.portfolioNo = portfolioNo;
	}
	public Integer getStyleNo() {
		return styleNo;
	}
	public void setStyleNo(Integer styleNo) {
		this.styleNo = styleNo;
	}
	

}
