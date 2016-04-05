package com.maven_project.pizzas.service.discount;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.domain.Order;

public class DiscountProvider {
	private static final DiscountProvider INSTANCE = new DiscountProvider();
	
	private List<Discount> discounts = new ArrayList<>();
	
	{
		discounts.add(new DiscountAccumulativeCard());
		discounts.add(new DiscountMostExpPizza());
	}
	
	public static DiscountProvider getInstance() {
		return INSTANCE;
	}
	
	public List<Discount> getDiscounts(Order order) {
		/*
		 * Here must be some complex logic to create list of discounts
		 */
		return discounts;
	}
}
