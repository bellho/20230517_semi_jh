<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 상세 정보</title>
</head>
<body>
	<h1>식품 이름 : ${fvo.foodName }</h1>
	<div>
		<table border = "1">
				<tr>
					<td>영양성분</td>
					<td>${fvo.servingSize }${fvo.unit }당 함량</td>
					<td>단위</td>
				</tr>
				<tr>
					<td>에너지</td>
					<td>${fvo.calories }</td>
					<td>kcal</td>
				</tr>
				<tr>
					<td>단백질</td>
					<td>${fvo.protein }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>지방</td>
					<td>${fvo.totalFat }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>탄수화물</td>
					<td>${fvo.totalCarbohydrate }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>총당류</td>
					<td>${fvo.sugars }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>나트륨</td>
					<td>${fvo.soduim }</td>
					<td>mg</td>
				</tr>
				<tr>
					<td>콜레스테롤</td>
					<td>${fvo.cholesterol }</td>
					<td>mg</td>
				</tr>
				<tr>
					<td>총 포화 지방산</td>
					<td>${fvo.saturatedFat }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>트랜스 지방산</td>
					<td>${fvo.transFat }</td>
					<td>g</td>
				</tr>
				<tr>
					<td>총 내용량</td>
					<td>
						<c:choose>
							<c:when test="${fvo.gram  eq 0}">${fvo.servingSize }</c:when>
							<c:otherwise>${fvo.gram }</c:otherwise>
						</c:choose>
					</td>
					<td>${fvo.unit }</td>
				</tr>
		</table>
	</div>
</body>
</html>