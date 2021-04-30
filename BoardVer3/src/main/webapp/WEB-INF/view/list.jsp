<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	* { box-sizing: border-box; }
	body { width: 500px; margin: auto; border: 1px solid black; }
	h1 { width: 499px; height: 60px; padding-left: 15px; margin: 0; border-bottom: 1px solid black; line-height: 60px; }
	#content { width: 499px; min-height: 10px; border-bottom: 1px solid black; }
	#btnBox { width: 499px; height: 40px; }
	#btnBox button { float: right; position: relative; top: 8px; right: 10px; }
</style>
</head>
<body>
	<h1>List</h1>
	<div id="content">
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="btnBox"><a href="/write"><button>작성</button></a></div>
	
</body>
</html>