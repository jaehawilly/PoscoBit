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
	
	<a href="app1"> RestTemplate ��� </a><br/>
	<a href="app2"> Feign ���1 </a><br/>
	
	<a href="app2/20"> Feign ���1 ������ư</a><br/>
	<a href="app2/2000"> Feign ���1 ���й�ư</a><br/>
	
	<a href="app3"> Feign ���2 </a><br/>
</body>
</html>