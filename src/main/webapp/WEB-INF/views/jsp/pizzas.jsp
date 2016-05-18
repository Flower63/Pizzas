<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<td>${pizza.id}</td>
				<td>${pizza.name}</td>
				<td>${pizza.type}</td>
				<td>${pizza.cost}</td>
				<td>
					<form action="/pizzas/edit">
						<input type="hidden" name="pizzaId" value="${pizza.id}">
						<button type="submit">Edit</button>
					</form>
				</td>
		</c:forEach>
	</table>
</body>
</html>