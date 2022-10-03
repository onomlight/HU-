<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<%@include file="/resources/includes/link.jsp" %>

<h1>LOGOUT PAGE</h1>

	<form action="/SecTest/customLogout" method="post">
		<input type=hidden name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>


</body>
</html>