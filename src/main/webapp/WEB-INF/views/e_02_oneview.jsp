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
		<table width=650 border=1 cellspacing=0 cellpadding=5>
			<tr>
				<td width=170><b>번호</b></td>
				<td><c:out value="${keyNum}" /></td>
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><c:out value="${title}" /></td>
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td><c:out value="${date}" /></td>
			</tr>
			<tr>
				<td><b>조회수</b></td>
				<td><c:out value="${viewingCount}" /></td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea style='width:500px; height:250px;' name=content readonly>${content}</textarea></td>
			</tr>
			<tr>
				<td><b>원글번호</b></td>
				<td><c:out value="${originalPostId}" /></td>
			</tr>
		</table>
		<table width=650 style="margin: auto;">
			<tr>
				<td width=600></td>
				<td><input type=button value="목록"
					OnClick="location.href='/e_02'"></td>
				<td><input type=button value="수정"
					OnClick="location.href='update?key=${keyNum}'"></td>
				<td><input type=button value="삭제" 
					OnClick="location.href='delete?key=${keyNum}'"></td>
				<td><input type=button value="댓글"
				 	OnClick="location.href='replyWrite?key=${keyNum}'"></td>
			</tr>
		</table>
	</FORM>
</center>
</body>
</html>