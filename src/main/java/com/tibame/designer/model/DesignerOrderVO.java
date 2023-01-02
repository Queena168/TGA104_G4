package com.tibame.designer.model;

import java.sql.Date;
import java.util.Arrays;

import com.tibame.designer.service.DesignerService;
import com.tibame.member.model.MemberService;
import com.tibame.member.model.MemberVO;

public class DesignerOrderVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer orderNo;// (諮詢報價單合約訂單案件編號): int, not null
	private Integer designerNo;// (設計師編號): int, not null
	private Integer memberNo;// (會員編號): int, not null
	private Integer inquiryBudget;// (諮詢＿預算): int
	private Integer inquirySize;// (諮詢＿坪數):int
	private String inquiryDetail;// (諮詢＿構想描述): text
	private String quotationDetail;// (報價單＿內容): text
	private Integer quotationAmount;// (報價單＿總金額): int
	private Date quotationSendTime;// (報價單送出時間): timestamp
	private Date quotationApprovalTime;// (報價單成立時間): timestamp
	private byte[] quotationAtt;// (報QuotationAtt價單＿附檔): blob
	private String quotationStatus;// (報價單狀態): varchar(25)
	private String contractDetail;// (合約訂單內容): text
	private byte[] contractAtt;// (合約訂單＿附檔): blob
	private String contractStatus;// (合約狀態): varchar(25)
	private Date contractApprovalTime;// (合約訂單成立時間) timestamp
	private Date contractModificationTime;// (合約訂單最後修改時間) timestamp
	private String quotationNote;// (報價備註): text
	private String contractNote;// (合約訂單備註): text
	private Integer reviewStars;// (評價星數): int
	private String reviewDetail;// (評價內容): text
	private Date reviewTime;// (評價時間): timestamp
	private Boolean finishStatus; // (是否結案): BOOLEAN

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getDesignerNo() {
		return designerNo;
	}

	public void setDesignerNo(Integer designerNo) {
		this.designerNo = designerNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getInquiryBudget() {
		return inquiryBudget;
	}

	public void setInquiryBudget(Integer inquiryBudget) {
		this.inquiryBudget = inquiryBudget;
	}

	public Integer getInquirySize() {
		return inquirySize;
	}

	public void setInquirySize(Integer inquirySize) {
		this.inquirySize = inquirySize;
	}

	public String getInquiryDetail() {
		return inquiryDetail;
	}

	public void setInquiryDetail(String inquiryDetail) {
		this.inquiryDetail = inquiryDetail;
	}

	public String getQuotationDetail() {
		return quotationDetail;
	}

	public void setQuotationDetail(String quotationDetail) {
		this.quotationDetail = quotationDetail;
	}

	public Integer getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Integer quotationAmount) {
		this.quotationAmount = quotationAmount;
	}

	public Date getQuotationSendTime() {
		return quotationSendTime;
	}

	public void setQuotationSendTime(Date quotationSendTime) {
		this.quotationSendTime = quotationSendTime;
	}

	public Date getQuotationApprovalTime() {
		return quotationApprovalTime;
	}

	public void setQuotationApprovalTime(Date quotationApprovalTime) {
		this.quotationApprovalTime = quotationApprovalTime;
	}

	public byte[] getQuotationAtt() {
		return quotationAtt;
	}

	public void setQuotationAtt(byte[] quotationAtt) {
		this.quotationAtt = quotationAtt;
	}

	public String getQuotationStatus() {
		return quotationStatus;
	}

	public void setQuotationStatus(String quotationStatus) {
		this.quotationStatus = quotationStatus;
	}

	public String getContractDetail() {
		return contractDetail;
	}

	public void setContractDetail(String contractDetail) {
		this.contractDetail = contractDetail;
	}

	public byte[] getContractAtt() {
		return contractAtt;
	}

	public void setContractAtt(byte[] contractAtt) {
		this.contractAtt = contractAtt;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Date getContractApprovalTime() {
		return contractApprovalTime;
	}

	public void setContractApprovalTime(Date contractApprovalTime) {
		this.contractApprovalTime = contractApprovalTime;
	}

	public Date getContractModificationTime() {
		return contractModificationTime;
	}

	public void setContractModificationTime(Date contractModificationTime) {
		this.contractModificationTime = contractModificationTime;
	}

	public String getQuotationNote() {
		return quotationNote;
	}

	public void setQuotationNote(String quotationNote) {
		this.quotationNote = quotationNote;
	}

	public String getContractNote() {
		return contractNote;
	}

	public void setContractNote(String contractNote) {
		this.contractNote = contractNote;
	}

	public Integer getReviewStars() {
		return reviewStars;
	}

	public void setReviewStars(Integer reviewStars) {
		this.reviewStars = reviewStars;
	}

	public String getReviewDetail() {
		return reviewDetail;
	}

	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Boolean getFinishStatus() {
		return finishStatus;
	}

	public void setFinishStatus(Boolean finishStatus) {
		this.finishStatus = finishStatus;
	}
	
	
	
	// ============================================================
    //designer
	public DesignerVO getDesignerVO() {
		DesignerService designerSvc = new DesignerService();
		DesignerVO designerVO = designerSvc.getOneDesigner(designerNo);
		return designerVO;

	}

	// ================================================================
	// member
	public MemberVO getMemberVO() {
		MemberService memberSvc = new MemberService();
		MemberVO memberVO = memberSvc.getOneMember(memberNo);
		return memberVO;
	}
	
	
	public DesignerOrderPhaseVO getDesignerOrderPhaseVO() {
		MemberService designerOrderPhaseSvc = new MemberService	();
		DesignerOrderPhaseVO designerOrderPhaseVO = designerOrderPhaseSvc.designerOrderPhaseVO(orderNo);
		return designerOrderPhaseVO;
	}

	@Override
	public String toString() {
		return "DesignerOrderVO [orderNo=" + orderNo + ", designerNo=" + designerNo + ", memberNo=" + memberNo
				+ ", inquiryBudget=" + inquiryBudget + ", inquirySize=" + inquirySize + ", inquiryDetail="
				+ inquiryDetail + ", quotationDetail=" + quotationDetail + ", quotationAmount=" + quotationAmount
				+ ", quotationSendTime=" + quotationSendTime + ", quotationApprovalTime=" + quotationApprovalTime
				+ ", quotationAtt=" + Arrays.toString(quotationAtt) + ", quotationStatus=" + quotationStatus
				+ ", contractDetail=" + contractDetail + ", contractAtt=" + Arrays.toString(contractAtt)
				+ ", contractStatus=" + contractStatus + ", contractApprovalTime=" + contractApprovalTime
				+ ", contractModificationTime=" + contractModificationTime + ", quotationNote=" + quotationNote
				+ ", contractNote=" + contractNote + ", reviewStars=" + reviewStars + ", reviewDetail=" + reviewDetail
				+ ", reviewTime=" + reviewTime + ", finishStatus=" + finishStatus + "]";
	}
	
	
	
	

}
