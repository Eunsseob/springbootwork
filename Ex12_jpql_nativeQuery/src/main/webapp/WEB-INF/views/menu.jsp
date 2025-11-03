<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member JPA #02</title>
</head>
<body>
	<h1>JPA Paging</h1>
	<a href="selectByNameLike1?name=user">Name Like 조회 : JPQL 1 페이지</a><p/>
	<a href="selectByNameLike2?name=user"">Name Like 조회 : JPQL 2 페이지</a><p/>
	<a href="selectByNameLike3?name=user&page=2">Name Like 조회 : JPQL 3 - 2 페이지</a><p/>
	<a href="selectByNameLike4?name=user">Name Like 조회 : Native SQL</a><p/>
</body>
</html>