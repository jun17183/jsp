<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	* { box-sizing: border-box; border-collapse: collapse; }
	body { width: 500px; margin: auto; border: 1px solid black; }
	h1 { width: 499px; height: 60px; padding-left: 15px; margin: 0; line-height: 60px; text-align: center; }
	#content { position: relative; top: -1px; width: 499px; min-height: 10px; border-top: 0px; border-bottom: 1px solid black; }
	#btnBox { width: 500px; height: 42px; }
	#btnBox button { float: right; position: relative; top: 8px; right: 10px; cursor: pointer; }
	table, td, th { border: 1px solid black; border-collapse: collapse; }
	table { position: relative; left: -1px; top: 1px; width: 500px; height: calc(100% + 1px); border-top: 0px; border-bottom: 0px; }
	tr { height: 30px; }
	th:nth-child(2) { width: 285px; }
	th:last-child { width: 180px; }
	td { text-align: center; }
	.record { cursor: pointer; }
	.record:hover { background: #99CCFF; }
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
				<tr class="record" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="btnBox"><a href="/write"><button>작성</button></a></div>
	
	<script>
		function moveToDetail(iboard) {
			location.href = '/detail?iboard=' + iboard;
		}
	</script>
</body>
</html>