package com.maven_project.pizzas.repository.card;

import com.maven_project.pizzas.domain.AccumulativeCard;

public interface CardRepository {
	AccumulativeCard findCard(Integer id);
	
	AccumulativeCard findCardByCustomerId(Integer customerId);
	
	Integer saveCard(AccumulativeCard card);
	
	boolean deleteCard(AccumulativeCard card);
	
	boolean updateCard(AccumulativeCard card);
}
