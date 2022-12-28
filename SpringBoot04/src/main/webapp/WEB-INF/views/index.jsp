<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script src="//code.jquery.com/jquery-3.3.1.js" ></script>

<script type="text/javascript">
	function f1() {
		$.ajax({
			url : "http://localhost:8081/t2",
			type : "GET",
		}).then(function(data) {
			console.log(data);
		});
	}
	function f2() {
		$.ajax({
			url : "http://localhost:8081/t3",
			type : "GET",
		}).then(function(data) {
			console.log(data);
			console.log(data.factorA, data.factorB);
			console.log(typeof data.factorA); // number
			
			let s1 = document.getElementById('span1');
			let s2 = document.getElementById('span2');
			s1.textContent = data.factorA;
			s2.textContent = data.factorB;
		});
	}
	function f3() {
		console.log('f3 call');
		let a = $("#span1").text();
		let b = $("#span2").text();
		
		let alias = $('input[name=alias]').val();
		console.log('별칭 : ', alias);
		
		let attempt = $('input[name=attempt]').val();
		console.log('정답 : ', attempt);
		
		let formData = {
			user: {alias:alias}, 
			multiplication: {factorA:a, factorB:b},
			resultAttempt: attempt
		};
		
		$.ajax({
			url : "http://localhost:8081/t4",
			type : "POST",
			data : JSON.stringify(formData),
			contentType: 'application/json',
		}).then(function(data) {
			let s3 = document.getElementById("span3");
			s3.textContent = data;
			console.log(data);
		});
	}
</script>

<body>
	<h1>홈페이지</h1>
	<%= new Date() %><br/>
	<a href="t1"> 링크1 </a><br/>
	<button onClick="f1()">버튼</button>
	<button onClick="f2()">문제 주세요 ?</button><br/>
	<span id="span1"></span> 곱하기
	<span id="span2"></span> 는 ?
	<br/><br/>
	
	<form id="form1" name="form1" method="post">
		별명 : <input type="text" name="alias" value="tiger"/><br/>
		정답 : <input type="text" name="attempt" value="200"/><br/>
		<input type="button" value="제출" onclick="f3()"/>
		
	</form></br>
	채점 결과 : <span id="span3"></span>
</body>
</html>

