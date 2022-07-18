<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
textarea {
	  resize: none;
}
</style>
<meta charset="UTF-8">
</head>
<body>
<center>
<FORM METHOD=POST action='allview_replyWrite'>
<table width=650 border=1 cellspacing=0 cellpadding=5 >
<tr>
	<td><b>번호</b></td>
	<td>댓글<input type=text name=replyId value='INSERT' readonly></td>
</tr>
<tr>
	<td><b>제목</b></td>
	<td><input type=text name=replyTitle pattern="[가-힣a-zA-Z0-9\s]{1,70}" title="특수문자는 사용할 수 없습니다" size=70 maxlength=70 required></td>
</tr>
<tr>
	<td><b>일자</b></td>
	<td>${formatDate}</td>
</tr>
<tr>
	<td><b>내용</b></td>
	<td><textarea style='width:500px; height:250px;' name=replyContent required></textarea></td>
</tr>
<tr>
	<td><b>원글번호</b></td>
	<td><input type=number name=originalPostId value='${originalPostIdtoWrite}' readonly></td>
</tr>
<tr>
	<td><b>대댓글 확인번호</b></td>
	<td><input type=number name=replyLevel value='${replyLeveltoWrite}' readonly></td>
</tr>
<tr>
	<td><b>댓글 배치번호</b></td>
	<td><input type=number name=replyViewOrder value='${replyViewOrdertoWrite}' readonly></td>
</tr>
</table>
<table width=650>
<tr>
	<td width=600></td>
	<td><input type=button value="취소" OnClick="location.href='/e_02'" style="margin: auto;"></td>
	<td><input type=submit value="쓰기" style="margin: auto;"></td>
</tr>
</table>
</FORM>
</center>
</body>
</html>