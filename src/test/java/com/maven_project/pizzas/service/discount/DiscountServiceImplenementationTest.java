package com.maven_project.pizzas.service.discount;

import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.InMemOrderRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.order.OrderService;
import com.maven_project.pizzas.service.order.SimpleOrderService;

import junit.framework.TestCase;

public class DiscountServiceImplenementationTest extends TestCase {

	public void testCountDiscount() {
		PizzaRepository pizzaRepository = mock(PizzaRepository.class);
		when(pizzaRepository.getPizzaByID(1)).thenReturn(new Pizza(1, "Fake pizza", Pizza.Type.REGULAR, 10D));
		OrderService orderService =
				new SimpleOrderService(new InMemOrderRepository(), pizzaRepository, new DiscountServiceImplenementation());
		AccumulativeCard card = new AccumulativeCard();
		Customer customer = mock(Customer.class);
		when(customer.getCard()).thenReturn(card);
		
		
	}

}
