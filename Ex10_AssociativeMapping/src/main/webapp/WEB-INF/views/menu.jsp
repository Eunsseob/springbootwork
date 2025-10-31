<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member JPA #02</title>
</head>
<body>
	<h1>Member JPA #02</h1>
	
	<a href="insert">데이터 추가</a><p/>
	<a href="selectAll">전체 조회</a><p/>
	<a href="selectById?id=1">개별 조회 - byId</a><p/>
	
	<hr>
	
	<a href="selectByName?name=박지훈">개별 조회 - byName</a><p/>
	<a href="selectByEmail?email=test5@tjoeun.com">개별 조회 - byEmail</a><p/>
	<a href="selectByNameLike?name=김">리스트 조회 - Name Like</a><p/>
	<a href="selectByNameLikeNameDesc?name=김">리스트 조회 - Name Like Name Desc</a>
</body>
</html>