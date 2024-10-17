package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardAddControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("MemberEditControl");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String boardNo = req.getParameter("boardNo");
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(boardNo);
		
		BoardService svc = new BoardServiceImpl();
		
		try {
			svc.registerBoard(bvo);
			resp.sendRedirect("boardList.do");
		}catch(Exception e) {
			req.setAttribute("msg", "등록하는 중 오류가 발생하였습니다.");
			req.getRequestDispatcher("WEB-ING/jsp/boardForm.jsp").forward(req, resp);
		}
	}
	
}
