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