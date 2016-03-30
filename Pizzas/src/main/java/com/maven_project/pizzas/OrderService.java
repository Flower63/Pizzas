package com.maven_project.pizzas;

public interface OrderService {

	Order placeNewOrder(Customer customer, Integer... pizzasID);

}