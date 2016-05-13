package com.maven_project.pizzas.service.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.service.discount.DiscountService;
import com.maven_project.pizzas.service.pizza.PizzaService;

@Service(value="orderService")
public class SimpleOrderService implements OrderService {

	private static final int MAX_PIZZAS_NUMBER = 10;
	
	private OrderRepository orderRepository;
	private PizzaService pizzaService;
	private DiscountService discountService;
	
	@Autowired
	public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService,
			DiscountService discountService) {
		this.orderRepository = orderRepository;
		this.pizzaService = pizzaService;
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

		Map<Pizza, Integer> pizzas = findPizzas(pizzasID);

        Order newOrder = saveOrder(customer, pizzas);

        return newOrder;
	}
	
	private Map<Pizza, Integer> findPizzas(Integer ... pizzasID) {
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
	
	private Order saveOrder(Customer customer, Map<Pizza, Integer> pizzas) {
		Order newOrder = getOrder(customer, pizzas);

        long id = orderRepository.saveOrder(newOrder);
		newOrder.setId(id);
        
        return newOrder;
	}

	@Lookup(value = "order")
	protected Order getOrder(Customer customer, Map<Pizza, Integer> pizzas) {
		return new Order(customer, pizzas);
	}

	@Override
	public void proceedOrder(Order order) {
		order.proceedOrder();
	}

	@Override
	public boolean alterOrder(Order order, Map<Pizza, Integer> pizzas) {

		if (pizzas.size() > MAX_PIZZAS_NUMBER) {
			return false;
		}

		return order.changeOrder(pizzas);
	}

	@Override
	public void cancelOrder(Order order) {
		order.cancelOrder();
	}

	@Override
	public double countTotalCost(Order order) {
		double total = 0;
		
		for (Map.Entry<Pizza, Integer> entry : order.getPizzas().entrySet()) {
			total += (entry.getKey().getCost() * entry.getValue());
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

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}
}
