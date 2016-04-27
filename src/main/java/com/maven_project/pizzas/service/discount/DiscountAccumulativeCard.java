package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.card.AccumulativeCard;
import com.maven_project.pizzas.service.card.AccumulativeCardService;

import java.util.Map;

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

		for (Map.Entry<Pizza, Integer> entry : order.getPizzas().entrySet()) {
			total += (entry.getKey().getCost() * entry.getValue());
		}
		
		return total;
	}

}
