package com.maven_project.pizzas.repository.order;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.domain.Pizza.Type;
import com.maven_project.pizzas.repository.AddressRepository;
import com.maven_project.pizzas.repository.CustomerRepository;
import com.maven_project.pizzas.repository.OrderRepository;
import com.maven_project.pizzas.repository.PizzaRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private Order order;
	
	@Before
	public void createOrder() {
		order = new Order();
		
		Address address = new Address("City", "Street", "Apprtmnt");
		
		addressRepository.save(address);
		
		Customer customer = new Customer("Igor", Arrays.asList(address));
		
		customerRepository.save(customer);
		
		Pizza pizza = new Pizza("Test pizza", Type.VEGETERIAN, 105D);
		
		pizzaRepository.save(pizza);
		
		order.setCustomer(customer);
		order.setAddress(address);
		
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(pizza, 3);
		
		order.setPizzas(pizzas);
	}

	@Test
	public void testSaveOrder() {
		assertNull(order.getId());
		
		orderRepository.save(order);
		
		assertNotNull(order.getId());
		
		assertNotNull(orderRepository.findOne(order.getId()));
	}

	@Test
	public void testDeleteOrder() {
		orderRepository.save(order);

		assertNotNull(orderRepository.findOne(order.getId()));

		orderRepository.delete(order);

		assertNull(orderRepository.findOne(order.getId()));
	}

}
