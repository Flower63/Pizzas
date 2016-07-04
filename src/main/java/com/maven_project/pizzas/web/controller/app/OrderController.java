package com.maven_project.pizzas.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.AddressService;
import com.maven_project.pizzas.service.CustomerService;
import com.maven_project.pizzas.service.OrderService;
import com.maven_project.pizzas.service.PizzaService;

@RequestMapping(value = "/order")
@Controller
public class OrderController {

	private final OrderService orderService;
	private final PizzaService pizzaService;
	private final CustomerService customerService;
	private final AddressService addressService;

	@Autowired
	public OrderController(OrderService orderService, 
						   PizzaService pizzaService, 
						   CustomerService customerService,
						   AddressService addressService) {
		this.orderService = orderService;
		this.pizzaService = pizzaService;
		this.customerService = customerService;
		this.addressService = addressService;
	}

	@RequestMapping(value = "/new")
	public ModelAndView createOrder() {
		ModelAndView result = new ModelAndView();
		Iterable<Pizza> pizzas = pizzaService.getAll();

		result.addObject("pizzas", pizzas);
		result.setViewName("order");

		return result;
	}

	@RequestMapping(value = "/add_to_cart")
	public ModelAndView save(@RequestParam Integer pizzaId, HttpSession session) {
		List<Integer> shoppingList = (List<Integer>) session.getAttribute("shoppingList");

		if (shoppingList == null) {
			shoppingList = new ArrayList<>();
			session.setAttribute("shoppingList", shoppingList);
		}

		shoppingList.add(pizzaId);
		//session.setAttribute("shoppingList", shoppingList);

		return createOrder();
	}

	@RequestMapping(value = "/remove_from_cart")
	public ModelAndView remove(@RequestParam Integer pizzaId, HttpSession session, Principal principal) {
		List<Integer> shoppingList = (List<Integer>) session.getAttribute("shoppingList");

		shoppingList.remove(pizzaId);
		//session.setAttribute("shoppingList", shoppingList);

		return shoppingCart(session, principal);
	}

	@RequestMapping(value = "/shopping_cart")
	public ModelAndView shoppingCart(HttpSession session, Principal principal) {
		ModelAndView result = new ModelAndView();
		List<Pizza> pizzas = new ArrayList<>();
		List<Integer> shoppingList = (List<Integer>) session.getAttribute("shoppingList");
		Customer customer = customerService.findCustomer(principal.getName());

		if (shoppingList != null) {
			for (Integer id : shoppingList) {
				pizzas.add(pizzaService.getPizzaByID(id));
			}
		}

		result.addObject("pizzas", pizzas);
		result.addObject("addresses", customer.getAddresses());
		result.setViewName("cart");

		return result;
	}
	
	@RequestMapping(value = "/place_order")
	public ModelAndView placeOrder(@RequestParam Integer addressId, Principal principal
									, HttpSession session) {
		ModelAndView result = new ModelAndView();
		Address address = addressService.findAddress(addressId);
		Customer customer = customerService.findCustomer(principal.getName());
		List<Integer> shoppingList = (List<Integer>) session.getAttribute("shoppingList");
		
		Order order = orderService.placeNewOrder(customer, shoppingList, address);
		
		result.addObject("order", order);
		result.setViewName("order_success");
		
		return result;
	}
}
