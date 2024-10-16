package com.yedam.mapper;

import java.util.List;
import com.yedam.vo.MemberVO;

//interface 기능정의
//구현클래스 기능실행
public interface MemberMapper {
	
	public List<MemberVO> members();
	public int insertMember(MemberVO member); //무조건 int
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	public MemberVO selectMember(String memberId); //단건조회
	
}
