package com.chatmessage.model;

import java.sql.Timestamp;

public class ChatMessageVO implements java.io.Serializable{
	private Integer messageNo;
	private Integer chatNo;
	private String message;
	private Timestamp sendTime;
	private Boolean sender;
	
	/*
	messageNo  int auto_increment not null comment'訊息編號',
    chatNo     int not null comment'聊天室編號',
    message    text comment'聊天內容',
    sendTime   timestamp comment'發送時間',
    sender     boolean comment'0為設計師發送 1為會員發送',
    */
	
	public Integer getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(Integer messageNo) {
		this.messageNo = messageNo;
	}
	public Integer getChatNo() {
		return chatNo;
	}
	public void setChatNo(Integer chatNo) {
		this.chatNo = chatNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Boolean getSender() {
		return sender;
	}
	public void setSender(Boolean sender) {
		this.sender = sender;
	}
	
}
