package com.tibame.designer.model;

import java.util.Arrays;
import java.util.Date;

public class DesignerVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer designerNo;// (設計師編號): int, not null
	private String designerAccount;// (設計師帳號(信箱)): varchar(50), not null
	private String designerPassword;// (設計師密碼): varchar(50), not null
	private String designerName;// (設計師名稱): varchar(25), not null
	private String designerCompany;// (公司名稱): varchar(50)
	private byte[] designerPic;// (設計師照片): blob
	private String phone;
	private String designerDetail;
	private String approvalStatus;// (審核狀態): varchar(25)
	private Date approvalTime;// (審核時間): timestamp
	private Integer approver;// (審核管理員編號): int
	private Boolean designerStatus;// (設計師狀態)


	public Integer getDesignerNo() {
		return designerNo;
	}

	public void setDesignerNo(Integer designerNo) {
		this.designerNo = designerNo;
	}

	public String getDesignerAccount() {
		return designerAccount;
	}

	public void setDesignerAccount(String designerAccount) {
		this.designerAccount = designerAccount;
	}

	public String getDesignerPassword() {
		return designerPassword;
	}

	public void setDesignerPassword(String designerPassword) {
		this.designerPassword = designerPassword;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getDesignerCompany() {
		return designerCompany;
	}

	public void setDesignerCompany(String designerCompany) {
		this.designerCompany = designerCompany;
	}

	public byte[] getDesignerPic() {
		return designerPic;
	}

	public void setDesignerPic(byte[] designerPic) {
		this.designerPic = designerPic;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public Integer getApprover() {
		return approver;
	}

	public void setApprover(Integer approver) {
		this.approver = approver;
	}

	public Boolean getDesignerStatus() {
		return designerStatus;
	}

	public void setDesignerStatus(Boolean designerStatus) {
		this.designerStatus = designerStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDesignerDetail() {
		return designerDetail;
	}

	public void setDesignerDetail(String designerDetail) {
		this.designerDetail = designerDetail;
	}

	@Override
	public String toString() {
		return "DesignerVO [designerNo=" + designerNo + ", designerAccount=" + designerAccount + ", designerPassword="
				+ designerPassword + ", designerName=" + designerName + ", designerCompany=" + designerCompany
				+ ", designerPic=" + Arrays.toString(designerPic) + ", phone=" + phone + ", designerDetail="
				+ designerDetail + ", approvalStatus=" + approvalStatus + ", approvalTime=" + approvalTime
				+ ", approver=" + approver + ", designerStatus=" + designerStatus + "]";
	}
	
	
	





}