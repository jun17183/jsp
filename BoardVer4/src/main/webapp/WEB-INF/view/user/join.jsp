<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<div>
		<a href="login">로그인</a>
	</div>
	<div>
		<form action="join" method="post">
			<div><input type="text" name="uid" placeholder="id"></div>
			<div><input type="password" name="upw" placeholder="password"></div>
			<div><input type="text" name="unm" placeholder="name"></div>
			<div>
				성별 : 
				<label>여성<input type="radio" name="gender" value="0" checked></label>
				<label>남성<input type="radio" name="gender" value="1"></label>
			</div>
			<div><input type="submit" value="제출"></div>
		</form>
	</div>
</body>
</html>