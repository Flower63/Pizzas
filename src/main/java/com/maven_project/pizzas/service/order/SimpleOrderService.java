package com.maven_project.pizzas.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.service.discount.DiscountService;

@Service(value="orderService")
public class SimpleOrderService implements OrderService {

	private static final int MAX_PIZZAS_NUMBER = 10;
	
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;
	private DiscountService discountService;
	
	@Autowired
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository,
			DiscountService discountService) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
		this.discountService = discountService;
	}

	@Override
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer cannot be null");
		}
		
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
		Order newOrder = getOrder(customer, pizzas);

        orderRepository.saveOrder(newOrder);
        
        return newOrder;
	}

	@Lookup(value = "order")
	protected Order getOrder(Customer customer, List<Pizza> pizzas) {
		//return new Order(customer, pizzas);
		return null;
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

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void setPizzaRepository(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}
}
