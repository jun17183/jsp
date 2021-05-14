<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<h1>Join</h1>
	<form action="userJoin" method="post">
		<div>id : <input type="text" name="uid" placeholder="id"></div>
		<div>password : <input type="password" name="upw" placeholder="password"></div>
		<div>name : <input type="text" name="unm" placeholder="name"></div>
		<div>
			gender :
			<label>여성<input type="radio" name="gender" value="0" checked></label>
			<label>남성<input type="radio" name="gender" value="1"></label>
		</div>
		<input type="submit" value="가입">
	</form>
	<div><a href="userLogin">뒤로가기</a></div>
</body>
</html>