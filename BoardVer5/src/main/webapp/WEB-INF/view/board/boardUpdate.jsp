<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Update</title>
</head>
<body>
	<h1>Board Update</h1>
	<form action="boardUpdate" method="post">
		<div>title : <input type="text" name="title" value="${vo.title}"></div>
		<div>content : <textarea name="ctnt">${vo.ctnt}</textarea></div>
		<input type="hidden" name="iboard" value="${param.iboard}">
		<input type="submit" value="작성">
	</form>
</body>
</html>