package com.tibame.productorder.model;

import java.beans.JavaBean;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tibame.cart.model.ShopProduct;
import com.tibame.productorderdetail.model.ProductOrderDetailVO;

@Component(value = "ProductOrderVO")
public class ProductOrderVO extends ShopProduct implements java.io.Serializable{
	private Integer ooNo;
	private Integer orderNo;
	private Integer productNo;
	private Integer memberNo; 
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private Integer totalQTY;
	private Integer totalAmount;
	private String invoiceNo;
	private String businessNumber;
	private Timestamp paidDate;
	private Date shipDate;
	private String orderStatus;
	private List<ProductOrderDetailVO> items = new ArrayList<ProductOrderDetailVO>();//订单中的订单项 //id
	
	
	public Integer getOoNo() {
		return ooNo;
	}
	public void setOoNo(Integer ooNo) {
		this.ooNo = ooNo;
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
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public Integer getTotalQTY() {
		return totalQTY;
	}
	public void setTotalQTY(Integer totalQTY) {
		this.totalQTY = totalQTY;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public Timestamp getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Timestamp paidDate) {
		this.paidDate = paidDate;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<ProductOrderDetailVO> getItems() {
		return items;
	}
	public void setItems(List<ProductOrderDetailVO> items) {
		this.items = items;
	}
	
	
	
	
	
}
