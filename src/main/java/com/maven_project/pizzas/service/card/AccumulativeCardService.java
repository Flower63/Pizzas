package com.maven_project.pizzas.service.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.card.CardRepository;

@Service(value="cardService")
public class AccumulativeCardService {
	
	private CardRepository repository;

	@Autowired
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
