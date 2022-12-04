package com.admin.model;

import java.sql.Timestamp;

public class AdminVO implements java.io.Serializable{
	private Integer adminNo;
	private String adminEmail;
	private String adminPassword;
	private String adminName;
	private byte[] adminPic;
	private String adminPrivilege;
	private Timestamp createTime;
	private Integer uploader;
	
	/*
	adminNo        int auto_increment not null comment'管理員編號',
    adminEmail     varchar(50) not null comment'信箱',
    adminPassword  varchar(50) not null comment'密碼',
    adminName      varchar(50) comment'名稱',
    adminPic       longblob comment'大頭貼',
    adminPrivilege varchar(50) comment'權限',
    createTime     timestamp comment'創立時間',
    uploader       int comment'上傳管理員',
    */
	
	public Integer getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public byte[] getAdminPic() {
		return adminPic;
	}
	public void setAdminPic(byte[] adminPic) {
		this.adminPic = adminPic;
	}
	public String getAdminPrivilege() {
		return adminPrivilege;
	}
	public void setAdminPrivilege(String adminPrivilege) {
		this.adminPrivilege = adminPrivilege;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getUploader() {
		return uploader;
	}
	public void setUploader(Integer uploader) {
		this.uploader = uploader;
	}
	

		
	
}
