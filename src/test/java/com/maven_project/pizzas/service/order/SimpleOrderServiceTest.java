package com.maven_project.pizzas.service.order;

import static org.mockito.Mockito.*;

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
		
		orderService.placeNewOrder(null, 1, 2, 3);
		
		verify(pizzaRepository).getPizzaByID(1);
		verify(pizzaRepository).getPizzaByID(2);
		verify(pizzaRepository).getPizzaByID(3);
		
		verify(orderRepository).saveOrder(any(Order.class));
		
	}

	public void testProceedOrder() {

	}

	public void testCancelOrder() {
		
	}

	public void testCountTotalCost() {
		
	}

}
