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
	<h1>权其捞瘤</h1>
	<%= new Date() %><br/>
	<a href="t1"> 傅农1 </a><br/>
	<a href="users"> 傅农2 </a><br/>
	<a href="users/1"> 傅农3 </a><br/>
	<a href="users/1/comments"> 傅农4 </a><br/>
	<a href="users?postId=1"> 傅农5 </a><br/>
</body>
</html>