package com.maven_project.pizzas.repository.card;

import java.util.HashMap;
import java.util.Map;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.service.card.AccumulativeCard;

public class InMemCardRepository implements CardRepository {
	
	private final Map<String, AccumulativeCard> storage = new HashMap<>();

	@Override
	public AccumulativeCard findCard(Customer customer) {
		return storage.get(customer.getName());
	}

	@Override
	public void initCards() {
		// TODO Auto-generated method stub
		
	}

}
