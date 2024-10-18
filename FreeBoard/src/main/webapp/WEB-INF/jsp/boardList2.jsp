<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>게시글 목록</h3>
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	PageDTO paging = (PageDTO) request.getAttribute("page");
	String pageNum = (String) request.getAttribute("pageNum");
	String sc = (String) request.getAttribute("sc");
	String kw = (String) request.getAttribute("kw");
	kw = kw == null ? "" : kw;
	
	String logId = (String) session.getAttribute("logId");

%>

<!--검색조건 -->
<form action="boardList.do" class="row g-3">
  <div class="col-md-2">
    <select name="searchCondition" class="form-select">
      <option value="" <%=(sc != null && sc.equals("") ? "selected" : "") %>>선택하세요</option>
      <option value="T" <%=(sc != null && sc.equals("T") ? "selected" : "") %>>제목</option>
      <option value="W" <%=(sc != null && sc.equals("W") ? "selected" : "") %>>작성자</option>
      <option value="TW" <%=(sc != null && sc.equals("TW") ? "selected" : "") %>>제목 & 작성자</option>
    </select>
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" name="keyword" value="<%=kw%>" placeholder="검색어를 입력해주세요">
  </div>
  <div class="col-md-5">
    <button type="submit" class="btn btn-primary">검색</button>
  </div>
</form>


<table class="table table-bordered" style="text-align:center; margin-top:30px">
	<thead class="table-secondary">
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>관리</th>
		</tr>
	</thead>
	
	<tbody class="table-group-divider">
	<%
	int boardNum = paging.getTotalCnt() - ((paging.getPage()-1)*10);
	int i = boardNum;
	
	for(BoardVO bvo : list){
		
		String wdate = sdf.format(bvo.getWriteDate());
	%>
		<tr>
			<td><%=i %></td>
			<td class="subject"><a href="board.do?page=<%=paging.getPage() %>&bno=<%=bvo.getBoardNo() %>&searchCondition=<%=sc%>&keyword=<%=kw%>"><%=bvo.getTitle() %></a></td>			
			<td><%=bvo.getWriter() %></td>
			<td><%=bvo.getViewCnt() %></td>						
			<td><%=wdate %></td>	
			<td>
				<a href="boardEdit.do?page=<%=paging.getPage() %>&bno=<%=bvo.getBoardNo() %>&searchCondition=<%=sc%>&keyword=<%=kw%>" class="btn btn-outline-secondary btn-sm"><i class="bi bi-pencil-square"></i></a>
				<a href="boardDel.do?bno=<%=bvo.getBoardNo() %>" class="btn btn-outline-secondary btn-sm"><i class="bi bi-trash"></i></a>
			</td>				
		</tr>
	<%i--;}%>
	
	</tbody>
	
</table>

<%if(logId != null){ %>
<div align="right">
	<a href="boardAddForm.do" class="btn btn-primary">게시글 등록</a>
</div>
<%} %>

<nav aria-label="Page navigation example">
  <ul class="pagination">
  	<!-- 이전페이지 여부 -->
  	<%if(paging.isPrev()){ %>
	    <li class="page-item">
	      <a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1%>" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
    <%}else{ %>
	    <li class="page-item disabled">
	      <a class="page-link">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	<% }%>
	
	<!-- 페이지 출력 -->
    <%for(int p = paging.getStartPage(); p<=paging.getEndPage(); p++){ %>
    	<li class="page-item <%if(p == paging.getPage()){ %>active<%} %>" <%if(p == paging.getPage()){ %>aria-current="page"<%} %>>
    		<a class="page-link" href="boardList.do?page=<%=p%>&searchCondition=<%=sc%>&keyword=<%=kw%>"><%=p%></a>
    	</li>   
    <% }%>
     
     <!-- 다음페이지 여부 -->
    <%if(paging.isNext()){ %>
	    <li class="page-item">
	      <a class="page-link" href="boardList.do?page=<%=paging.getEndPage()+1%>" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
    <%}else{ %>
	    <li class="page-item disabled">
	      <a class="page-link">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
    <% }%>
  </ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>