<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<div></div>
	<form action="userLogin" method="post">
		<div><input type="text" name="uid" placeholder="id"></div>
		<div><input type="password" name="upw" placeholder="password"></div>
		<input type="submit" value="login">
	</form>
	<div><a href="userJoin">join</a></div>
</body>
</html>