<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
</head>
<body>
	<div>제목 : ${vo.title}</div>
	<div>번호 : ${param.iboard}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>내용 : ${vo.ctnt}</div>
	<div>
		<div><a href="boardList">list</a></div>
		<c:if test="${loginUser.iuser == vo.iuser}">
			<div><a href="boardDelete?iboard=${param.iboard}">delete</a></div>
			<div><a href="boardUpdate?iboard=${param.iboard}">update</a></div>
		</c:if>
	</div>
</body>
</html>