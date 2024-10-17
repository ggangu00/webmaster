<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>게시글 목록</h3>
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	PageDTO paging = (PageDTO) request.getAttribute("page");
	String pageNum = (String) request.getAttribute("pageNum");

%>

<table class="table table-bordered" style="text-align:center">
	<thead>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>관리</th>
		</tr>
	</thead>
	
	<tbody>
	<%
	int i=paging.getStartPage()*5;
	for(BoardVO bvo : list){
		
		String wdate = sdf.format(bvo.getWriteDate());
	%>
		<tr>
			<th><%=i%></th>
			<td class="subject"><a href="board.do?bno=<%=bvo.getBoardNo() %>"><%=bvo.getTitle() %></a></td>			
			<td><%=bvo.getWriter() %></td>
			<td><%=bvo.getViewCnt() %></td>						
			<td><%=wdate %></td>	
			<td>
				<a href="boardEdit.do?bno=<%=bvo.getBoardNo() %>" class="btn btn-outline-secondary btn-sm"><i class="bi bi-pencil-square"></i></a>
				<a href="boardDel.do?bno=<%=bvo.getBoardNo() %>" class="btn btn-outline-secondary btn-sm"><i class="bi bi-trash"></i></a>
			</td>				
		</tr>
	<%i++;}%>
	
	</tbody>
	
</table>

<div align="right">
	<a href="boardAddForm.do" class="btn btn-primary">게시글 등록</a>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <%for(int p = paging.getStartPage(); p<=paging.getEndPage(); p++){ %>
    	<li class="page-item"><a class="page-link" href="boardList.do?page=<%=p%>"><%=p%></a></li>   
     <% }%>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>