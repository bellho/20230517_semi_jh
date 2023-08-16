<link rel="stylesheet" href="">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 검색 리스트</title>
</head>
<body>
	<h2>식품 리스트</h2>
	<div>
		<form action="${pageContext.request.contextPath }/food/list" method="get">
			식품 검색 : <input type="text" name="searchWord"> <input
				type="submit" value="검색">
		</form>
	</div>
<c:choose>
	<c:when test = "${not empty foodList }">
		<h3>${serachWord } 검색결과</h3>
		<table border="1">
		
			<tr>
				<th>No.</th>
				<th>식품명</th>
				<th>제조사</th>
				<th>조사년도</th>
				<th>식품분류</th>
				<th>식품상세분류</th>
				<th>자료원</th>
				<th>에너지</th>
			</tr>
			<c:set var="num" value="${(totalCnt) - ((currentPage - 1) * 10) }"/>
			<c:forEach items="${foodList }" var="vo">
				<tr>
					<th>${num }</th>
					<th><a href="${pageContext.request.contextPath }/food/get?fno=${vo.foodCode }">${vo.foodName }</a></th>
					<th>${vo.manufacturer }</th>
					<th>${vo.foodDate }</th>
					<th>${vo.foodDbCategory }</th>
					<th>${vo.foodCategory }</th>
					<th>${vo.issuer }</th>
					<th>${vo.calories }</th>
				</tr>
				<c:set var="num" value="${num-1 }"></c:set>
			</c:forEach>
		</table>
		<c:if test="${startPageNum > 1 }">
			<a href="${pageContext.request.contextPath }/food/list?pageNo=${startPageNum-1}&searchWord="><span>이전</span></a>
		</c:if>
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="i">
			<a href="${pageContext.request.contextPath }/food/list?pageNo=${i}&searchWord=${searchWord }"><span>${i }</span></a>
		</c:forEach>
		<c:if test="${endPageNum < totalPageNum}">
			<a href="${pageContext.request.contextPath }/food/list?pageNo=${endPageNum+1}&searchWord=${searchWord }"><span>다음</span></a>
		</c:if>
	</c:when>
	<c:otherwise>
			<h2>${serachWord } 조회된 정보가 없습니다.</h2>
			<h5><a href="${pageContext.request.contextPath }/food/list">전체보기</a></h5>
	</c:otherwise>
</c:choose>
</body>
</html>