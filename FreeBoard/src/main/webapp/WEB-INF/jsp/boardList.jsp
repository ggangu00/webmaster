<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td><c:out value="${board.boardNo}"/></td>
			<td class="subject"><a href="board.do?page=${page.page}&bno=${board.boardNo}&searchCondition=${searchCondition}&keyword=${keyword}">${board.title}</a></td>			
			<td><c:out value="${board.writer}"/></td>
			<td><c:out value="${board.viewCnt}"/></td>	
			<td><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>			
		</tr>
	</c:forEach>
	
	</tbody>
	
</table>

<%if(logId != null){ %>
<div align="right">
	<a href="boardAddForm.do" class="btn btn-primary">게시글 등록</a>
</div>
<%} %>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
<c:choose>
	<c:when test="${page.prev }">
		<li class="page-item">
		    <a class="page-link" href="?page=${page.startPage-1 }&searchCondition=${searchCondition }&keyword=${keyword }">Previous</a>
		</li>
	</c:when>
	<c:otherwise>
		<li class="page-item disabled">
		    <a class="page-link">Previous</a>
		</li>
	</c:otherwise>
</c:choose>

<c:forEach var="p" begin="${page.startPage }" end="${page.endPage }" step="1">
	<li ${p == page.page ? 'class="page-item active" aria-current="page" ':'class="page-item"' }>
        <a class="page-link" href="?page=${p}&searchCondition=${searchCondition }&keyword=${keyword }">${p}</a>
    </li>
</c:forEach>

<c:choose>
	<c:when test="${page.next }">
		<li class="page-item">
      <a class="page-link" href="?page=${page.endPage+1 }&searchCondition=${searchCondition }&keyword=${keyword }">Next</a>
    </li>
	</c:when>
	<c:otherwise>
		<li class="page-item disabled">
      <a class="page-link" href="#">Next</a>
    </li>
	</c:otherwise>
</c:choose>

  </ul>
</nav>
<jsp:include page="../includes/footer.jsp"></jsp:include>