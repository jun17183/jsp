<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<style>
	* { box-sizing: border-box; }
	#wrap { position: relative; width: 500px; margin: auto; border: 1px solid black; }
	#title { width: 499px; height: 40px; border-bottom: 1px solid black; line-height: 40px; }
	#title > div { margin-left: 10px; }
	#title input { width: 420px; }
	#ctnt { width: 499px; height: 300px; padding: 12px; border-bottom: 1px solid black; }
	textarea { width: 469px; height: 240px; margin-top: 5px; }
	#btnBox { width: 500px; height: 40px; }
	#btnBox input { position: relative; float: right; top: 8px; margin-right: 10px; cursor: pointer; }
	#listBtn { position: absolute; bottom: 8px; margin-left: 10px; }
	button { cursor: pointer; }
</style>
</head>
<body>
	<div id="wrap">
		<form action="/write" method="post">
			<div id="title">
				<div>
					<span>제목 : </span>
					<input type="text" name="title">
				</div>
			</div>
			<div id="ctnt">
				<div>내용 : </div>
				<textarea name="ctnt"></textarea>
			</div>
			<div id="btnBox">
				<input type="submit" value="작성">
			</div>
		</form>
		<a href="/list" id="listBtn"><button>목록</button></a>
	</div>
</body>
</html>