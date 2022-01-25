function go_search(){
	if(document.frm.key.value == "") return;
	var url = "shop.do?command=adminProductList&page=1"; //검색결과의 1page로 이동
	document.frm.action = url;
	document.frm.submit();
}

function go_total(){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminProductList&page=1";
	document.frm.submit();
}

function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}

function go_save(){
	var theForm = document.frm;
	if( theForm.kind.value =="" ){
		alert("상품분류를 선택하세요");
		theForm.kind.focus();
	}else if (theForm.name.value == "") {
		alert('상품명을 입력하세요.'); 	theForm.name.focus();	
	} else if (theForm.price1.value == "") {
		alert('원가를 입력하세요.'); 		theForm.price1.focus();
	} else if (theForm.price2.value == "") {
		alert('판매가를 입력하세요.'); 		theForm.price2.focus();
	} else if (theForm.content.value == "") {
		alert('상품상세를 입력하세요.'); 		theForm.content.focus();
	} else if (theForm.image.value == "") {
		alert('상품이미지들 입력하세요.'); 	theForm.image.focus();	
	} else{
		theForm.action = "shop.do?command=adminProductwrite";
		theForm.submit();
	}
}

function cal(){
	if(document.frm.price2.value== "" || document.frm.price1.value=="") return;
}

function go_detail(pseq){
	var url="shop.do?command=adminProductDetail&pseq="+pseq;
	document.frm.action = url;
	document.frm.submit();
}

function go_mov(){
	location.href = "shop.do?command=adminProductList";
}

function go_mod(pseq){
	url = "shop.do?command=adminProductUpdateForm&pseq="+pseq;
	location.href = url;
	//submit 받을 필요가 딱히 없으므로 location.href로 이동
}

function go_mod_save(){
	if(document.frm.kind.value==""){
		alert("상품분류를 선택하세요");
		document.frm.kind.focus();
	} else if(document.frm.name.value==""){
		alert("상품명을 입력하세요");
		document.frm.name.focus();
	} else if(document.frm.price1.value==""){
		alert("사입가를 입력하세요");
		document.frm.price1.focus();
	} else if(document.frm.price2.value==""){
		alert("판매가를 입력하세요");
		document.frm.price2.focus();
	} else if(document.frm.content.value==""){
		alert("상세 설명을 입력하세요");
		document.frm.content.focus();
	} else {
		if(confirm('수정하시겠습니까?')){
			document.frm.action = "shop.do?command=adminProductUpdate";
			document.frm.submit();
		}
	}
}