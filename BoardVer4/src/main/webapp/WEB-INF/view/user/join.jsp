<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Join</title>
</head>
<body>
	<div>
		<a href="login">로그인 돌아가기</a>
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
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>