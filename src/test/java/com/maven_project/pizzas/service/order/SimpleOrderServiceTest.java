package com.maven_project.pizzas.service.order;

import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.discount.DiscountService;

import junit.framework.TestCase;

public class SimpleOrderServiceTest extends TestCase {
	
	OrderService orderService;
	OrderRepository orderRepository;
	PizzaRepository pizzaRepository;
	DiscountService discountService;
	
	public void setUp() {
		orderRepository = mock(OrderRepository.class);
		pizzaRepository = mock(PizzaRepository.class);
		discountService = mock(DiscountService.class);
		
		orderService = new SimpleOrderService(orderRepository, pizzaRepository, discountService);
	}

	public void testPlaceNewOrder() {
		Order order = orderService.placeNewOrder(null, 1, 2, 3);
		
		verify(pizzaRepository).getPizzaByID(1);
		verify(pizzaRepository).getPizzaByID(2);
		verify(pizzaRepository).getPizzaByID(3);
		
		verify(orderRepository).saveOrder(any(Order.class));
		
		assertTrue(order.getPizzas().size() == 3);
	}

	public void testProceedOrder() {
		Order order = mock(Order.class);

		orderService.proceedOrder(order);

		verify(order).proceedOrder();
	}

	public void testCancelOrder() {
		Order order = mock(Order.class);

		orderService.cancelOrder(order);

		verify(order).cancelOrder();
	}

	public void testCountTotalCost() {
		when(pizzaRepository.getPizzaByID(1)).thenReturn(new Pizza(1, "Fake pizza", Pizza.Type.REGULAR, 10D));
		Customer customer = mock(Customer.class);

		Order order = orderService.placeNewOrder(customer, 1, 1, 1);

		assertEquals(30.0, orderService.countTotalCost(order));
	}
}
