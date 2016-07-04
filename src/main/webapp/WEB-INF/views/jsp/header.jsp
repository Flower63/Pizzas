<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>Pizza service</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/mystyle.css"/>">
</head>
<body>
	<img id="header" alt="hello there"
		src="<c:url value="/resources/img/header1.jpg"/>">
	<div id="container">
		<div class="left_corner">
			<h1>Pizza service</h1>
		</div>
		<div class="logout">
			<c:url var="logoutUrl" value="/logout" />
			<div class="side" style="width: 60px;">
				<%-- <a href="<c:url value="/order/shopping_cart"/>"> <img alt="cart"
					src="<c:url value="/resources/img/cart-icon.png"/>" width="40"
					height="40">
				</a> --%>
				<form action="/pizzas/app/order/shopping_cart">
					<input type="image"
					src="<c:url value="/resources/img/cart-icon.png"/>"
					width="40" height="40">
				</form>
			</div>
			<div class="side" style="width: 60px;">
				<form action="${logoutUrl}" method="post">
					<input type="image"
						src="<c:url value="/resources/img/logout-512.png"/>" alt="Logout"
						width="40" height="40" /> 
					<input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<br>