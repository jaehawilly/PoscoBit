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
	<a href="users"> ��ũ2 </a><br/>
	<a href="users/1"> ��ũ3 </a><br/>
	<a href="users/1/comments"> ��ũ4 </a><br/>
	<a href="users?postId=1"> ��ũ5 </a><br/>
</body>
</html>