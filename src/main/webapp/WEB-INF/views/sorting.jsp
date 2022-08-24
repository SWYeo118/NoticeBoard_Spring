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
				<option value="1">총 인구수로 정렬</option> 
				<option value="2">남자 인구수로 정렬</option>
				<option value="3">여자 인구수로 정렬</option> 
				<!-- <option value="8">금액으로정렬</option> -->
			</select>  <span> <input type="submit" value="선택">
			</span>
		</form>
		<br>
		<table>버블정렬 : ${backDatasBubble.time1} ms 소요 / 퀵정렬(듀얼피봇) :
			${backDatasBubble.time2} ms 소요
		</table>
		<table>삽입정렬 : ${backDatasInsertion.time1} ms 소요 / 퀵정렬(듀얼피봇) :
			${backDatasInsertion.time2} ms 소요
		</table>
		<table>선택정렬 : ${backDatasSelection.time1} ms 소요 / 퀵정렬(듀얼피봇) :
			${backDatasSelection.time2} ms 소요
		</table>
		<br>
		<span style="font-size: 24px;"> 정렬된 데이터 </span><br>
		<table>
			<c:forEach var="item" items="${backDatasBubble.arrIntCompare}">
				<tr>
					<th width=150px height=40px>${item}</th>
				</tr>
			</c:forEach>
		</table>
		
<%-- 		<table>
			<c:forEach var="process" items="${backDatasBubble.sorter}">
				<tr>
					<th width=150px height=40px>${process}</th>
				</tr>
			</c:forEach>
		</table> --%>
		
		
	</center>
</body>
</html>