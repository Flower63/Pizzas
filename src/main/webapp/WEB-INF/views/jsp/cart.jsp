<%@ include file="header.jsp"%>

<table style="width: 100%; text-align: center">
	<c:forEach items="${pizzas}" var="pizza">
		<tr>
			<td>${pizza.name}</td>
			<td>${pizza.type}</td>
			<td>${pizza.cost}</td>
			<td>
				<form action="/pizzas/app/order/remove_from_cart">
					<input type="hidden" name="pizzaId" value="${pizza.id}">
					<button type="submit">Remove</button>
				</form>
			</td>
	</c:forEach>
</table>

<div style="text-align: center;">
	<div>
		<form action="/pizzas/app/order/submit">
			<div class="side">
				<button type="submit">Submit order</button>
			</div>
			<div class="side">
				<select name="addressId">
					<c:forEach var="address" items="${addresses}">
						<option value="${address.id}">${address.city} ${address.street} ${address.apartment}</option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>
	<div class="side">
		<form action="/pizzas/app/order/new">
			<button type="submit">Get more</button>
		</form>
	</div>
	<div class="side">
		<form action="/pizzas/app/pizza/">
			<button type="submit">Main</button>
		</form>
	</div>
</div>
</body>
</html>