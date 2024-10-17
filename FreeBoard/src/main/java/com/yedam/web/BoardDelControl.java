package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardDelControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		
		//GET: 수정화면, POST: 수정처리
		if(req.getMethod().equals("GET")) {		
			
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/boardDelForm.jsp").forward(req, resp);
			
		}else if(req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			
			if(svc.removeBoard(Integer.parseInt(bno))) {
				//정상처리 - 목록으로
				resp.sendRedirect("boardList.do");
			}else {
				board = svc.searchBoard(Integer.parseInt(bno));
				
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "삭제할 게시글이 없습니다.");
				req.getRequestDispatcher("WEB-ING/jsp/boardDelForm.jsp").forward(req, resp);
			}
						
		}
	}
}
