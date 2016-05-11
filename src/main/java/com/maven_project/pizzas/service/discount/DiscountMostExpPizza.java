package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;

public class DiscountMostExpPizza implements Discount {

	@Override
	public double countDiscount(Order order) {
		if (order.getPizzasCount() <= 4) {
			return 0;
		}
		
		double maxPrice = 0;
		
		for(Pizza p : order.getPizzas().keySet()) {
			if (p.getCost() > maxPrice) {
				maxPrice = p.getCost();
			}
		}
		
		return maxPrice * 0.3;
	}

}
