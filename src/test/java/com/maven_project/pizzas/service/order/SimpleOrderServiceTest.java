package com.maven_project.pizzas.service.order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.discount.DiscountService;

import org.junit.Before;
import org.junit.Test;

public class SimpleOrderServiceTest {
	
	OrderService orderService;
	OrderRepository orderRepository;
	PizzaRepository pizzaRepository;
	DiscountService discountService;
	Customer customer;

	@Before
	public void setUp() {
		orderRepository = mock(OrderRepository.class);
		pizzaRepository = mock(PizzaRepository.class);
		discountService = mock(DiscountService.class);
		customer = mock(Customer.class);
		
		orderService = new SimpleOrderService(orderRepository, pizzaRepository, discountService){

			@Override
			protected Order getOrder(Customer customer, Map<Pizza, Integer> pizzas) {
				return new Order(customer, pizzas);
			}
		};
	}

	@Test
	public void testPlaceNewOrder() {
		Order order = orderService.placeNewOrder(customer, 1, 2, 3);
		
		verify(pizzaRepository).getPizzaByID(1);
		verify(pizzaRepository).getPizzaByID(2);
		verify(pizzaRepository).getPizzaByID(3);
		
		verify(orderRepository).saveOrder(any(Order.class));
		
		assertTrue(order.getPizzas().size() == 3);
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

		when(pizzaRepository.getPizzaByID(1)).thenReturn(new Pizza(1, "Fake pizza", Pizza.Type.REGULAR, 10D));

		Order order = orderService.placeNewOrder(customer, 1, 1, 1);

		assertEquals(30.0, orderService.countTotalCost(order), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCustomer() {
		orderService.placeNewOrder(null, 1);
	}
}
