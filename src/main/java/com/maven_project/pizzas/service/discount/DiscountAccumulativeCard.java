package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.card.AccumulativeCard;
import com.maven_project.pizzas.service.card.AccumulativeCardService;

public class DiscountAccumulativeCard implements Discount {
	private final AccumulativeCardService cardService;

	public DiscountAccumulativeCard(AccumulativeCardService cardService) {
		this.cardService = cardService;
	}



	@Override
	public double countDiscount(Order order) {
		AccumulativeCard card = cardService.findCard(order.getCustomer());
		
		if (card == null) {
			return 0;
		}
		
		double cardDiscount = card.getTotalAmount() * 0.1;
		
		double orderSumDiscount = countTotalCost(order) * 0.3;
		
		return orderSumDiscount < cardDiscount ? orderSumDiscount : cardDiscount;
	}



	private double countTotalCost(Order order) {
		double total = 0;
		
		for (Pizza pizza : order.getPizzas()) {
			total += pizza.getCost();
		}
		
		return total;
	}

}
