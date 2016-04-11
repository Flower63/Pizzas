package com.maven_project.pizzas.repository.card;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.service.card.AccumulativeCard;

@Repository(value="cardRepository")
public class InMemCardRepository implements CardRepository {
	
	private final Map<String, AccumulativeCard> storage = new HashMap<>();

	@Override
	public AccumulativeCard findCard(Customer customer) {
		return storage.get(customer.getName());
	}

	@PostConstruct
	@Override
	public void initCards() {
		// TODO Auto-generated method stub
		
	}

}
