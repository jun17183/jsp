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
	<div>��ȣ : ${param.iboard}</div>
	<div>���� : ${vo.title}</div>
	<div>�ۼ��� : ${vo.unm}</div>
	<div>�ۼ��� : ${vo.regdt}</div>
	<div>���� : ${vo.ctnt}</div>
	<div><a href="list">���</a></div>
	<c:if test="${loginUser.iuser == vo.iuser}">
		<div>
			<a href="update?iboard=${param.iboard}"><button>����</button></a>
			<a href="delete?iboard=${param.iboard}"><button>����</button></a>
		</div>
	</c:if>
</body>
</html>