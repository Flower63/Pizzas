package com.maven_project.pizzas.service.card;

import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.card.CardRepository;

import junit.framework.TestCase;

/**
 * Created by Dennis on 4/6/2016.
 */
public class AccumulativeCardServiceTest extends TestCase {
	
	CardRepository repository;
	AccumulativeCardService cardService;
	
	public void setUp() throws Exception {
		repository = mock(CardRepository.class);
		cardService = new AccumulativeCardService(repository);
		when(repository.findCard(any(Customer.class))).thenReturn(new AccumulativeCard());
	}

    public void testFindCard() throws Exception {
    	AccumulativeCard card = cardService.findCard(new Customer(0, null, null));
    	
    	assertTrue(card != null);
    	
    	verify(repository).findCard(any(Customer.class));
    }

    public void testRefillCard() throws Exception {
    	AccumulativeCard card = mock(AccumulativeCard.class);
    	
    	cardService.refillCard(card, 1.1);
    	
    	verify(card).addToTotalAmount(1.1);
    }
}