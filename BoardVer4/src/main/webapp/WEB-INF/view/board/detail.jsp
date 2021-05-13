<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>detail</title>
</head>
<body>
	<div>번호 : ${param.iboard}</div>
	<div>제목 : ${vo.title}</div>
	<div>작성자 : ${vo.unm}</div>
	<div>작성일 : ${vo.regdt}</div>
	<div>내용 : ${vo.ctnt}</div>
	<div><a href="list">목록</a></div>
	<c:if test="${loginUser.iuser == vo.iuser}">
		<div>
			<a href="update?iboard=${param.iboard}"><button>수정</button></a>
			<a href="delete?iboard=${param.iboard}"><button>삭제</button></a>
		</div>
	</c:if>
</body>
</html>