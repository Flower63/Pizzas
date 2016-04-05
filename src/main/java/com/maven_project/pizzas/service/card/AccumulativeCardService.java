package com.maven_project.pizzas.service.card;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.card.CardRepository;
import com.maven_project.pizzas.repository.card.InMemCardRepository;

public class AccumulativeCardService {
	
	CardRepository repository;
	
	public AccumulativeCardService() {
		repository = new InMemCardRepository();
	}

	public AccumulativeCardService(CardRepository repository) {
		this.repository = repository;
	}

	public AccumulativeCard findCard(Customer customer) {
		return repository.findCard(customer);
	}
	
	public boolean refillCard(AccumulativeCard card, double amount) {
		card.addToTotalAmount(amount);
		
		return true;
	}
}