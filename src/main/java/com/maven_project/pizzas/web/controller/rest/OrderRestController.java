package com.maven_project.pizzas.web.controller.rest;

import com.maven_project.pizzas.service.OrderService;
import com.maven_project.pizzas.web.utils.resource.OrderDtoResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Denys Zvarych
 *
 */
@RestController
@RequestMapping(value = "/order")
public class OrderRestController {
	
	private final OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<OrderDtoResource>> getAll() {
		return null;
	}
}
