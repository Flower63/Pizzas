package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;

public interface Discount {
	double countDiscount(Order order);
}
