package com.portfolio.model;

import java.sql.Timestamp;

public class PortfolioVO implements java.io.Serializable{
	private Integer portfolioNo;
	private String portfolioName;
	private Integer designerNo;
	private byte[] portfolioPic1;
	private byte[] portfolioPic2;
	private byte[] portfolioPic3;
	private byte[] portfolioPic4;
	private String description;
	private Timestamp createTime;
	private Timestamp modificationTime;
	private String houseAge;
	private String houseSize;
	private String houseArea;
	
	/*
	portfolioNo      int auto_increment not null comment'作品編號',
    portfolioName    varchar(100) not null comment'作品名稱',
    designerNo       int not null comment'設計師編號',
    portfolioPic1     blob comment'照片編號1',
    portfolioPic2    blob comment'照片編號2',
    portfolioPic3    blob comment'照片編號3',
    portfolioPic4    blob comment'照片編號4',
    description      longtext not null comment'作品描述',
    createTime       timestamp comment'上傳時間',
    modificationTime timestamp comment'修改時間',
    houseAge         varchar(25) comment'屋齡',
    houseSize        varchar(25) comment'坪數',
    houseArea        varchar(25) comment'區域',
	*/
	
	public Integer getPortfolioNo() {
		return portfolioNo;
	}
	public void setPortfolioNo(Integer portfolioNo) {
		this.portfolioNo = portfolioNo;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public Integer getDesignerNo() {
		return designerNo;
	}
	public void setDesignerNo(Integer designerNo) {
		this.designerNo = designerNo;
	}
	public byte[] getPortfolioPic1() {
		return portfolioPic1;
	}
	public void setPortfolioPic1(byte[] portfolioPic1) {
		this.portfolioPic1 = portfolioPic1;
	}
	public byte[] getPortfolioPic2() {
		return portfolioPic2;
	}
	public void setPortfolioPic2(byte[] portfolioPic2) {
		this.portfolioPic2 = portfolioPic2;
	}
	public byte[] getPortfolioPic3() {
		return portfolioPic3;
	}
	public void setPortfolioPic3(byte[] portfolioPic3) {
		this.portfolioPic3 = portfolioPic3;
	}
	public byte[] getPortfolioPic4() {
		return portfolioPic4;
	}
	public void setPortfolioPic4(byte[] portfolioPic4) {
		this.portfolioPic4 = portfolioPic4;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}
	public String getHouseAge() {
		return houseAge;
	}
	public void setHouseAge(String houseAge) {
		this.houseAge = houseAge;
	}
	public String getHouseSize() {
		return houseSize;
	}
	public void setHouseSize(String houseSize) {
		this.houseSize = houseSize;
	}
	public String getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}
	
	// for join designerName from designerNo
	public com.designer.model.DesignerVO getDesignerVO(){
		com.designer.service.DesignerService designerSvc = new com.designer.service.DesignerService();
		com.designer.model.DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);
		return designerVO;
	}

}
