package com.tibame.chat.model;

public class ChatVO implements java.io.Serializable{
	private Integer chatNo;
	private Integer memberNo;
	private Integer designerNo;
	
	/*
	chatNo      int auto_increment not null comment'聊天室編號',
    memberNo    int not null comment'會員編號',
    designerNo  int not null comment'設計師編號',
    */
	
	public Integer getChatNo() {
		return chatNo;
	}
	public void setChatNo(Integer chatNo) {
		this.chatNo = chatNo;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public Integer getDesignerNo() {
		return designerNo;
	}
	public void setDesignerNo(Integer designerNo) {
		this.designerNo = designerNo;
	}
	


}
