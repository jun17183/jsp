<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			<div><input type="text" name="uid" placeholder="id"></div>
			<div><input type="password" name="upw" placeholder="password"></div>
			<div>
				<input type="submit" value="login">
			</div>
		</form>
	</div>
	<div>
		<a href="join">join</a>
	</div>
</body>
</html>