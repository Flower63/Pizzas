package com.maven_project.pizzas.service.order;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.InMemOrderRepository;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.InMemPizzaRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.discount.DiscountService;

public class SimpleOrderService implements OrderService {

	private static final int MAX_PIZZAS_NUMBER = 10;
	
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;
	private DiscountService discountService;
	
	public SimpleOrderService() {
		this.orderRepository = new InMemOrderRepository();
		this.pizzaRepository = new InMemPizzaRepository();
		this.discountService = new DiscountService();
	}
	
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository,
			DiscountService discountService) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
		this.discountService = discountService;
	}

	@Override
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
		
		// Temporally solution
		if (pizzasID.length > MAX_PIZZAS_NUMBER) {
			throw new IllegalArgumentException();
		}

        List<Pizza> pizzas = findPizzas(pizzasID);

        Order newOrder = saveOrder(customer, pizzas);

        return newOrder;
	}
	
	private List<Pizza> findPizzas(Integer ... pizzasID) {
		List<Pizza> pizzas = new ArrayList<>();

        for(Integer id : pizzasID) {
        	pizzas.add(pizzaRepository.getPizzaByID(id));
        }
        
        return pizzas;
	}
	
	private Order saveOrder(Customer customer, List<Pizza> pizzas) {
		Order newOrder = new Order(customer, pizzas);

        orderRepository.saveOrder(newOrder);
        
        return newOrder;
	}

	@Override
	public void proceedOrder(Order order) {
		order.proceedOrder();
	}

	@Override
	public boolean alterOrder(Order order, List<Pizza> pizzas) {

		if (pizzas.size() > MAX_PIZZAS_NUMBER) {
			return false;
		}

		return order.setPizzas(pizzas);
	}

	@Override
	public void cancelOrder(Order order) {
		order.cancelOrder();
	}

	@Override
	public double countTotalCost(Order order) {
		double total = 0;
		
		for (Pizza pizza : order.getPizzas()) {
			total += pizza.getCost();
		}
		
		return total;
	}

	@Override
	public double calculateDiscount(Order order) {
		return discountService.countDiscount(order);
	}
}
