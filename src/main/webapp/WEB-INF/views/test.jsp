<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="data" items="${datas}">
	<a href='/testAllView/?key=${data.id}'>
	<c:out value="${data.id}" />
	<c:out value="${data.time}" />
	<c:out value="${data.title}" />
	</a>
	</c:forEach>
	<c:forEach var="dataReply" items="${datasReply}">
	<c:out value="${dataReply.id}" />
	<c:out value="${dataReply.time}" />
	<c:out value="${dataReply.title}" />
	</c:forEach>
</body>
</html>