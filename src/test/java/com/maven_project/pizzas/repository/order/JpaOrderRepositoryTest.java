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
import com.maven_project.pizzas.repository.address.AddressRepository;
import com.maven_project.pizzas.repository.customer.CustomerRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class JpaOrderRepositoryTest {
	
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
		
		addressRepository.saveAddress(address);
		
		Customer customer = new Customer("Igor", Arrays.asList(address));
		
		customerRepository.saveCustomer(customer);
		
		Pizza pizza = new Pizza("Test pizza", Type.VEGETERIAN, 105D);
		
		pizzaRepository.savePizza(pizza);
		
		order.setCustomer(customer);
		order.setAddress(address);
		
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(pizza, 3);
		
		order.setPizzas(pizzas);
	}

	@Test
	public void testSaveOrder() {
		assertNull(order.getId());
		
		orderRepository.saveOrder(order);
		
		assertNotNull(order.getId());
		
		assertNotNull(orderRepository.findOrder(order.getId()));
	}

	@Test
	public void testUpdateOrder() {
		orderRepository.saveOrder(order);
		
		order.proceedOrder();
		
		orderRepository.updateOrder(order);
		
		Order temp = orderRepository.findOrder(order.getId());
		
		assertEquals(temp.getState(), Order.State.IN_PROGRESS);
	}

	@Test
	public void testDeleteOrder() {
		orderRepository.saveOrder(order);

		assertNotNull(orderRepository.findOrder(order.getId()));

		orderRepository.deleteOrder(order);

		assertNull(orderRepository.findOrder(order.getId()));
	}

}
