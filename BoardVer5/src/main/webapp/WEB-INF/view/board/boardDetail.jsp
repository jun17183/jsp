<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
<script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
	<div>번호 : ${requestScope.param.iboard}</div>
	<div>제목 : ${requestScope.vo.title}</div>
	<div>작성자 : ${requestScope.vo.unm}</div>
	<div>작성일 : ${requestScope.vo.regdt}</div>
	<div>내용 : ${requestScope.vo.ctnt}</div>
	<div>
		<div><a href="boardList">list</a></div>
		<c:if test="${sessionScope.loginUser.iuser == requestScope.vo.iuser}">
			<div><a href="boardDelete?iboard=${requestScope.param.iboard}">delete</a></div>
			<div><a href="boardUpdate?iboard=${requestScope.param.iboard}">update</a></div>
		</c:if>
	</div>
	<div>
		<form action="cmt" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${sessionScope.loginUser.iuser == item.iuser}">
							<button onclick="delCmt(${requestScope.item.iboard, ${item.icmt})">삭제</button>
							<button>수정</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>