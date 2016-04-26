package com.maven_project.pizzas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	private Customer customer;
	//@ElementCollection(Pizza.class)
	@Transient
	private List<Pizza> pizzas;
	@ElementCollection
	@CollectionTable(name = "order_pizzas")
	@MapKeyJoinColumn(name = "ord_id")
	//@MapKeyClass(Pizza.class)
	//@ManyToMany
	//@JoinTable(name = "order_pizzas")
	//@Transient
	private Map<Pizza, Integer> orders;
	/* TODO add date */
	/* TODO add address */

	public Order(Customer customer, List<Pizza> pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
		this.orders = new HashMap<>();
		fillMap(pizzas);
	}
	
	public Order() {}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	@Override
	public String toString() {
		return "Order with pizzas";
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	private void fillMap(List<Pizza> pizzas) {
		for (Pizza p : pizzas) {
			if (orders.containsKey(p)) {
				int quantity = orders.get(p);
				orders.put(p, ++quantity);
			} else {
				orders.put(p, 1);
			}
		}
	}

	public Map<Pizza, Integer> getOrders() {
		return orders;
	}

	public void setOrders(Map<Pizza, Integer> orders) {
		this.orders = orders;
	}
}
