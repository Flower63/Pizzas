package com.maven_project.pizzas.service.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Order;

@Service(value="discountService")
public class DiscountService {
	
	private final DiscountProvider provider;
	
	@Autowired
	public DiscountService(DiscountProvider provider) {
		this.provider = provider;
	}

	public double countDiscount(Order order) {
		List<Discount> discounts = provider.getDiscounts(order);
		
		double totalDiscount = 0;
		
		for (Discount d : discounts) {
			totalDiscount += d.countDiscount(order);
		}
		
		return totalDiscount;
	};
}
