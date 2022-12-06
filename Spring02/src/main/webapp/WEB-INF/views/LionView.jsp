<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>LionView</h1>
	<%
		String name2 = (String)request.getAttribute("name");
		Integer age2 = (Integer)request.getAttribute("age");
	%>
	<%= name2 %>
	<%= age2 %>
	
	<h6>${name}</h6>
	<h6>${age}</h6>
</body>
</html>