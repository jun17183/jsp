<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<script defer src="/res/js/boardList.js"></script>
<link rel="stylesheet" href="/res/css/boardList.css">
</head>
<body>
	<h1>Board List</h1>
	<h1>${sessionScope.loginUser.unm} (${sessionScope.loginUser.uid})님 반갑습니다.</h1>
	<div><a href="boardWrite">write</a></div>
	<div><a href="/user/userLogout">logout</a></div>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard})">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.unm}</td>
				<td>${item.regdt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

<!-- 
	가끔 자바스크립트를 수정해도 적용이 안 되는 경우가 있음. 이는 웹이 수정하기 전 자바스크립트를 캐쉬메모리에
	여전히 담아두고 있기 때문이다. 위 상황을 피하려면 캐쉬메모리를 삭제하거나 캐쉬메모리 자체를 사용하지 않으면 된다.
	
	방법1. 시크릿모드를 쓴다. (Ctrl+Shift+N) (시크릿모드 설정에서 캐쉬를 끌 수가 있다.)
	방법2. 설정에서 캐쉬 삭제
	방법3. 자바스크립트를 불러온 코드 (script src=""...)의 src="~"에서 ~뒤에 ver=숫자아무거나 적으면 된다.
-->
<!-- 
	< ~scope >
	스코프는 pageContext, request, session, application 총 4가지가 있는데,
	el식에서 그냥 attribute명(or param)만 적으면 pageContext부터 하나하나 돌면서 해당 attribute가 있는지 체크한다.
	그래서 바로 해당 스코프를 가리키려면 ~scope.attribute명을 적어주면 된다.
	(pageContext는 그냥 pageScope만 적어주면 된다.)
 -->




