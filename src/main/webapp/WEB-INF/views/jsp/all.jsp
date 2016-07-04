<%@ include file="header.jsp"%>
	<h1>Pizzas</h1>
	
	<form action="/pizzas/app/pizza/new">
		<button type="submit">Add pizza</button>
	</form>
	<form action="/pizzas/app/pizza/">
		<button type="submit">Main</button>
	</form>

	<table>
		<c:forEach items="${pizzas}" var="pizza">
			<tr>
				<td>${pizza.id}</td>
				<td>${pizza.name}</td>
				<td>${pizza.type}</td>
				<td>${pizza.cost}</td>
				<td>
					<form action="/pizzas/app/pizza/edit">
						<input type="hidden" name="id" value="${pizza.id}">
						<button type="submit">Edit</button>
					</form>
				</td>
				<td>
					<form action="/pizzas/app/pizza/delete">
						<input type="hidden" name="id" value="${pizza.id}">
						<button type="submit">Delete</button>
					</form>
				</td>
		</c:forEach>
	</table>

	
</body>
</html>