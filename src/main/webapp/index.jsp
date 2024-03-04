<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>비동기 통신을 위한 REST API 테스트</h3>
	<hr>
	<p>동기방식의 통신은 html문서를 응답받아 화면을 만들었습니다. 비동기식 통신은 json 문자열을
	   응답으로 받습니다. 추후에 자바스크립트로 화면의 일부를 조작하여 데이터를 표시할 것입니다.</p>
	<ul>
		<li><a href="api/customer/list">모든 고객 조회</a>
		<li><a href="api/customer?id=hongGD">고객ID 중복검사</a>
		<!-- rest api 방식에서는 파라미터값을 url 처럼 보낼 수도 있습니다. 그러나 서블릿 가각 만들어야만 가능합니다.
			 그래서 이 프로젝트에서는 테스트를 생략합니다. -->
		<!-- <li><a href="api/customer/hongGD">고객ID 중복검사</a> -->
		<li><a href="api/product/list">모든 상품 조회</a>
	</ul>
	
	
</body>
</html>