<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit pizza</title>
</head>
<body>
	<form action="/pizzas/addNew" method="post">
		<input type="hidden" name="pizzaId" value="${pizza.id}">
		<input type="text" name="name" value="${pizza.name}">
		<input type="text" name="type" value="${pizza.type}">
		<input type="number" name="cost" step="any" value="${pizza.cost}">
		<input type="submit" value="Save">
	</form>
</body>
</html>