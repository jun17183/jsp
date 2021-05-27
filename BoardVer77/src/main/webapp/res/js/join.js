var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkUpwElem = frmElem.chkUpw;
var unmElem = frmElem.unm;

var chkUidResultElem = frmElem.querySelector('#chkUidResult');
var chkIdBtnElem = frmElem.querySelector('#chkIdBtn');
chkIdBtnElem.addEventListener('click', function() {
	idChkAjax(chkIdBtnElem.value);
});

function idChkAjax(uid) {
	fetch('/user/idChk?uid=' + uid)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		if (myJson.result == 0) {
			chkUidResultElem.innerText = '아이디 사용 가능';
		} else {
			chkUidResultElem.innerText = '아이디 사용 불가';
		}
	});
}
/* 
	원래는 기능이 더 추가되어야 한다.
	1. 사용불가 문구를 보고도 회원가입 진행하는 경우
	2. 사용가능 문구가 뜬 후 아이디를 다시 살짝 바꾸고 회원가입을 진행하는 경우를 막기 위해
	   입력이 새로 되면 다시 문구 지우기
	3. 아이디 확인을 하지 않으면 하라고 문구 띄우기
*/

function frmChk() {
	var result = false;
	var uidVal = uidElem.value;	
	var upwVal = upwElem.value;	
	var chkUpwVal = chkUpwElem.value;	
	var unmVal = unmElem.value;
	
	if (uidVal.length == 0) {
		alert('아이디를 입력해주세요.');
	} else if (uidVal.length < 3) {
		alert('아이디를 3자 이상 입력해주세요.');
	} else if (upwVal.length == 0) {
		alert('비밀번호를 입력해주세요.');
	} else if (upwVal.length < 4) {
		alert('비밀번호를 4자 이상 입력해주세요.');
	} else if (upwVal !== chkUpwVal) {
		alert('비밀번호를 확인해주세요.');
	} else if (unmVal.length < 2) {
		alert('이름을 2자 이상 입력해주세요.');
	} else {
		result = true;
	}
	
	return result;
}



/*
	<자바스크립트 이벤트 바인딩>
	1. addEventListener
	:  elem.addEventListener('click', function() {})
	
	2. .onclick(과 같은 이벤트)
	:  elem.onclick = function() {}
	(주의! function abc(){} 함수가 이미 있을 때 elem.onclick = abc() 라고 하면 안 됨.
	 무조건 elem.onclick = function() { abc() } 이렇게 해야됨.)

	// json은 문자열이다.
*/


