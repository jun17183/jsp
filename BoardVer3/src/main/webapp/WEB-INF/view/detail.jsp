<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<div>${vo.title}</div>
	<div>
		<span>번호 : ${vo.iboard}</span><span>작성일 : ${vo.regdt}</span><a href="/list"><button>목록</button></a>
	</div>
	<div>${vo.ctnt}</div>
</body>
</html>