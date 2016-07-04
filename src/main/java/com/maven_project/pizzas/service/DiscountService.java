package com.maven_project.pizzas.service;

import com.maven_project.pizzas.domain.Order;

/**
 * @author Flower
 *
 */
public interface DiscountService {
	double countDiscount(Order order);
}
