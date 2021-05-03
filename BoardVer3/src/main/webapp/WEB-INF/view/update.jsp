<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style>
	* { position: relative; box-sizing: border-box; border-collapse: collapse; }
	body { width: 500px; margin: auto; border: 1px solid black; }
	#header { width: 499px; height: 50px; line-height: 50px; border-bottom: 1px solid black; }
	#header > input { position: relative; top: -2px; width: 479px; height: 30px; margin-left: 10px; }
	#boardInfo { width: 499px; height: 42px; padding: 10px; border-bottom: 1px solid black; }
	#boardInfo > span:first-child { margin-right: 10px; }
	#boardInfo > input { float: right; cursor: pointer; }
	#content { width: 499px; height: 400px; padding: 10px; }
	#content > textarea { width: 479px; height: 380px; }
	a { position: absolute; top: 60px; right: 58px; }
	a:last-child { right: 107px; }
	button { cursor: pointer; }
</style>
</head>
<body>
	<form action="/update" method="post">
		<div id="header"><input type="text" name="title" value="${vo.title}"></div>
		<div id="boardInfo">
			<span>no : ${vo.iboard}</span><span>/ 작성일 : ${vo.regdt} /</span>
			<input type="hidden" name="iboard" value="${vo.iboard}">
			<input type="submit" value="수정">
		</div>
		<div id="content"><textarea name="ctnt">${vo.ctnt}</textarea></div>	
	</form>
	<a href="/list"><button>목록</button></a>
	<a href="/del?iboard=${param.iboard}"><button>삭제</button></a>
</body>
</html>