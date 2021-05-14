<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
	<h1>Board List</h1>
	<div><a href="boardWrite">write</a></div>
	<div><a href="/user/userLogout">logout</a></div>
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
</body>
<script>
	function moveToDetail(iboard) {
		location.href = "boardDetail?iboard=" + iboard;
	}
</script>
</html>