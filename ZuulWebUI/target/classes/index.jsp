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
	<a href="http://localhost:8082/bpp1"> Zuul ���(X) </a><br/>
	<a href="http://localhost:8765/bpp1"> Zuul ���(O) </a><br/>
	
	<a href="app1"> Feign ��� </a><br />
</body>
</html>