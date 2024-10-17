<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<%
	BoardVO bno = (BoardVO)request.getAttribute("boardvo");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	String msg = (String)request.getAttribute("msg");
%>

<h3>"<%=bno.getTitle() %>" 상세</h3>

<%if(msg != null){ %>
	<p><%=msg %></p>
<%} %>

<input type="hidden" name="bno" value="<%=bno.getBoardNo() %>">
<table class="table table-bordered">	
<colgroup><col width="20%"><col width="30%"><col width="20%"><col width="30%"></colgroup>

	<tbody>
		<tr>
			<th>글번호</th>
			<td><%=bno.getBoardNo() %></td>
			<th>조회수</th>
			<td><%=bno.getViewCnt() %></td>			
		</tr>
		<tr>
			<th>제목</th>
			<td colspan='3'><%=bno.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan='3'>
				<textarea readonly rows="4" cols="30" class="form-control"><%=bno.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan='3'><%=bno.getWriter() %></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan='3'><%=sdf.format(bno.getWriteDate()) %></td>
		</tr>
	
	</tbody>
</table>
<div align="center">
	<input type="button" value="수정" class="btn btn-primary">
	<input type="button" value="목록" onClick="location.href='boardList.do'" class="btn btn-outline-primary">
</div>


<div align="right">
	<input type="button" value="삭제" class="btn btn-outline-secondary">
</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e){
		location.href = 'boardEdit.do?bno=<%=bno.getBoardNo() %>';
	});
	
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e){
		location.href = 'boardDel.do?bno=<%=bno.getBoardNo() %>';
	});
</script>