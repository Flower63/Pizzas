package com.maven_project.pizzas.service.order;

import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.repository.order.InMemOrderRepository;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.InMemPizzaRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.discount.DiscountServiceImplenementation;

import junit.framework.TestCase;

public class SimpleOrderServiceTest extends TestCase {

	public void testPlaceNewOrder() {
		
		OrderRepository orderRepository = mock(OrderRepository.class);
		
		PizzaRepository pizzaRepository = mock(PizzaRepository.class);
		
		DiscountServiceImplenementation discountServiceImplenementation = mock(DiscountServiceImplenementation.class);
		
		OrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository, discountServiceImplenementation);
		
		Order order = orderService.placeNewOrder(null, 1, 2, 3);
		
		verify(pizzaRepository).getPizzaByID(1);
		verify(pizzaRepository).getPizzaByID(2);
		verify(pizzaRepository).getPizzaByID(3);
		
		verify(orderRepository).saveOrder(any(Order.class));
		
		assertTrue(order.getPizzas().size() == 3);
	}

	public void testProceedOrder() {
		OrderRepository orderRepository = mock(OrderRepository.class);
		
		PizzaRepository pizzaRepository = mock(PizzaRepository.class);
		
		DiscountServiceImplenementation discountServiceImplenementation = mock(DiscountServiceImplenementation.class);
		
		OrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository, discountServiceImplenementation);
		
		Order order = orderService.placeNewOrder(new Customer(1, "John", null), 1, 2, 3);

		assertTrue(order.getState() == Order.State.NEW);
		
		order.proceedOrder();
		
		assertTrue(order.getState() == Order.State.IN_PROGRESS);
		
		order.proceedOrder();
		
		assertTrue(order.getState() == Order.State.DONE);
		
		order.proceedOrder();
		
		assertTrue(order.getState() == Order.State.DONE);
	}

	public void testCancelOrder() {
		
	}

	public void testCountTotalCost() {
		
	}

}
