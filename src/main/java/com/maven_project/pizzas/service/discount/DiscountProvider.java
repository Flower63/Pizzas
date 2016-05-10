package com.maven_project.pizzas.service.discount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.card.SimpleCardService;

@Service(value="discountProvider")
public class DiscountProvider {
	private final List<Discount> discounts = new ArrayList<>();
	private final SimpleCardService cardService;
	
	@Autowired
	public DiscountProvider(SimpleCardService cardService) {
		this.cardService = cardService;
	}

	@PostConstruct
	public void prepareDiscounts() {
		discounts.add(new DiscountAccumulativeCard(cardService));
		discounts.add(new DiscountMostExpPizza());
	}
	
	public List<Discount> getDiscounts(Order order) {
		if (order.isDiscountsApplicable()) {
			return discounts;
		}

		return Collections.emptyList();
	}
}
