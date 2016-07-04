<%@ include file="header.jsp"%>
<br>
<div class="center">
	<h1>Welcome to pizza service!</h1>

	<sec:authorize access="hasRole('ADMIN')">
		<div class="side">
			<form action="/pizzas/app/pizza/all">
				<button type="submit">Manage pizzas</button>
			</form>
		</div>
	</sec:authorize>
	<div class="side">
		<form action="/pizzas/app/order/new">
			<button type="submit">Order pizzas</button>
		</form>
	</div>
	<br>
</div>
</body>
</html>