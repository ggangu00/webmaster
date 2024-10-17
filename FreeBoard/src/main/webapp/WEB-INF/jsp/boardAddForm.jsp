<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
	String msg = (String)request.getAttribute("msg");
%>

<h3>게시글 등록</h3>

<%if(msg != null){ %>
	<p><%=msg %></p>
<%} %>

<form action="boardAdd.do" method="post">
	<table class="table table-bordered">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="form-control w100"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="4" cols="30" class="form-control" name="content"></textarea>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" class="form-control"></td>
		</tr>
	</table>
	<div align="center">
		<input type="submit" value="등록" class="btn btn-primary">
		<input type="button" value="목록" onClick="location.href='boardList.do'" class="btn btn-outline-primary">
	</div>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>