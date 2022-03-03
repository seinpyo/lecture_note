function loginCheck(){
	if(document.frm.id.value==""){
		alert("아이디를 입력하세요");
		document.frm.id.focus();
		return false;
	} else if (document.frm.pw.value==""){
		alert("비밀번호를 입력하세요");
		document.frm.pw.focus();
		return false;
	} else { 
		return true;
	}
}

function idCheck() {
	if(document.frm.id.value=="") {
		alert('아이디를 입력해 주세요');
		document.frm.id.focus();
		return;
	}
	var id = document.frm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=450, height=200";
	window.open("idcheck?id="+id, "중복체크", opt);
}

function joinCheck(){
	if(document.frm.pw.value=="") {
		alert("비밀번호를 입력해주세요");
		document.frm.pw.focus();
		return false;
	} else if(document.frm.name.value=="") {
		alert("이름을 입력해주세요");
		document.frm.name.focus();
		return false;
	} else if(document.frm.pw.value != document.frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.pw.focus();
		return false;
	} else if(document.frm.re_id.value != document.frm.id.value) {
		alert("id 중복체크 해주세요.");
		document.frm.id.focus();
		return false;
	} else if(document.frm.phone.value=="") {
		alert("전화번호를 입력하세요.");
		document.frm.phone.focus();
		return false;
	} else {
		return true;
	} 

}

function idok(userid){
	opener.frm.id.value = userid;
	opener.frm.re_id.value = userid;
	self.close();
}


function editCheck(){
	if(document.frm.pw.value=="") {
		alert("비밀번호를 입력해주세요");
		document.frm.pw.focus();
		return false;
	} else if(document.frm.name.value=="") {
		alert("이름을 입력해주세요");
		document.frm.name.focus();
		return false;
	} else if(document.frm.pw.value != document.frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.pw.focus();
		return false;
	}  else {
		return true;
	} 

}


function boardCheck(){
	if(document.frm.title.value=="") {
		alert("제목을 입력해주세요");
		document.frm.title.focus();
		return false;
	} else if(document.frm.pass.value=="") {
		alert("비밀번호를 입력해주세요");
		document.frm.pass.focus();
		return false;
	} else if(document.frm.content.value=="") {
		alert("내용을 입력해주세요");
		document.frm.content.focus();
		return false;
	}  else {
		return true;
	} 
}





