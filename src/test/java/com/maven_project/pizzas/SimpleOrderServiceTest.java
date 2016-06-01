package com.maven_project.pizzas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.maven_project.pizzas.domain.Customer;

@ContextConfiguration(locations = {"classpath:/appContext.xml"}
, inheritInitializers = true)
public class SimpleOrderServiceTest extends RepositoryTestConfig {
	
	@Autowired
	OrderService orderService;

	@Test
	public void testSimpleOrderService() {
	
	}

	@Test
	public void testPlaceNewOrder() {
		System.out.println("placeNewOrder");
		Customer customer = null;
		Integer[] pizzasID = new Integer[] {1};
		Order result = orderService.placeNewOrder(customer, pizzasID);
		System.out.println(result);
	}

	@Test
	public void testCreateOrder() {
	}
}
