<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
String msg = (String)request.getAttribute("msg");
%>
<%if(msg != null){ %>
	<p><%=msg %></p>
<%} %>
<h3>로그인 화면</h3>
<form action="loginForm.do" method="post">
	<table class="table table-bordered">
		<tr>
			<th class="col-sm-4">아이디</th>
			<td><input type="text" name="logId" class="form-control"></td>
		</tr>
		<tr>
			<th class="col-sm-4">비밀번호</th>
			<td><input type="password" name="logPw" class="form-control"></td>
		</tr>
	</table>
	<div align="center">
		<button type="submit" class="btn btn-primary">로그인</button>
	</div>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>