<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="frm" action="join" method="post" onsubmit="return frmChk()">
	<div>
		<input type="text" name="uid" placeholder="아이디">
		<input type="button" id="chkIdBtn" value="ID중복체크">
		<div id="chkUidResult"></div>
	</div>
	<div><input type="password" name="upw" placeholder="비밀번호"></div>
	<div><input type="password" id="chkUpw" placeholder="비밀번호 확인"></div>
	<div><input type="text" name="unm" placeholder="이름"></div>
	<div>
		<label>남 : <input type="radio" name="gender" value="1" checked></label>
		<label>여 : <input type="radio" name="gender" value="0"></label>
	</div>
	<div><input type="submit" value="회원가입"></div>
</form>

<!-- 
	onsubmit : submit할 때 작동
	return 키워드 반드시 포함해야 함
	return 값이 false면 submit이 작동되지 않음
 -->
