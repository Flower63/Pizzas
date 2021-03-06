package com.maven_project.pizzas.service.card;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.CardRepository;
import com.maven_project.pizzas.service.impl.SimpleCardService;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Denys
 *
 * on 4/6/2016.
 */
public class AccumulativeCardServiceTest {
	
	private CardRepository repository;
	private SimpleCardService cardService;

	@Before
	public void setUp() throws Exception {
		repository = mock(CardRepository.class);
		cardService = new SimpleCardService(repository);
		//when(repository.findCardByCustomerId(anyInt())).thenReturn(new AccumulativeCard());
	}

	@Test
    public void testFindCard() throws Exception {
    	AccumulativeCard card = cardService.findCardByCustomer(new Customer());
    	
    	assertTrue(card != null);
    	
    	//verify(repository).findCardByCustomerId(anyInt());
    }

	@Test
    public void testRefillCard() throws Exception {
    	AccumulativeCard card = mock(AccumulativeCard.class);
    	
    	cardService.refillCard(card, 1.1);
    	
    	verify(card).addToTotalAmount(1.1);
    }
}