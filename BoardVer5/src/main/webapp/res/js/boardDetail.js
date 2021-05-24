var insFrm = document.querySelector('#insFrm');
var updFrm = document.querySelector('#updFrm');

function delCmt(iboard, icmt) {
	console.log(`iboard: ${iboard}, icmt: ${icmt}`);
	
	if (confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}

function updCmt(icmt, cmt) {
	insFrm.classList.add('hidden');
	updFrm.classList.remove('hidden');
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
}

function frmFlag() {
	insFrm.classList.remove('hidden');
	updFrm.classList.add('hidden');
}


// 위 ${}는 el식이 아님. 만약 위와 같은 태그를 js파일로 분리 없이 직접 jsp에 적는다면
// ${}를 el식으로 받아들이기 때문에 주의해야 한다.
// 만약 jsp에서 직접 js를 작성하는 경우 위 ``를 쓰려면 \n처럼 \${}을 이용할 수 있다.
// 물론 js를 jsp에 직접 쓰는 행위 자체를 피애햐 한다.

// js는 elem.~ 처럼 . 뒤에 원래 속성이 온다.
// 근데 자식을 가리킬 때도 .을 활용한다. ~에 자식의 name, id를 적으면 해당 자식을 가리킨다.