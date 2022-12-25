package com.member.model;

import java.util.List;

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
}
