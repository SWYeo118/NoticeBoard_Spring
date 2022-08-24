<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<script>
  </script>
</head>
<body>
	<center>
		<span style="font-size: 42px;"><b>정렬 시간비교 프로그램입니다.</b></span><br>
		<br> <br>
		<form action="/sorting/selectColumn">
			<select name="selectColumn"> 
				<option>정렬할 컬럼을 선택해주세요</option> 
				<option value="14">지하철과의 거리로 정렬</option> 
				<option value="5">면적으로 정렬</option>
				<option value="10">준공연도로 정렬</option> 
				<option value="8">금액으로정렬</option>
			</select>  
			<span> 
			<input type="submit" value="선택">
			</span>
		</form>
	</center>

	<center>
		<table>
			<c:forEach var="item" items="${backDatas}">
				<tr>
					<th width=150px height=40px>${item}</th>
				</tr>
			</c:forEach>
		</table>
	</center>







</body>
</html>