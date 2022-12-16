package com.member.model;

import java.sql.Date;
import java.time.LocalDate;

public class MemberVO  implements java.io.Serializable{
	private Integer memberNo;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private String nickName;
	private String gender;
	private Date birthDate;
	private Boolean activaction;
	
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getActivaction() {
		return activaction;
	}
	public void setActivaction(Boolean activaction) {
		this.activaction = activaction;
	}
	

}
