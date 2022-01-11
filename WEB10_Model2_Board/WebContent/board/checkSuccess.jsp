<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name == 'update'){
		window.opener.location.href = 'board.do?command=boardUpdateForm&num=${param.num}';
	} else if(window.name == 'delete'){
		var bool = confirm("삭제하시겠습니까?");
		if(bool) 
			window.opener.location.href = 'board.do?command=boardDelete&num=${param.num}';
		else 
			window.opener.location.href = 'board.do?command=boardViewWithoutCount&num=${param.num}';
		
	}
	self.close();
</script>
</body>
</html>