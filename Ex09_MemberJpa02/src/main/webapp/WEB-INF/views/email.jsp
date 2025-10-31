<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #01</h1>
	<c:if test="${member != null}">
		아이디 : ${member.id}<p/>
		이름 : ${member.name}<p/>
		email : ${member.email}<p/>
	</c:if>
</body>
</html>