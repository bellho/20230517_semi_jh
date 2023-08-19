<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="$${pageContext.request.contextPath }/loginck" name="login" method="post">
		<h1>SEKI</h1>
		<table>
			<tr>
				<th><input type="text" placeholder="아이디"></th>
			</tr>
			<tr>
				<th><input type="password" placeholder="비밀번호"></th>
			</tr>
		</table>
		<input type="submit" value="로그인">
	</form>
</body>
</html>