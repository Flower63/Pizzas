<%@ include file="header.jsp"%>
	<form action="/pizzas/app/pizza/" method="post">
		<input type="hidden" name="pizzaId" value="${pizza.pizzaId}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${pizza.name}"></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><select name="type">
						<c:forEach items="${types}" var="type">
							<option <c:if test="${pizza.type == type}">selected</c:if> value="${type}">${type}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" step="any" name="price" value="${pizza.price}"></td>
			</tr>
		</table>
		<button type="submit">Save</button>
	</form>
	<form action="/pizzas/app/pizza/">
		<button type="submit">Cancel</button>
	</form>

</body>
</html>