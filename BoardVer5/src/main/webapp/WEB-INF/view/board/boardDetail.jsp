<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden { display: none; }
	i { color: red; }
</style>
<script defer src="/res/js/boardDetail.js?ver=3"></script>
</head>
<body>
	<h1>${requestScope.vo.title}
		<c:if test="${vo.isFav eq 0}">	<!-- eq말고 그냥 ==해도 됨 / 이렇게 c:if쓰면 굳이 css로 hidden같은거 안해도 됨 -->
			<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
		</c:if>
		<c:if test="${vo.isFav eq 1}">
			<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</h1>
	<div>번호 : ${requestScope.param.iboard}</div>
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
		<form id="insFrm" action="cmt" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<input type="hidden" name="icmt" value="0">
			<div>
				<textarea name="cmt" placeholder="댓글"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="iboard" value="${param.iboard}">
			<input type="hidden" name="icmt" value="">
			<div>
				<textarea name="cmt" placeholder="댓글"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="frmFlag()">
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
							<button onclick="delCmt(${param.iboard}, ${item.icmt})">삭제</button>
							<button onclick="updCmt(${item.icmt}, '${item.cmt}')"
							>수정</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>