package com.maven_project.pizzas.repository.card;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.customer.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class JpaCardRepositoryTest {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private AccumulativeCard card;
	private Customer customer;
	
	private static final double DELTA = 1e-15;
	
	@Before
	public void makeCard() {
		card = new AccumulativeCard();
		
		customer = new Customer("Evgeniy", Collections.emptyList());
		
		customerRepository.saveCustomer(customer);
		
		card.setCustomer(customer);
	}

	@Test
	public void testFindCard() {
		cardRepository.saveCard(card);
		
		assertNotNull(cardRepository.findCard(card.getId()));
	}

	@Test
	public void testSaveCard() {
		assertNull(card.getId());
		
		cardRepository.saveCard(card);
		
		assertNotNull(card.getId());
	}

	@Test
	public void testDeleteCard() {
		cardRepository.saveCard(card);
		
		assertNotNull(cardRepository.findCard(card.getId()));
		
		cardRepository.deleteCard(card);
		
		assertNull(cardRepository.findCard(card.getId()));
	}

	@Test
	public void testUpdateCard() {
		cardRepository.saveCard(card);
		
		assertNotNull(cardRepository.findCard(card.getId()));
		
		card.setTotalAmount(100);
		
		cardRepository.updateCard(card);
		
		AccumulativeCard temp = cardRepository.findCard(card.getId());
		
		assertNotNull(temp);
		
		assertEquals(100, temp.getTotalAmount(), DELTA);
	}

	@Test
	public void testFindCardByCustomerId() {
		Customer customer1 = new Customer("Customer 1", Collections.emptyList());
		Customer customer2 = new Customer("Customer 2", Collections.emptyList());
		Customer customer3 = new Customer("Customer 3", Collections.emptyList());
		
		customerRepository.saveCustomer(customer1);
		customerRepository.saveCustomer(customer2);
		customerRepository.saveCustomer(customer3);
		
		AccumulativeCard accumulativeCard1 = new AccumulativeCard();
		accumulativeCard1.setCustomer(customer1);
		
		AccumulativeCard accumulativeCard2 = new AccumulativeCard();
		accumulativeCard2.setCustomer(customer2);
		
		AccumulativeCard accumulativeCard3 = new AccumulativeCard();
		accumulativeCard3.setCustomer(customer3);
		
		cardRepository.saveCard(accumulativeCard1);
		cardRepository.saveCard(accumulativeCard2);
		cardRepository.saveCard(accumulativeCard3);
		
		assertEquals(accumulativeCard1, cardRepository.findCardByCustomerId(customer1.getId()));
		assertEquals(accumulativeCard2, cardRepository.findCardByCustomerId(customer2.getId()));
		assertEquals(accumulativeCard3, cardRepository.findCardByCustomerId(customer3.getId()));
	}
	
	@Test
	public void testFindCardByCustomerIdFail() {
		Customer customer1 = new Customer("Customer 1", Collections.emptyList());
		Customer customer2 = new Customer("Customer 2", Collections.emptyList());
		Customer customer3 = new Customer("Customer 3", Collections.emptyList());
		
		customerRepository.saveCustomer(customer1);
		customerRepository.saveCustomer(customer2);
		customerRepository.saveCustomer(customer3);
		
		AccumulativeCard accumulativeCard1 = new AccumulativeCard();
		accumulativeCard1.setCustomer(customer1);
		
		AccumulativeCard accumulativeCard2 = new AccumulativeCard();
		accumulativeCard2.setCustomer(customer2);
		
		AccumulativeCard accumulativeCard3 = new AccumulativeCard();
		accumulativeCard3.setCustomer(customer3);
		
		cardRepository.saveCard(accumulativeCard1);
		cardRepository.saveCard(accumulativeCard2);
		cardRepository.saveCard(accumulativeCard3);
		
		assertNotEquals(accumulativeCard1, cardRepository.findCardByCustomerId(customer2.getId()));
		assertNotEquals(accumulativeCard2, cardRepository.findCardByCustomerId(customer3.getId()));
		assertNotEquals(accumulativeCard3, cardRepository.findCardByCustomerId(customer1.getId()));
		
		Customer customer4 = new Customer("Customer 4", Collections.emptyList());
		
		customerRepository.saveCustomer(customer4);
		
		assertNull(cardRepository.findCardByCustomerId(customer4.getId()));
	}

}
