<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css">
<script defer src="/res/js/join.js"></script>
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:if test="${sessionScope.loginUser eq null}">
					<li><a href="/user/login">로그인</a></li>
				</c:if>
				<c:if test="${sessionScope.loginUser != null}">
					<li><a href="/user/logout">로그아웃</a></li>
					<li><a href="/board/write">글쓰기</a></li>
					<li><a href="/board/favoriteList">좋아요한 글</a></li>
				</c:if>
				<li><a href="/board/list">목록</a></li>
			</ul>
		</nav>
	</header>
	<jsp:include page="/WEB-INF/view/${requestScope.jsp}.jsp"></jsp:include>
</body>
</html>