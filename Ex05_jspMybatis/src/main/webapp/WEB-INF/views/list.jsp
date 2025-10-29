<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		margin : 0 auto;
		width : 300px;
		}
</style>
</head>
<body>
	<p>총 레코드 수 : ${totalRecord} </p>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.boardno}</td>
				<td><a href = "detail?boardno=${b.boardno}">${b.title}</a></td>
				<td>${b.writer}</td>
				<td><a href="delete?boardno=${b.boardno}"><button class="button">삭제하기</button></a></td>
		</c:forEach>
	</table>
	<p><a href="writerForm"><button type="button">글쓰기</button></a></p>
</body>
</html>