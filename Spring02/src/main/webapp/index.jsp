<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>메인 페이지</title>
</head>

<body>
	<%=new Date()%>
	<h2>Hello World</h2>
	<a href="t1">링크1</a><br/>
	<a href="t2">링크2</a><br/>
	<a href="t3?name=apple">링크3</a><br/>
	<a href="t4?name=banana&age=30">링크4</a><br/>
	<a href="t5?name=orange&age=40">링크5</a><br/>
	<a href="t6">링크6</a><br/>
	<a href="t7?name=kiwi&age=50">링크7</a><br/>
	<a href="t8">링크8</a><br/>
	<a href="t9?token=true">링크9(True)</a><br/>
	<a href="t9?token=false">링크9(False)</a><br/>
	<a href="t10">링크10</a><br/>
	
	
	<form method=post action="t11">
		<input type="text" name="id" value="tiger" /><br/>
		<input type="number" name="pw" value=1234 /><br/>	
		<input type="submit" value="전송" /><br/>
	</form><br/>
	
	<a href="t12">링크12</a><br/>
	<a href="t13_1">링크13_1</a><br/>
	<a href="t13_2">링크13_2</a><br/>
	<a href="t13_3">링크13_3</a><br/>
	
	<form method=get action="t14_3">
		<input type="submit" value="get 전송" /><br/>
	</form>
	<form method=post action="t14_3">
		<input type="submit" value="post 전송" /><br/>
	</form>
	
	
	<form method=get action="t15_1">
		<input type="submit" value="get 전송" /><br/>
	</form>
	<form method=post action="t15_2">
		<input type="submit" value="post 전송" /><br/>
	</form>
	
	<a href="register/step1">링크step1</a><br/>
	<a href="register/step2">링크step2</a><br/>
	<a href="register/step3">링크step3</a><br/>
	
	<!-- get -->
	<a href="t17">설문조사</a><br/>
	
	<form method=post action="t18">
		<input type="text" name="item[0]" value="tiger0" /><br/>
		<input type="text" name="item[1]" value="tiger1" /><br/>	
		<input type="text" name="item[2]" value="tiger2" /><br/>
		<input type="submit" value="전송" /><br/>
	</form><br/><br/>
	
	<form method=post action="t19">
		<input type="text" name="rabbit.num1" value="4444" /><br/>
		<input type="text" name="num2" value="5555" /><br/>
		<input type="submit" value="전송" /><br/>
	</form><br/>
	
</body>



