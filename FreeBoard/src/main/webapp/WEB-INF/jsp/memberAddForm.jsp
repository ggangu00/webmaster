<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberAdd.do">
		<table border='1'>
			<tr>
				<th>회원ID</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>회원이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="passwd"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
</body>
</html>