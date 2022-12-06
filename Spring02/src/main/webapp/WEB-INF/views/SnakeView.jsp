<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="Pack01.Animal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>SnakeView.jsp</h1>
	<%
		Animal animal = (Animal)request.getAttribute("animal");
		for(String value: animal.getItem()){
			out.println(value + "<br/>");
		}
	%>
</body>
</html>