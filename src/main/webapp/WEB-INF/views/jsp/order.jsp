<%@ include file="header.jsp"%>

<h1>Hello, customer</h1>

<form action="/pizzas/app/">
	<button type="submit">Main</button>
</form>

<br>

<div>
<c:forEach var="pizza" items="${pizzas}">
	<div class="product_item">
		<h3>${pizza.name}</h3>
		<p>${pizza.price}</p>
		<p>${pizza.type}</p>
		<form action="/pizzas/app/order/add_to_cart">
			<input type="hidden" name="pizzaId" value="${pizza.pizzaId}">
			<button type="submit">Order</button>
		</form>
	</div>
</c:forEach>
</div>
</body>
</html>