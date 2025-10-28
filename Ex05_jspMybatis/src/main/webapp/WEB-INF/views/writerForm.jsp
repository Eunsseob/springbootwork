<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	body{
		margin : 0 auto;
		align-content: center;
		text-align: center;
	}

	table{
	}
</style>
</head>
<body>
	<h1>글쓰기 폼 라인갑니다</h1>
	<hr>
	<form action="write" method="post">
		<table class="table-primary" align="center">
			<tr>
				<th>제목들어갈꺼임</th>
				<th><input type="text" name="title" width=300px></input></th>
				
				
			</tr>
			<tr>
				<th>작성자 들어갑니다</th>
				<th><input type="text" name="writer"width=300px></input></th>
				
			</tr>		
			<tr>
				<th>콘텐츠 내용 들어갈 예정&emsp;&emsp;</th>
				<th><input type="text" name="content"width=300px></input></th>
			</tr>
		</table>
		<br>
		<button type="submit" algin="center">작성하기</button>&emsp;&emsp;&emsp;
		<button type="button" algin="center"><a href="list">목록으로</a></button>
		</form>
</body>
</html>