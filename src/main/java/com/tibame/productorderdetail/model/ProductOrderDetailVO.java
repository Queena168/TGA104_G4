package com.tibame.productorderdetail.model;

import com.tibame.cart.model.ShopProduct;

public class ProductOrderDetailVO implements java.io.Serializable{
	private Integer orderDetailNo; 
	private Integer orderNo;
	private Integer productNo;
	private String productName;
	private Integer qty;
	private Integer price;
	private ShopProduct shopProduct;
	
	public Integer getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(Integer orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public ShopProduct getShopProduct() {
		return shopProduct;
	}
	public void setShopProduct(ShopProduct shopProduct) {
		this.shopProduct = shopProduct;
	}
	
	
	
}
