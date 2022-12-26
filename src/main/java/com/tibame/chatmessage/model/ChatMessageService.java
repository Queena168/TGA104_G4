package com.tibame.chatmessage.model;

import java.util.List;

public class ChatMessageService {
	private ChatMessageDAO_interface dao;
	
	private ChatMessageService() {
		dao = new ChatMessageDAO();
	}
	
	public ChatMessageVO addChatMessage(Integer chatNo, String message,Boolean sender) {
		ChatMessageVO chatMessageVO = new ChatMessageVO();
		
		chatMessageVO.setChatNo(chatNo);
		chatMessageVO.setMessage(message);
		chatMessageVO.setSender(sender);
		dao.insert(chatMessageVO);
		
		return chatMessageVO;
	}
	
	public ChatMessageVO updateChatMessage(Integer messageNo, Integer chatNo, String message,Boolean sender) {
		
		ChatMessageVO chatMessageVO = new ChatMessageVO();
		
		chatMessageVO.setMessageNo(messageNo);
		chatMessageVO.setChatNo(chatNo);
		chatMessageVO.setMessage(message);
		chatMessageVO.setSender(sender);
		
		return chatMessageVO;
	}
	
	public void deleteChatMessage(Integer messageNo) {
		dao.delete(messageNo);
	}
	
	public ChatMessageVO getOneChatMessage(Integer messageNo) {
		return dao.findByPrimaryKey(messageNo);
	}
	
	public List<ChatMessageVO> getAll(){
		return dao.getAll();
	}
}
