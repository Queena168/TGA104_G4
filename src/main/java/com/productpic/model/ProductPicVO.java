package com.productpic.model;

public class ProductPicVO implements java.io.Serializable{
	private Integer productPicNo;
	private Integer productNo;
	private byte[] pic;
	
	public Integer getProductPicNo() {
		return productPicNo;
	}
	public void setProductPicNo(Integer productPicNo) {
		this.productPicNo = productPicNo;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
