package com.tibame.member.model;

import java.util.List;

import com.tibame.designer.model.DesignerOrderJNDIDAO;
import com.tibame.designer.model.DesignerOrderVO;

public class MemberService {

	private Member_interface dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberVO addMember(String memberAccount, String memberPassword, String memberName, String nickName, String gender, java.sql.Date birthDate,
			Boolean activaction) {

		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberAccount(memberAccount);
		memberVO.setMemberPassword(memberPassword);
		memberVO.setMemberName(memberName);
		memberVO.setNickName(nickName);
		memberVO.setGender(gender);
		memberVO.setBirthDate(birthDate);
		memberVO.setActivaction(activaction);
		dao.insert(memberVO);
		
//		MailService mail = new MailService();
//		String subject = "【會員註冊通知信】";
//		String messageText = "<h2>Hello! " + memberName + "</h2>" +"<br> <p> 請點擊以下連結啟用帳號</p>" + 
//				 "<a href='http://localhost:8081/TGA104_G4/front-end/index.html'>MatDesign首頁</a><br>";
//		mail.sendMail(memberAccount, subject, messageText);
		
		return memberVO;
	}

	public MemberVO updateMember(Integer memberNo, String memberAccount, String memberPassword, String memberName,
			 String nickName, String gender, java.sql.Date birthDate, Boolean activaction) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMemberNo(memberNo);
		memberVO.setMemberAccount(memberAccount);
		memberVO.setMemberPassword(memberPassword);
		memberVO.setMemberName(memberName);
		memberVO.setNickName(nickName);
		memberVO.setGender(gender);
		memberVO.setBirthDate(birthDate);
		memberVO.setActivaction(activaction);
		dao.update(memberVO);

		return memberVO;
	}

	public void deleteMember(Integer memberNo) {
		dao.delete(memberNo);
	}

	public MemberVO getOneMember(Integer memberNo) {
		return dao.findByPrimaryKey(memberNo);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	public Boolean accountUsed (String memberAccount) {
		MemberDAO dao = new MemberDAO();
		return dao.accountUsed(memberAccount);
	}
	
	public void updateActivaction(Integer memberNo, Boolean activaction) {
		MemberDAO dao = new MemberDAO();
		dao.updateActivaction(memberNo, activaction);
	}
	
	public List<DesignerOrderVO> selectbyMemberNo(Integer memberNo){
		MemberDAO dao = new MemberDAO();
		return dao.findByMemberNo(memberNo);
	}
	
	public DesignerOrderVO findDesignerOrder(Integer orderNo) {
		DesignerOrderJNDIDAO dao = new DesignerOrderJNDIDAO();
		return dao.findDesignerOrder(orderNo);
	}
	
	public void confirmrdOrderVO(Integer orderNo,String quotationStatus) {
		MemberDAO dao = new MemberDAO();
		dao.confirmrdOrderVO(orderNo,quotationStatus);
	}
	
	public void confirmrdContract(Integer orderNo,String contractStatus) {
		MemberDAO dao = new MemberDAO();
		dao.confirmrdContract(orderNo,contractStatus);
	}
	
	public MemberVO findMemberNo(String memberAccount) {
		MemberDAO dao = new MemberDAO();
		return dao.findMemberNo(memberAccount);
	}
	
}
