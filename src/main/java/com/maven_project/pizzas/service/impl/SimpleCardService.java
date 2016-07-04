package com.maven_project.pizzas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.CardRepository;
import com.maven_project.pizzas.service.CardService;

@Service
public class SimpleCardService implements CardService {
	
	private CardRepository repository;

	@Autowired
	public SimpleCardService(CardRepository repository) {
		this.repository = repository;
	}

	@Override
	public AccumulativeCard findCardByCustomer(Customer customer) {
		//return repository.findCardByCustomerId(customer.getId());
		return null;
	}
	
	@Override
	public boolean refillCard(AccumulativeCard card, double amount) {
		card.addToTotalAmount(amount);
		
		return true;
	}

	@Override
	public Integer createNewCard(Customer customer) {
		AccumulativeCard card = new AccumulativeCard();
		card.setCustomer(customer);
		
		return repository.save(card).getId();
	}

	@Override
	public boolean deleteCard(AccumulativeCard card) {
		repository.delete(card);
		
		return true;
	}
}
