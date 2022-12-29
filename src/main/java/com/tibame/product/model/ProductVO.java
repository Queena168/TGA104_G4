package com.tibame.product.model;

import org.springframework.stereotype.Component;

//@Component(value = "ProductVO")
public class ProductVO implements java.io.Serializable {
	private Integer productNo;
	private Integer productTypeNo;
	private String  productName;
	private Integer stock;
	private Integer price;
	private String productDescription;
	private String productStatus;
	private Integer adminNo;

	
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	public Integer getProductTypeNo() {
		return productTypeNo;
	}
	public void setProductTypeNo(Integer productTypeNo) {
		this.productTypeNo = productTypeNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public Integer getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}

	
	
	
}
