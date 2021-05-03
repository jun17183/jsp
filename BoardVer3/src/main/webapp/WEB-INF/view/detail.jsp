<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<style>
	* { position: relative; box-sizing: border-box; border-collapse: collapse; }
	body { width: 500px; margin: auto; border: 1px solid black; }
	#header { width: 499px; height: 50px; line-height: 50px; border-bottom: 1px solid black; font-size: 25px; font-weight: bold; text-align: center; }
	#boardInfo { width: 499px; height: 42px; padding: 10px; border-bottom: 1px solid black; }
	#boardInfo > span:first-child { margin-right: 10px; }
	a { float: right; margin-left: 8px; }
	button { cursor: pointer; }
	#content { width: 499px; height: 400px; padding: 10px; }
</style>
</head>
<body>
	<div id="header">${vo.title}</div>
	<div id="boardInfo">
		<span>번호 : ${vo.iboard}</span><span>/ 작성일 : ${vo.regdt} /</span>
		<a href="/list"><button>목록</button></a>
		<a href="/del?iboard=${param.iboard}"><button>삭제</button></a>
		<a href="/update?iboard=${param.iboard}"><button>수정</button></a>
	</div>
	<div id="content">${vo.ctnt}</div>
</body>
<script>

</script>
</html>