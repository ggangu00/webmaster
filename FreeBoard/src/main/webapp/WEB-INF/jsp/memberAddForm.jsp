<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>회원 등록</h3>
<form action="memberAdd.do">
	<table class="table table-bordered">
		<tr>
			<th>회원ID</th>
			<td><input type="text" name="mid" class="form-control"></td>
		</tr>
		<tr>
			<th>회원이름</th>
			<td><input type="text" name="mname" class="form-control"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="passwd" class="form-control"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone" class="form-control"></td>
		</tr>
	</table>
	<div align="center">
		<input type="submit" value="저장" class="btn btn-primary">
		<input type="button" value="목록" onClick="location.href='memberList.do'" class="btn btn-outline-primary">
	</div>
</form>


<div align="right">
<a href="boardDel.do" class="btn btn-danger"><i class="bi bi-trash"></i></a>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>