package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogOutControl implements Control {
	//loginForm.jsp
	//id, pw를 파라미터 ...

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session삭제
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);	
		
	}

}
