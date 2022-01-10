//new file 

function loginCheck(){
	if( document.frm.userid.value.length==0 ){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		return false;
	}
	if( document.frm.pwd.value.length==0 ) {
		alert("비밀번호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck(){
	if(document.frm.userid.value==""){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		return;
	}
	var inputid = document.frm.userid.value;
	var opt ="toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
	window.open("board.do?command=idcheck&userid=" + inputid, "idcheck", opt);
}

function idok(userid){
	opener.frm.userid.value=userid;
	opener.frm.reid.value=userid;
	self.close();
}

function joinCheck(){
	
	if( document.frm.userid.value.length==0){
		alert("아이디는 필수입력사항입니다");
		document.frm.userid.focus();
		return false;
	}
	
	if( document.frm.userid.value.length<4){
		alert("아이디는 4글자 이상이어야 합니다");
		document.frm.userid.focus();
		return false;
	}
	
	if( document.frm.userid.value != document.frm.reid.value ){
		alert("아이디 중복체크를 하지 않으셧습니다");
		document.frm.userid.focus();
		return false;
	}
	
	if( document.frm.name.value.length == 0){
		alert("이름은 필수입력사항입니다");
		document.frm.name.focus();
		return false;
	}
	
	if( document.frm.pwd.value.length==0){
		alert("비밀번호는 필수입력사항입니다.");
		document.frm.pwd.focus();
		return false;
	}
	if( document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		document.frm.pwd_check.focus();
		return false;
	}
	
	return true;
}

function editCheck(){
	if( document.frm.name.value.length==0){
		alert("이름은 필수입력사항입니다");
		document.frm.userid.focus();
		return false;
	}
	if( document.frm.pwd.value.length==0){
		alert("비밀번호는 필수입력사항입니다.");
		document.frm.pwd.focus();
		return false;
	}
	if( document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		document.frm.pwd_check.focus();
		return false;
	}
	return true;
}

function boardCheck(){
	if( document.frm.pass.value.length==0){
		alert("비밀번호를 입력해주세요.");
		document.frm.pass.focus();
		return false;
	}
	if( document.frm.title.value.length==0){
		alert("제목을 입력해주세요.");
		document.frm.title.focus();
		return false;
	}
	if(document.frm.content.value.length==0){
		alert("내용을 입력해주세요.");
		document.frm.content.focus();
		return false;
	}
	return true;
	
}
