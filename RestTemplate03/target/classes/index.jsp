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
	
	<a href="app1"> RestTemplate 사용1 </a><br/>
	<a href="app2/1000"> RestTemplate 사용2 </a><br/>
	
	<a href="app3"> Web Client 사용 </a><br/>
</body>
</html>