package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.card.AccumulativeCard;
import com.maven_project.pizzas.service.card.AccumulativeCardService;
import com.maven_project.pizzas.service.order.OrderService;
import com.maven_project.pizzas.service.order.SimpleOrderService;

public class DiscountAccumulativeCard implements Discount {

	@Override
	public double countDiscount(Order order) {
		AccumulativeCardService cardService = new AccumulativeCardService();
		AccumulativeCard card = cardService.findCard(order.getCustomer());
		
		if (card == null) {
			return 0;
		}
		
		double cardDiscount = card.getTotalAmount() * 0.1;
		
		OrderService orderService = new SimpleOrderService();
		
		double orderSumDiscount = orderService.countTotalCost(order) * 0.3;
		
		return orderSumDiscount < cardDiscount ? orderSumDiscount : cardDiscount;
	}

}
