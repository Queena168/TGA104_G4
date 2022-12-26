package com.tibame.chat.model;

import java.util.List;

public class ChatService {
	private ChatDAO_interface dao;
	
	public ChatService() {
		dao = new ChatDAO();
	}
	
	public ChatVO addChat (Integer memberNo, Integer designerNo) {
		
		ChatVO chatVO = new ChatVO();
		
		chatVO.setMemberNo(memberNo);
		chatVO.setDesignerNo(designerNo);
		dao.insert(chatVO);
		
		return chatVO;
	}
	
	public ChatVO updateChat(Integer chatNo,Integer memberNo, Integer designerNo) {
		
		ChatVO chatVO = new ChatVO();
		
		chatVO.setChatNo(chatNo);
		chatVO.setMemberNo(memberNo);
		chatVO.setDesignerNo(designerNo);
		dao.update(chatVO);
		
		return chatVO;
	}
	
	public void deleteChat(Integer chatNO) {
		dao.delete(chatNO);
	}
	
	public ChatVO findByPrimaryKey(Integer ChatNo) {
		return dao.findByPrimaryKey(ChatNo);
	}
	
	public List<ChatVO> getAll(){
		return dao.getAll();
	}
	
	
	
	
	
	
}
