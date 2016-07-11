<%@ include file="header.jsp"%>
	<h1>Pizzas</h1>
	
	<form action="/pizzas/app/pizza/new">
		<button type="submit">Add pizza</button>
	</form>
	<form action="/pizzas/app/">
		<button type="submit">Main</button>
	</form>

	<table>
		<c:forEach items="${pizzas}" var="pizza">
			<tr>
				<td>${pizza.pizzaId}</td>
				<td>${pizza.name}</td>
				<td>${pizza.type}</td>
				<td>${pizza.price}</td>
				<td>
					<form action="/pizzas/app/pizza/edit" method="get">
						<input type="hidden" name="id" value="${pizza.pizzaId}">
						<button type="submit">Edit</button>
					</form>
				</td>
				<td>
					<form action="/pizzas/app/pizza/" method="delete">
						<input type="hidden" name="id" value="${pizza.pizzaId}">
						<button type="submit">Delete</button>
					</form>
				</td>
		</c:forEach>
	</table>

	
</body>
</html>