package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;

public class DiscountServiceImplenementation implements DiscountService {

	@Override
	public double countDiscount(Order order) {
		double totalDiscount = 0D;
		
		if (order.getPizzas().size() > 4) {
			Pizza max = order.getPizzas().get(0);
			
			for (Pizza pizza : order.getPizzas()) {
				if (pizza.getCost() > max.getCost()) {
					max = pizza;
				}
			}
			
			totalDiscount += (max.getCost() * 0.3);
		}
		
		if (order.getCustomer().getCard() != null) {
			AccumulativeCard card = order.getCustomer().getCard();
			
			double totalCost = 0D;
			
			for (Pizza pizza : order.getPizzas()) {
				totalCost += pizza.getCost();
			}
			
			// 10% of accumulative card
			double cardDiscount = card.getTotalAmount() * 0.1;
			
			// 30% of order cost
			double maxOrderDiscount = totalCost * 0.3;
			
			if (cardDiscount > maxOrderDiscount) {
				totalDiscount += maxOrderDiscount;
			} else {
				totalDiscount += cardDiscount;
			}
		}
		
		return totalDiscount;
	}

}
