package com.maven_project.pizzas.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

import javax.persistence.*;

@Component(value = "order")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Entity(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	private Customer customer;

	@ElementCollection
	@CollectionTable(name = "ORDER_PIZZAS")
	@MapKeyJoinColumn(name = "PIZZA_ID")
	private Map<Pizza, Integer> pizzas;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "ORDER_STATE")
	private State state;

	@ManyToOne
	private Address address;

	private Boolean isDiscountsApplicable;

	private Double price;

	private Double discount;

	@Autowired
	public Order(Customer customer, Map<Pizza, Integer> pizzas, Address address) {
		this.customer = customer;
		this.pizzas = pizzas;
		this.state = State.NEW;
		this.isDiscountsApplicable = true;
		this.address = address;
	}

	public Order() {
		this.state = State.NEW;
		this.isDiscountsApplicable = false;
	}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Map<Pizza, Integer> getPizzas() {
		return pizzas;
	}

	public State getState() {
		return state;
	}

	public State proceedOrder() {
		this.state = state.nextState();
		return state;
	}

	public State cancelOrder() {
		this.state = state.cancel();
		return state;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Order id = ");
		result.append(id);
		result.append(" For ");
		result.append(customer.getName());
		result.append(" { ");

		for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
			result.append(entry.getKey().toString());
			result.append(" ");
			result.append(entry.getValue());
		}

		result.append(" } ");

		return result.toString();
	}

	public Boolean isDiscountsApplicable() {
		return isDiscountsApplicable;
	}

	public void setDiscountsApplicable(boolean discountsApplicable) {
		isDiscountsApplicable = discountsApplicable;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPizzas(Map<Pizza, Integer> pizzas) {
		this.pizzas = pizzas;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getPizzasCount() {
		int res = 0;

		for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
			res += entry.getValue();
		}

		return res;
	}

	public enum State {
		NEW {

			public State nextState() {
				return IN_PROGRESS;
			}
		},
		IN_PROGRESS {

			public State nextState() {
				return DONE;
			}
		},
		DONE {

			public State nextState() {
				return DONE;
			}

			public State cancel() {
				return DONE;
			}
		},
		CANCELED {

			public State nextState() {
				return CANCELED;
			}
		};

		public State nextState() {
			return null;
		}

		public State cancel() {
			return CANCELED;
		}
	}
}
