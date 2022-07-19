<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<center>
	<FORM METHOD=POST name='fm'>
		<table width=650 border=1 cellspacing=0 cellpadding=5 style="margin: auto; text-align: center;">
			<tr>
				<td width=170><b>번호</b></td>
				<td><c:out value="${noticeSelectOne.id}" /></td>
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><c:out value="${noticeSelectOne.title}" /></td>
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td><c:out value="${noticeSelectOne.date}" /></td>
			</tr>
			<tr>
				<td><b>조회수</b></td>
				<td><c:out value="${noticeSelectOne.viewingCount}" /></td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea style='width:500px; height:250px;' name=content readonly>${noticeSelectOne.content}</textarea></td>
			</tr>
		</table>
		<table width=650 height=50 border=0 cellspacing=0 cellpadding=0 style="margin: auto; text-align: center; font-size: 27px">
			<tr>
				<td width=650 border=1><b>댓글</b></td>
			</tr>
		</table>
		<table border=1 cellspacing=0 cellpadding=3 style="margin: auto; text-align: center;">
		<c:forEach var="noticeReply" items="${noticeReplys}">
		<tr>
			<td width=500><b>댓글 내용</b><p align=center>
					<c:out value="${noticeReply.content}" />
				</p></td>
			<td width=100><b>작성자</b><p align=center>
					<c:out value="${noticeReply.author}" /></a>
				</p></td>
			<td width=170><b>작성시간</b><p align=center>
					<c:out value="${noticeReply.date}" />
				</p></td>
		</tr>
		</c:forEach>
		</table>
		<table style="margin: auto; text-align: right;">
			<tr>
				<td><input type=button value="목록"
					OnClick="location.href='/e_02'"></td>
				<td><input type=button value="수정"
					OnClick="location.href='update?key=${noticeSelectOne.id}'"></td>
				<td><input type=button value="삭제" 
					OnClick="location.href='delete?key=${noticeSelectOne.id}'"></td>
				<td><input type=button value="댓글"
				 	OnClick="location.href='replyWrite?key=${noticeSelectOne.id}'"></td>
			</tr>
		</table>
	</FORM>
</center>
</body>
</html>