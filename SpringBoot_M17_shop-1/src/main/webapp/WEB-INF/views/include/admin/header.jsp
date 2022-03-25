<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/admin/admin.css">
<script src="/admin/product.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#myButton').click(function(){
			var formselect = $("#fileupForm")[0];
			//지정된 폼을 변수에 저장
			
			var formdata = new FormData(formselect); 
			//전송용 폼 객체에 변수를 저장

			$.ajax({
				url:"<%=request.getContextPath()%>/fileup",
				type:"POST",
				enctype:"multipart/form-data",
				async:false,
				data:formdata,
				timeout: 10000,
				contentType: false,
				processData:false,
				success: function(data){
					if(data.STATUS == 1){
						//동적 div태그
						$("#filename").empty();
						$("#filename").append("<div>"+data.FILENAME+"</div>");
					}
				},
				error: function(){
					alert("실패");
				}
			});			
		});
	});

</script>
</head>
<body>
<div id="wrap">
<header>			
	<div id="logo">
		<img style="width:800px" src="/admin/bar_01.gif">
		<img src="/admin/text.gif">
	</div>	
	<input class="btn" type="button" value="logout" style="float: right;"
		onClick="location.href='adminLogout'">			
</header>
<div class="clear"></div>
