package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//IOC (제어의 역전)
//객체생성 -> init() -> service() -> destroy() : 서블릿의 생명주기
//@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true); //true일 시 자동 커밋됨
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		try {
			dao.members();
			List<Member> result = dao.members();
			int i=0;
			PrintWriter out = response.getWriter();
			String str = "";
			str += "<table style='bolder:1px'>";
				str += "<thead>";
					str += "<tr>";
						str += "<th>번호</th>";
						str += "<th>아이디</th>";
						str += "<th>비밀번호</th>";
						str += "<th>이름</th>";
						str += "<th>전화번호</th>";
					str += "</tr>";
				str += "</thead>";
				str += "<tbody>";
				for(Member val : result) {
					i++;
					str += "<tr>";
						str += "<td>"+i+"</td>";
						str += "<td><a href='member.action?mid="+val.getMemberId()+"'>"+val.getMemberId()+"</a></td>";
						str += "<td>"+val.getPassword()+"</td>";
						str += "<td>"+val.getMemberName()+"</td>";
						str += "<td>"+val.getPhone()+"</td>";
					str += "</tr>";
				}
				str += "</tbody>";
			str += "</table>";
			str += "<a href='index.html'>첫페이지</a>";
			out.print(str);
		}catch(Exception e){
			response.getWriter().print("NG");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
