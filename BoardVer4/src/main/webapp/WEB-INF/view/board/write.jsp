<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>write</h1>
	<form action="write" method="post">
		<div>제목 : <input type="text" name="title"></div>
		<div>내용 : <textarea name="ctnt"></textarea></div>
		<div>
			<input type="submit" value="작성">
		</div>
	</form>
</body>
</html>