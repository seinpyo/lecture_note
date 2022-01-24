<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/script.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 수정</h1>
<form name="frm" method="post" action="board.do?command=boardUpdate&num=${board.num}" enctype="multipart/form-data">
<!-- command는 input type="hidden"이 아니라 form action으로 보낸다(servlet에서 multipart/form-data 못받음) -->
<input type="hidden" name="num" value="${board.num}">
	<table>
		<tr>
			<th>작성자</th>
			<td>
				${ board.userid }
				<input type="hidden" name="userid" value="${loginUser.userid}">
				<!-- loginUser는 세션 정보이므로 사용가능 
				비밀번호만 알면 글을 수정, 삭제할 수 있으므로 현재 글을 삭제한 사람과 
				로그인한 사람이 다를 수 있으므로 이를 검사해 금지하거나 할 경우 loginUser.useruid,
				이를 무시하겠다면 board.userid를 사용하면 된다.-->
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" size="12">
				* 필수 (게시물 수정/삭제 시 필요합니다.)
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" value="${ board.email }" size="12">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" size="70" name="title" value="${board.title}"> *필수
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="70" rows="15" name="content">${board.content}</textarea> *필수
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<c:choose>
					<c:when test="${empty board.imgfilename}">
						<img src="images/noname.jpg" height="50"><br>
					</c:when>
					<c:otherwise>
						<img src="images/${board.imgfilename}" height="50"><br>
					</c:otherwise>
				</c:choose>
				<input type="file" name="imgfilename"><br>
				파일을 수정할 때만 선택하세요
				<input type="hidden" name="oldfilename" value="${board.imgfilename}">
			</td>
		</tr>
	</table>
		<input type="submit" value="수정" onClick="return boardCheck();">
		<input type="reset" value="다시 작성" >
		<input type="button" value="돌아가기" 
		onClick="location.href='board.do?command=boardViewWithoutCount&num=${board.num}'" >
		<!-- boardViewAction을 사용해 이동하면 조회수가 +1 되기 때문에 새로운
		command와 action을 만든다-->
	
</form>
</div>
</body>
</html>