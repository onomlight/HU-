<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ALL</h1>


<sec:authorize access="isAnonymous()">
	<a href="/SecTest/customLogin">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/SecTest/customLogout">로그아웃</a>
</sec:authorize>

</body>
</html>