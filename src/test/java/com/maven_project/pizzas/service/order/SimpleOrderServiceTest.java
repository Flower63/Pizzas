package com.maven_project.pizzas.service.order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Map;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.OrderRepository;
import com.maven_project.pizzas.service.OrderService;
import com.maven_project.pizzas.service.PizzaService;
import com.maven_project.pizzas.service.impl.SimpleDiscountService;
import com.maven_project.pizzas.service.impl.SimpleOrderService;

import org.junit.Before;
import org.junit.Test;

public class SimpleOrderServiceTest {
	
	private OrderService orderService;
	private OrderRepository orderRepository;
	private PizzaService pizzaService;
	private Customer customer;

	@Before
	public void setUp() {
		orderRepository = mock(OrderRepository.class);
		pizzaService = mock(PizzaService.class);
		customer = mock(Customer.class);

		Pizza pizza = new Pizza();
		pizza.setName("Test pizza");
		pizza.setType(Pizza.Type.SEA);
		pizza.setPrice(100D);

		when(pizzaService.getPizzaByID(anyInt())).thenReturn(pizza);

		SimpleDiscountService discountService = mock(SimpleDiscountService.class);
		
		orderService = new SimpleOrderService(orderRepository, pizzaService, discountService);
	}

	@Test
	public void testPlaceNewOrder() {
		Order order = orderService.placeNewOrder(customer, Arrays.asList(1, 2, 3), null);
		
		verify(pizzaService).getPizzaByID(1);
		verify(pizzaService).getPizzaByID(2);
		verify(pizzaService).getPizzaByID(3);
		
		verify(orderRepository).save(any(Order.class));

		assertEquals(order.getPizzasCount(), 3);
	}

	@Test
	public void testProceedOrder() {
		Order order = mock(Order.class);

		orderService.proceedOrder(order);

		verify(order).proceedOrder();
	}

	@Test
	public void testCancelOrder() {
		Order order = mock(Order.class);

		orderService.cancelOrder(order);

		verify(order).cancelOrder();
	}

	@Test
	public void testCountTotalCost() {
		double delta = 1e-15;

		when(pizzaService.getPizzaByID(1)).thenReturn(new Pizza("Fake pizza", Pizza.Type.REGULAR, 10D));

		Order order = orderService.placeNewOrder(customer, Arrays.asList(1, 1, 1), null);

		assertEquals(30.0, orderService.countTotalCost(order), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCustomer() {
		orderService.placeNewOrder(null, Arrays.asList(1), null);
	}
}
