<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizzas page</title>
</head>
<body>
	<table>
		<c:forEach items="${pizzas}" var="pizza">
			<tr>
				<td>${pizza.pizzaId}</td>
				<td>${pizza.name}</td>
				<td>${pizza.type}</td>
				<td>${pizza.cost}</td>
				<td>
					<form action="/pizzas/app/edit">
						<input type="hidden" name="pizzaId" value="${pizza.pizzaId}">
						<button type="submit">Edit</button>
					</form>
				</td>
		</c:forEach>
	</table>

	<form action="/pizzas/app/logout" method="post">
		<button type="submit">Logout</button>
	</form>

	<a href="/pizzas/logout">Logout</a>

	<c:url var="logoutUrl" value="/logout" />
	<%-- <form action="${logoutUrl}" method="post"> --%>
	<form action="/pizzas/logout" method="post">
		<input type="submit" value="Log out" /> 
		<input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>