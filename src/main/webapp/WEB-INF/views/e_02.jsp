<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
a {
	  text-decoration-line: none;
}
</style>
<meta charset="UTF-8">
</head>
<body>
<center>
<span style="font-size: 42px;"><b>게시판입니다!</b></span><br><br><br>
	<table cellspacing=1 cellpadding=1 width=600 border=1>
		<tr>
			<td width=70><p align=center>번호</p></td>
			<td width=500><p align=center>제목</p></td>
			<td width=70><p align=center>조회수</p></td>
			<td width=100><p align=center>등록일</p></td>
		</tr>
		<c:forEach var="noticeData" items="${noticeDataAll}">
			<tr>
				<td width=70><p align=center>
						<c:out value="${noticeData.id}" />
					</p></td>
				<td width=500><p align=center>
						<a href='/e_02/oneview?key=${noticeData.id}'><c:out
								value="${noticeData.title}" /></a>
					</p></td>
				<td width=70><p align=center>
						<c:out value="${noticeData.viewingCount}" />
					</p></td>
				<td width=170><p align=center>
						<c:out value="${noticeData.date}" />
					</p></td>
			</tr>
		</c:forEach>
	</table>
	<table width=650>
		<tr>
			<td width=550></td>
			<td><input type=button value="신규"
				OnClick="window.location='e_02/pageWrite'"></td>
		</tr>
	</table>
		<div class="text-center">
		<c:url var="urlppPage" value="/e_02" >
			<c:param name="cPage" value="${ppPage}"/>
		</c:url>
		
		<c:url var="urlpPage" value="/e_02">
			<c:param name="cPage" value="${pPage}"/>
		</c:url>
		
		<c:url var="urlnnPage" value="/e_02">
			<c:param name="cPage" value="${nnPage}"/>
		</c:url>
		
		<c:url var="urlnPage" value="/e_02">
			<c:param name="cPage" value="${nPage}"/>
		</c:url>
		  <a href=<c:out value="${urlppPage}"/>><c:out value="<<"/></a>
		  <a href=<c:out value="${urlppPage}"/>><c:out value="<"/></a>
		<c:forEach var="i" begin="${cPageInt}" end="${totalPage}">
		  <b><a href = 'e_02?cPage=${i-1}'>${i}</a></b>
		</c:forEach>
		<c:if test="${nnPage ne 0 && nPage ne 0}">
			<a href=<c:out value="${urlnPage}"/>><c:out value=">"/></a>
			<a href=<c:out value="${urlnnPage}"/>><c:out value=">>"/></a>
		</c:if>
		</center>
	</div>
	
</body>
</html>