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

<div class="container-md w-50" style="margin:100px auto;">
	<h1>LOGIN</h1>
	<h2><c:out value="${error}" /></h2>
	<h2><c:out value="${logout}"/></h2>
	<form method="post" action="/login">
		<input name=username  class="form-control m-2" placeholder="Insert UserID">
		<input type=password name=password  class="form-control m-2"  placeholder="Insert Password">
		<div class="form-check  m-2">
			<input type=checkbox name="remember-me"  class="form-check-input"  id="chk">
			<label class="form-check-label" for="chk">Remember-me</label>
		</div>
		<input type=submit class="btn btn-primary w-100 m-2">
		<input type=hidden name="${_csrf.parameterName}" value="${_csrf.token}" />
 	</form>
</div>
</body>
</html>