function loginCheck(){
	if(document.loginForm.id.value==""){
		alert("아이디는 필수 입력 사항입니다.")
		return false;
	}
	if(document.loginForm.pwd.value==""){
		alert("비밀번호는 필수 입력 사항입니다")
		return false;
	}
	return true;
}

function go_next(){
	if(document.contractFrm.okon[1].checked == true) {
		alert("회원 약관에 동의해야 회원가입이 가능합니다.");
	} else {
		document.contractFrm.action = "shop.do?command=joinForm";
		document.contractFrm.submit();
	}
}

function idcheck(){
	if( document.joinForm.id.value=="" ){
		alert("아이디를 입력하세요" );
		documnet.joinForm.id.focus();
		return;
	}
	var url = "shop.do?command=idCheckForm&id=" + document.joinForm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
	window.open(url, "IdCheck", opt);
}


function idok(userid){
	opener.joinForm.id.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}

function post_zip(){
	var url = "shop.do?command=findZipNum";
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width = 550";
	opt = opt + " height=300, top=300, left=300";
	window.open(url,"우편번호 찾기", opt);
}

function result(zipNum, sido, gugun, dong) {
	opener.document.joinForm.zip_num.value = zipNum;
	opener.document.joinForm.addr1.value = sido+" "+gugun+" "+ dong;
	self.close();
}

function go_save(){
	if(document.joinForm.id.value=="") {
		alert("아이디를 입력하여 주세요.");
		document.joinForm.id.focus();
	} else if(document.joinForm.reid.value!=document.joinForm.id.value) {
		alert("아이디 중복확인을 해주세요.");
		document.joinForm.id.focus();
	} else if(document.joinForm.pwd.value=="") {
		alert("비밀번호를 입력해 주세요.");
		document.joinForm.pwd.focus();
	} else if(document.joinForm.pwd.value!=document.joinForm.pwdCheck.value) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.joinForm.pwd.focus();
	} else if(document.joinForm.name.value=="") {
		alert("이름을 입력해 주세요.");
		document.joinForm.name.focus();
	} else if(document.joinForm.email.value=="") {
		alert("이메일을 입력해 주세요.");
		document.joinForm.email.focus();
	} else {
		document.joinForm.action="shop.do";
		document.joinForm.submit();
	}
}