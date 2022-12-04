package com.style.model;

public class StyleVO implements java.io.Serializable{
	private Integer styleNo;
	private String styleName;
	
	/*
	styleNo   int auto_increment not null comment'風格編號',
    styleName varchar(50) not null comment'風格名稱',
	*/	
	
	public Integer getStyleNo() {
		return styleNo;
	}
	public void setStyleNo(Integer styleNo) {
		this.styleNo = styleNo;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}


}
