package com.maven_project.pizzas;

import com.maven_project.pizzas.domain.Customer;

public interface OrderService {

	Order placeNewOrder(Customer customer, Integer... pizzasID);

}