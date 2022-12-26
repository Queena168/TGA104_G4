package com.tibame.producttype.model;

public class ProductTypeVO implements java.io.Serializable{
	private Integer productTypeNo;
	private String productTypeName;
	
	public Integer getProductTypeNo() {
		return productTypeNo;
	}
	public void setProductTypeNo(Integer productTypeNo) {
		this.productTypeNo = productTypeNo;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
}
