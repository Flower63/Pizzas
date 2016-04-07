package com.maven_project.pizzas.service.discount;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.card.AccumulativeCardService;

public class DiscountProvider {
	private final List<Discount> discounts = new ArrayList<>();
	private final AccumulativeCardService cardService;
	
	public DiscountProvider(AccumulativeCardService cardService) {
		this.cardService = cardService;
	}

	public void prepareDiscounds() {
		discounts.add(new DiscountAccumulativeCard(cardService));
		discounts.add(new DiscountMostExpPizza());
	}
	
	public List<Discount> getDiscounts(Order order) {
		/*
		 * Here must be some complex logic to create list of discounts
		 */
		return discounts;
	}
}
