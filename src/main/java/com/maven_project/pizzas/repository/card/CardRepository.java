package com.maven_project.pizzas.repository.card;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.service.card.AccumulativeCard;

public interface CardRepository {
	AccumulativeCard findCard(Customer customer);
}
