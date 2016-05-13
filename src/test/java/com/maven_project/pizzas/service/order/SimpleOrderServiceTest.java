package com.maven_project.pizzas.service.order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.service.discount.DiscountService;
import com.maven_project.pizzas.service.pizza.PizzaService;

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
		pizza.setCost(100);

		when(pizzaService.getPizzaByID(anyInt())).thenReturn(pizza);

		DiscountService discountService = mock(DiscountService.class);
		
		orderService = new SimpleOrderService(orderRepository, pizzaService, discountService){

			@Override
			protected Order getOrder(Customer customer, Map<Pizza, Integer> pizzas) {
				return new Order(customer, pizzas);
			}
		};
	}

	@Test
	public void testPlaceNewOrder() {
		Order order = orderService.placeNewOrder(customer, 1, 2, 3);
		
		verify(pizzaService).getPizzaByID(1);
		verify(pizzaService).getPizzaByID(2);
		verify(pizzaService).getPizzaByID(3);
		
		verify(orderRepository).saveOrder(any(Order.class));

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

		Order order = orderService.placeNewOrder(customer, 1, 1, 1);

		assertEquals(30.0, orderService.countTotalCost(order), delta);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullCustomer() {
		orderService.placeNewOrder(null, 1);
	}
}
