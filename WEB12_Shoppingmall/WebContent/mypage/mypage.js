function go_cart(){
	if(document.formm.quantity.value == "") {
		alert("수량을 입력하세요")
		document.formm.quantity.focus();
	} else { 
		document.formm.action = "shop.do?command = cartInsert";
		document.formm.submit();
	}
}

function go_cart_delete(){
	var count = 0;
	if(document.formm.cseq.length==undefined) {
		//장바구니에 물건이 하나일 때 해당 항목에 체크가 되어있는지 검사해서 count에 적용
		if(document.formm.cseq.checked==true) count++;
	} else {
		for(var i=0; i<document.formm.cseq.length; i++){
			if(document.formm.cseq[i].checked==true) count++;
		}
	}
	if (count==0) {
		alert("삭제할 항목을 선택해주세요");
	} else {
		document.formm.action = "shop.do?command=cartDelete"
		document.formm.submit();
	}
	//몇 개 체크되었는지 갯수를 세고 하나도 체크되지 않았다면 되돌아감
}

function go_order_insert() {
	document.formm.action = "shop.do?command=orderInsert";
	document.formm.submit();
}