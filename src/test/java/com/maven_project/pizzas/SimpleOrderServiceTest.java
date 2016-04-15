package com.maven_project.pizzas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:/appContext.xml"}
, inheritInitializers = true)
public class SimpleOrderServiceTest extends RepositoryTestConfig {
	
	@Autowired
	OrderService instance;

	@Test
	public void testSimpleOrderService() {
	
	}

	@Test
	public void testPlaceNewOrder() {
		System.out.println("placeNewOrder");
		Customer customer = null;
		Integer[] pizzasID = new Integer[] {1};
		Order result = instance.placeNewOrder(customer, pizzasID);
		System.out.println(result);
	}

	@Test
	public void testCreateOrder() {
	}
}
