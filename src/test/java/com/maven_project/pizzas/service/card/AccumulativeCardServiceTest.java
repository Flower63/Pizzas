package com.maven_project.pizzas.service.card;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.card.CardRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Denys
 *
 * on 4/6/2016.
 */
public class AccumulativeCardServiceTest {
	
	CardRepository repository;
	AccumulativeCardService cardService;

	@Before
	public void setUp() throws Exception {
		repository = mock(CardRepository.class);
		cardService = new AccumulativeCardService(repository);
		when(repository.findCard(any(Customer.class))).thenReturn(new AccumulativeCard());
	}

	@Test
    public void testFindCard() throws Exception {
    	AccumulativeCard card = cardService.findCard(new Customer(0, null, null));
    	
    	assertTrue(card != null);
    	
    	verify(repository).findCard(any(Customer.class));
    }

	@Test
    public void testRefillCard() throws Exception {
    	AccumulativeCard card = mock(AccumulativeCard.class);
    	
    	cardService.refillCard(card, 1.1);
    	
    	verify(card).addToTotalAmount(1.1);
    }
}