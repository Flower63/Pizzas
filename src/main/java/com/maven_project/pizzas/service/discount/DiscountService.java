package com.maven_project.pizzas.service.discount;

import java.util.List;

import com.maven_project.pizzas.domain.Order;

public class DiscountService {
	
	private final DiscountProvider provider = new DiscountProvider();
	
	public double countDiscount(Order order) {
		List<Discount> discounts = provider.getDiscounts(order);
		
		double totalDiscount = 0;
		
		for (Discount d : discounts) {
			totalDiscount += d.countDiscount(order);
		}
		
		return totalDiscount;
	};
}
