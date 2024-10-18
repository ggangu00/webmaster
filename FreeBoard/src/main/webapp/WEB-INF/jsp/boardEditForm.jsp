<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
	String msg = (String)request.getAttribute("msg");
	String pg = (String) request.getAttribute("page");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	BoardVO bno = (BoardVO) request.getAttribute("boardvo");
	String sc = (String) request.getAttribute("sc");
	String kw = (String) request.getAttribute("kw");
	
	String logId = (String) session.getAttribute("logId");
%>

<%if(msg != null){ %>
	<p><%=msg %></p>
<%} %>

<h3>게시글 수정</h3>


<form action="boardEdit.do" method="post">
	<input type="hidden" name="bno" value="<%=bno.getBoardNo() %>">
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="searchCondition" value="<%=sc %>">
	<input type="hidden" name="keyword" value="<%=kw %>">
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
				<td colspan='3'><input type="text" name="title" class="form-control w100" value="<%=bno.getTitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan='3'>
					<textarea rows="4" cols="30" class="form-control" name="content"><%=bno.getContent() %></textarea>
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
		<input type="submit" value="저장" class="btn btn-primary" <%=(logId != null && logId.equals(bno.getWriter()) ? "" : "disabled" )%>>
		<input type="button" value="목록" onClick="location.href='boardList.do'" class="btn btn-outline-primary">
	</div>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>