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
<SCRIPT LANGUAGE="JavaScript">
function submitForm(mode) {
	if (mode == "update"){
		document.fm.action = "allview_update";
	} else if (mode == "delete"){ 
		document.fm.action = "delete";
	}
	fm.submit();
}
</SCRIPT>
<meta charset="UTF-8">
</head>
<body>
<FORM METHOD=POST name='fm'>
<center>
<table width=650 border=1 cellspacing=0 cellpadding=5>
<tr>
	<td><b>번호</b></td>
	<td><input type=text name=id size=70 maxlength=70 value='${keyNum}' readonly></td>
</tr>
<tr>
	<td><b>제목</b></td>
	<td><input type=text name=title size=70 maxlength=70 value='${title}'></td>
</tr>
<tr>
	<td><b>일자</b></td>
	<td>${date}</td>
</tr>
<tr>
	<td><b>내용</b></td>
	<td><textarea style='width:500px; height:250px;' name=content >${content}</textarea></td>
</tr>
</table>
</center>
<center>
<table width=650>
<tr>
	<td width=600></td>
	<td><input type=button value="취소" OnClick="location.href='/e_02'"></td>
	<td><input type=button value="확인" OnClick="submitForm('update')"></td>
	<td><input type=button value="삭제" OnClick="submitForm('delete')"></td>
</tr>
</table>
</center>
</FORM>
</body>
</html>