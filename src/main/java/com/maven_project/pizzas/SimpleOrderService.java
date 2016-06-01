package com.maven_project.pizzas;

import java.util.ArrayList;
import java.util.List;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.ifrastructure.Benchmark;
import com.maven_project.pizzas.repository.order.OrderRepository;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

public class SimpleOrderService implements OrderService 
// ApplicationContextAware
{
	
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;
	//private ApplicationContext appContext;
	private Customer customer;
	
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
	}

	//@Benchmark
	@Override
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {

        List<Pizza> pizzas = new ArrayList<>();

        for(Integer id : pizzasID) {
        	pizzas.add(pizzaRepository.findOne(id));  // get Pizza from predifined in-memory list
        }

        Order newOrder = createOrder();
        newOrder.setCustomer(customer);
        newOrder.setPizzas(pizzas);

        //orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list

        return newOrder;

	}

	protected Order createOrder()  {
		//return new Order(customer, pizzas);
//		Order order = (Order) appContext.getBean("order");
//		return order;
		return null;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public void setAppContext(ApplicationContext appContext) {
//		this.appContext = appContext;
//	}

//	@Override
//	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
//		this.appContext = appContext;
//	}
	
	
}
