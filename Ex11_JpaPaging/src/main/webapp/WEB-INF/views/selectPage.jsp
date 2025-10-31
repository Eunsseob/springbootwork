<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>JPA Paging - Name Like Paging</h1>
	총 회원 수 : ${totalElement}<p/>
	총 페이지 수 : ${totalPages}<p/>
	한페이지당 회원수 : ${size}<p/>
	현재 페이지 : ${pageNumber}<p/>
	현재 페이지의 회원 수 : ${numberOfElement}
	<hr>
	<p/>
	<c:forEach var="m" items="${members}">
		ID : ${m.id}<p/>
		NAME : ${m.name}<p/>
		EMAIL : ${m.email}<hr>
	</c:forEach>
</body>
</html>