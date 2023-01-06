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
	
	<a href="app1"> RestTemplate 사용 </a><br/>
	<a href="app2"> Feign 사용1 </a><br/>
	
	<a href="app2/20"> Feign 사용1 성공버튼</a><br/>
	<a href="app2/2000"> Feign 사용1 실패버튼</a><br/>
	
	<a href="app3"> Feign 사용2 </a><br/>
</body>
</html>