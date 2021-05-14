<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
</head>
<body>
	<h1>Board Write</h1>
	<form action="boardWrite" method="post">
		<div>title : <input type="text" name="title"></div>
		<div>content : <textarea name="ctnt"></textarea></div>
		<input type="submit" value="작성">
	</form>
</body>
</html>