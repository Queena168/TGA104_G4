package com.tibame.member.model;

public class MemberJDBCDAO {
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();

		// 新增
		MemberVO memberVO1 = new MemberVO();
		memberVO1.setMemberAccount("xxx@gmail.com");
		memberVO1.setMemberPassword("543");
		memberVO1.setMemberName("林佳龍");
		memberVO1.setNickName("阿龍");
		memberVO1.setGender("男");
		memberVO1.setBirthDate(java.sql.Date.valueOf("2005-01-01"));
		memberVO1.setActivaction(true);
		dao.insert(memberVO1);

		// 修改
//		MemberVO memberVO2 = new MemberVO();
//		memberVO2.setMemberNo(1);
//		memberVO2.setMemberAccount("xxx@gmail.com");
//		memberVO2.setMemberPassword("0123");
//		memberVO2.setMemberName("王小明");
//		memberVO2.setNickName("阿明");
//		memberVO2.setGender("男");
//		memberVO2.setBirthDate(java.sql.Date.valueOf("2002-01-09"));
//		memberVO2.setActivaction(true);
//		dao.update(memberVO2);
//
//		// 刪除
//		dao.delete(2);

		// 查詢
//		MemberVO memberVO3 = dao.findByPrimaryKey(1);
//		System.out.print(memberVO3.getMemberNo() + ",");
//		System.out.print(memberVO3.getMemberAccount() + ",");
//		System.out.print(memberVO3.getMemberPassword() + ",");
//		System.out.print(memberVO3.getMemberName() + ",");
//		System.out.print(memberVO3.getNickName() + ",");
//		System.out.print(memberVO3.getGender() + ",");
//		System.out.print(memberVO3.getBirthDate() + ",");
//		System.out.println(memberVO3.getActivaction());
//		System.out.println("---------------------");
//
//		// 查詢
//		List<MemberVO> list = dao.getAll();
//		for (MemberVO member : list) {
//			System.out.print(member.getMemberNo() + ",");
//			System.out.print(member.getMemberAccount() + ",");
//			System.out.print(member.getMemberPassword() + ",");
//			System.out.print(member.getMemberName() + ",");
//			System.out.print(member.getNickName() + ",");
//			System.out.print(member.getGender() + ",");
//			System.out.print(member.getBirthDate() + ",");
//			System.out.print(member.getActivaction());
//			System.out.println();
//		}
	}
}