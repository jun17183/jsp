<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	table, th, td { border: 1px solid black; border-collapse: collapse; }
</style>
</head>
<body>
	<div>로그인 성공</div>
	<div>${loginUser.unm }님 (${loginUser.uid}) 환영합니다.</div>
	<div><a href="/user/logout">로그아웃</a></div>
	<div><a href="write">글쓰기</a></div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	function moveToDetail(iboard) {
		location.href = '/detail?iboard=' + iboard;
	}
</script>
</html>

