package com.designerOrderPhase.model;

import java.time.LocalDateTime;

public class DesignerOrderPhaseVO implements java.io.Serializable {
	private Integer phaseNo;// (期數流水編號): int, not null
	private Integer orderPhase;// (期數) int, not null
	private Integer amount;// (各期金額): int, not null
	private String constructionStatus;// (施工狀態): varchar(25)
	private Integer paymentPhase;// (收款期數) int
	private String paymentStatus;// (收款狀態): varchar(25)
	private byte[] paymentAtt;// (付款證明附檔): blob
	private LocalDateTime modificationTime;// (修改時間): timestamp
	private Integer orderNo;// (報價單合約訂單表單流水號): int, not null

	public Integer getPhaseNo() {
		return phaseNo;
	}

	public void setPhaseNo(Integer phaseNo) {
		this.phaseNo = phaseNo;
	}

	public Integer getOrderPhase() {
		return orderPhase;
	}

	public void setOrderPhase(Integer orderPhase) {
		this.orderPhase = orderPhase;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getConstructionStatus() {
		return constructionStatus;
	}

	public void setConstructionStatus(String constructionStatus) {
		this.constructionStatus = constructionStatus;
	}

	public Integer getPaymentPhase() {
		return paymentPhase;
	}

	public void setPaymentPhase(Integer paymentPhase) {
		this.paymentPhase = paymentPhase;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public byte[] getPaymentAtt() {
		return paymentAtt;
	}

	public void setPaymentAtt(byte[] paymentAtt) {
		this.paymentAtt = paymentAtt;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}
