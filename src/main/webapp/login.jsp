<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/mystyle.css">
</head>
<body>
	<img id="header" alt="hello there" src="resources/img/header1.jpg">
	<div class="left_corner">
		<h1>Please, login</h1>
	</div>
	<c:url var="loginUrl" value="/login" />

	<div style="margin-top: 7%">
		<form action="${loginUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">

			<div class="center">
				<h3>User e-mail</h3>
			</div>

			<div class="center">
				<input type="text" id="username" name="username" />
				<br>
			</div>

			<div class="center">
				<h3>Password</h3>
			</div>

			<div class="center">
				<input type="password" id="password" name="password" />
				<br>
			</div>

			<div class="center" style="padding: 12px;">
				<button type="submit" class="btn">Log in</button>
				<br>
			</div>
		</form>
	</div>
</body>
</html>