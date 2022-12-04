package com.chatmessage.model;

import java.util.List;


public interface ChatMessageDAO_interface {
	public void insert(ChatMessageVO chatMessageVO);
	public void update(ChatMessageVO chatMessageVO);
	public void delete(Integer messageNo);
	public ChatMessageVO findByPrimaryKey(Integer messageNo);
	public List<ChatMessageVO> getAll();
}
