package com.cart.model;

import com.product.model.ProductVO;

public class Cart implements java.io.Serializable {
	private Integer productNo;
	private String  productName;
	private Integer price;
	private int quantity;
	
	public Cart() {
		
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [productNo=" + productNo + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
}
