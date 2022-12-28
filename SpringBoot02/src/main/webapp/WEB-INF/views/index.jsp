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
	<a href="users"> 링크2 </a><br/>
	<a href="users/1"> 링크3 </a><br/>
	<a href="users/1/comments"> 링크4 </a><br/>
	<a href="users?postId=1"> 링크5 </a><br/>
</body>
</html>