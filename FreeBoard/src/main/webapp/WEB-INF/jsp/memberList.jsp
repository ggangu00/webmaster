<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>회원 목록</h3>
<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("memberList");
	System.out.println(list);

%>
<table class="table table-bordered" style="text-align:center">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
		</tr>
	</thead>
	<tbody>
	
	<%
	for(MemberVO mvo : list){
	%>
		<tr>
			<td><%=mvo.getMemberId() %></td>
			<td><%=mvo.getMemberName() %></td>					
			<td><%=mvo.getPhone() %></td>					
		</tr>
	<%}%>
	
	</tbody>
</table>
<div align="right">
<a href="memberAdd.do" class="btn btn-primary">회원 등록</a>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>