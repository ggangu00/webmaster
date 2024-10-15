package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class AppTest {
	public static void main(String[] args) {
		//MemberDAO dao = new MemberDAO();
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		//등록
		/*
		Member mbr = new Member();
		mbr.setMemberId("test1009");
		mbr.setMemberName("홍기르디옹");
		mbr.setPhone("010-8888-8888");
		mbr.setPassword("1234");
		
		if(dao.insertMember(mbr) == 1) {
			sqlSession.commit();
		}		*/
		
		//수정				
		Member mbr = new Member();
		mbr.setMemberId("test99");
		mbr.setMemberName("홍기르디용");
		mbr.setPhone("010-8888-8888");
		mbr.setPassword("0000");
		
		if(dao.updateMember(mbr) == 1) {
			sqlSession.commit();
		}
		
		//삭제
		/*
		Member mbr = new Member();
		mbr.setMemberId("test1009");
		
		if(dao.deleteMember(mbr.getMemberId()) == 1) {
			sqlSession.commit();
		}
		
		List<Member> result = dao.members();
		for(Member member : result) {
			System.out.println(member.toString());
		}*/
		
	}
}
