package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		List<BoardVO> list = mapper.listWithPage(3);
		for(BoardVO bvo:list) {
			System.out.println(bvo.toString());
		}
		
		/*
		BoardVO bvo = new BoardVO();
		bvo.setTitle("mapper테스트");
		bvo.setContent("정상 작동합니다.[수정]");
		bvo.setWriter("ggangu00");
		bvo.setBoardNo(4);
		
		if(mapper.insertBoard(bvo) == 1) {
			sqlSession.commit();
		}
		
		if(mapper.updateBoard(bvo) == 1) {
			sqlSession.commit();
		}
		
		if(mapper.deleteBoard(bvo.getBoardNo()) == 1) {
			sqlSession.commit();
		}
		
		if(mapper.selectBoard(bvo.getBoardNo()) == null) {
			System.out.println("조회된 내용이 없습니다.");
		}
		
		List<BoardVO> list = mapper.boardList();
		for(BoardVO bvo2 : list) {
			System.out.println(bvo2.toString());
		}
		*/
	}
}
