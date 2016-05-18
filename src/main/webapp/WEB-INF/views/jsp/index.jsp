<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1>Hello from index!</h1>
<form action="/pizzas/pizzas" method="get">
	<button type="submit">Show pizzas</button>
</form>
<form action="/pizzas/edit" method="get">
	<button type="submit">Add new pizza</button>
</form>
</body>
</html>