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
		<a href="login">�α��� ���ư���</a>
	</div>
	<div>
		<form action="join" method="post">
			<div><input type="text" name="uid" placeholder="id"></div>
			<div><input type="password" name="upw" placeholder="password"></div>
			<div><input type="text" name="unm" placeholder="name"></div>
			<div>
				���� : 
				<label>����<input type="radio" name="gender" value="0" checked></label>
				<label>����<input type="radio" name="gender" value="1"></label>
			</div>
			<div><input type="submit" value="ȸ������"></div>
		</form>
	</div>
</body>
</html>