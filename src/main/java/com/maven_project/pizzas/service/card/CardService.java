package com.maven_project.pizzas.service.card;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;

public interface CardService {
	AccumulativeCard findCardByCustomer(Customer customer);
	
	boolean refillCard(AccumulativeCard card, double amount);
	
	Integer createNewCard(Customer customer);
	
	boolean deleteCard(AccumulativeCard card);
}
