package com.maven_project.pizzas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.OrderRepository;
import com.maven_project.pizzas.service.OrderService;
import com.maven_project.pizzas.service.PizzaService;

@Service //(value="orderService")
public class SimpleOrderService implements OrderService {

	private static final int MAX_PIZZAS_NUMBER = 10;
	
	private OrderRepository orderRepository;
	private PizzaService pizzaService;
	private SimpleDiscountService discountService;
	
	@Autowired
	public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService,
			SimpleDiscountService discountService) {
		this.orderRepository = orderRepository;
		this.pizzaService = pizzaService;
		this.discountService = discountService;
	}

	@Override
	public Order placeNewOrder(Customer customer, List<Integer> pizzasID, Address address) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer cannot be null");
		}
		
		// Temporally solution
		if (pizzasID.size() > MAX_PIZZAS_NUMBER) {
			throw new IllegalArgumentException();
		}

		Map<Pizza, Integer> pizzas = findPizzas(pizzasID);

        Order newOrder = saveOrder(customer, pizzas, address);

        return newOrder;
	}
	
	private Map<Pizza, Integer> findPizzas(List<Integer> pizzasID) {
		Map<Pizza, Integer> pizzas = new HashMap<>();

        for(Integer id : pizzasID) {
			Pizza pizza = pizzaService.getPizzaByID(id);
			if (pizza == null) {
				continue;
			}

			if (pizzas.containsKey(pizza)) {
				int quantity = pizzas.get(pizza);
				pizzas.put(pizza, ++quantity);
			} else {
				pizzas.put(pizza, 1);
			}
        }
        
        return pizzas;
	}
	
	private Order saveOrder(Customer customer, Map<Pizza, Integer> pizzas, Address address) {
		Order newOrder = new Order(customer, pizzas, address);
        
        return orderRepository.save(newOrder);
	}

	@Override
	public void proceedOrder(Order order) {
		order.proceedOrder();
		
		orderRepository.save(order);
	}

	@Override
	public boolean alterOrder(Order order, Map<Pizza, Integer> pizzas) {
		if (order.getState() != Order.State.NEW) {
			return false;
		}
		
		order.setPizzas(pizzas);
		orderRepository.save(order);
		
		return true;
	}

	@Override
	public void cancelOrder(Order order) {
		order.cancelOrder();
		
		orderRepository.save(order);
	}

	@Override
	public double countTotalCost(Order order) {
		double total = 0;
		
		for (Map.Entry<Pizza, Integer> entry : order.getPizzas().entrySet()) {
			total += (entry.getKey().getPrice() * entry.getValue());
		}
		
		return total;
	}

	@Override
	public double calculateDiscount(Order order) {
		return discountService.countDiscount(order);
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void setPizzaService(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	public void setDiscountService(SimpleDiscountService discountService) {
		this.discountService = discountService;
	}
}
