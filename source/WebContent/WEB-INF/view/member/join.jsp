<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form name="joinForm" method="post" action="">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"></td>
					<td><input type="button" name="check-id" value="중복확인"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="brithday"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><label>남자 <input type="radio" name="gender" value="1" checked="checked"></label>
					<label>여자 <input type="radio" name="gender" value="2"></label>
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="회원가입">
			</div>
		</form>
	</div>
</body>	
</html>