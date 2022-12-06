<%@page import="java.util.LinkedList"%>
<%@page import="Pack01.Person"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>MonkeyView</h1>
	<h5>${num}</h5>
	<h5>${str}</h5>
	<%
		int[] ar = (int[])request.getAttribute("ar");
		for(int v : ar) {
			out.print(v + " ");
		}out.println("<br/>");
		
		
		Person p = (Person)request.getAttribute("person");
		out.println(p.getId() + " " + p.getPw());
		out.println("<br/>");
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> list01 = (LinkedList<Integer>)request.getAttribute("list01");
		out.println(list01.get(0) + " ");
		out.println(list01.get(1) + " ");
		out.println(list01.get(2) + " ");
		out.println("<br/>");
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer> list02 = (LinkedList<Integer>)request.getAttribute("list02");
		out.println(list02.get(0) + " ");
		out.println(list02.get(1) + " ");
		out.println(list02.get(2) + " ");
		out.println("<br/>");
		
		@SuppressWarnings("unchecked")
		LinkedList<Person> list03 = (LinkedList<Person>)request.getAttribute("list03");
		out.println(list03.get(0).getId() + " " + list03.get(0).getPw());
		out.println(list03.get(1).getId() + " " + list03.get(1).getPw());
		out.println(list03.get(2).getId() + " " + list03.get(2).getPw());
		out.println("<br/>");
		out.println("<br/>");
		
	%>
	
	<h1>JSTL</h1>
	<c:forEach var="a" items="${list03}" varStatus="b">
		${b.index} : ${a.getId()} ${a.getPw()}<br/>
	</c:forEach>
	
	
</body>
</html>





