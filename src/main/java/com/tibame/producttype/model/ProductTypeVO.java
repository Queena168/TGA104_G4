package com.tibame.producttype.model;

import org.springframework.stereotype.Component;

@Component(value = "ProductTypeVO")
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
