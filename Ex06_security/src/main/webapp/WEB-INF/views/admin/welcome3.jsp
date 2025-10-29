<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>welcome 하이 admin</h2>
	
	USER ID : ${pageContext.request.userPrincipal.name }<br><br>
	
	<a href="/logout">로그아웃</a>
</body>
</html>