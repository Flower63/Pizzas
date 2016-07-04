package com.maven_project.pizzas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.DiscountService;
import com.maven_project.pizzas.service.discount.Discount;
import com.maven_project.pizzas.service.discount.DiscountProvider;

@Service
public class SimpleDiscountService implements DiscountService {
	
	private final DiscountProvider provider;
	
	@Autowired
	public SimpleDiscountService(DiscountProvider provider) {
		this.provider = provider;
	}

	@Override
	public double countDiscount(Order order) {
		List<Discount> discounts = provider.getDiscounts(order);
		
		double totalDiscount = 0;
		
		for (Discount d : discounts) {
			totalDiscount += d.countDiscount(order);
		}
		
		return totalDiscount;
	};
}
