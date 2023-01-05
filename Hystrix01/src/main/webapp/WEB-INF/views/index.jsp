<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<%= new Date() %><br/>
	<a href="t1"> 링크1 </a><br/>
	
	<a href="app1/300"> RestTemplate 사용1(성공) </a><br/>
	<a href="app1/2000"> RestTemplate 사용2(실패) </a><br/>
</body>
</html>