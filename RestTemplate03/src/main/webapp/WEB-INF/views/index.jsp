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
	<h1>Ȩ������</h1>
	<%= new Date() %><br/>
	<a href="t1"> ��ũ1 </a><br/>
	
	<a href="app1"> RestTemplate ���1 </a><br/>
	<a href="app2/1000"> RestTemplate ���2 </a><br/>
	
	<a href="app3"> Web Client ��� </a><br/>
</body>
</html>