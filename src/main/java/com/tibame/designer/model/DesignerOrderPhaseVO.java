package com.tibame.designer.model;

import java.sql.Date;
import java.util.Arrays;

import com.tibame.designer.service.DesignerOrderService;

public class DesignerOrderPhaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer phaseNo;// (期數流水編號): int, not null
	private Integer orderPhase;// (期數) int, not null
	private Integer amount;// (各期金額): int, not null
	private String constructionStatus;// (施工狀態): varchar(25)
	private String orderPhaseDetail;
	private Integer paymentPhase;// (收款期數) int
	private String paymentStatus;// (收款狀態): varchar(25)
	private byte[] paymentAtt;// (付款證明附檔): blob
	private Date modificationTime;// (修改時間): timestamp
	private Integer orderNo;// (報價單合約訂單表單流水號): int, not null
	


	

	@Override
	public String toString() {
		return "DesignerOrderPhaseVO [phaseNo=" + phaseNo + ", orderPhase=" + orderPhase + ", amount=" + amount
				+ ", constructionStatus=" + constructionStatus + ", orderPhaseDetail=" + orderPhaseDetail
				+ ", paymentPhase=" + paymentPhase + ", paymentStatus=" + paymentStatus + ", paymentAtt="
				+ Arrays.toString(paymentAtt) + ", modificationTime=" + modificationTime + ", orderNo=" + orderNo + "]";
	}

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



	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderPhaseDetail() {
		return orderPhaseDetail;
	}

	public void setOrderPhaseDetail(String orderPhaseDetail) {
		this.orderPhaseDetail = orderPhaseDetail;
	}

	public DesignerOrderVO getDesignerOrderVO() {
		DesignerOrderService designerOrderSvc = new DesignerOrderService();
		DesignerOrderVO designerOrderVO = designerOrderSvc.getDesignerOrder(orderNo);
		return designerOrderVO;
	}

}
