package com.maven_project.pizzas.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "order")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Order {
	
	private static long counter;
	
	private Long id;
	private Customer customer;
	private List<Pizza> pizzas;
	private State state;
	private boolean isDiscountsApplicable;

	@Autowired
	public Order(Customer customer, List<Pizza> pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
		this.state = State.NEW;
		this.id = ++counter;
		this.isDiscountsApplicable = true;
	}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}
	
	public boolean setPizzas(List<Pizza> pizzas) {
		if (this.state == State.NEW) {
			this.pizzas = pizzas;
			return true;
		}
		
		return false;
	}

	public State getState() {
		return state;
	}
	
	public void proceedOrder() {
		this.state = state.nextState();
	}
	
	public void cancelOrder() {
		this.state = state.cancel();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Order id = ");
		result.append(id);
		result.append(" For ");
		result.append(customer.getName());
		result.append(" { ");
		
		for (Pizza pizza : pizzas) {
			result.append(pizza.toString());
		}
		
		result.append(" } ");
		
		return result.toString();
	}

	public boolean isDiscountsApplicable() {
		return isDiscountsApplicable;
	}

	public void setDiscountsApplicable(boolean discountsApplicable) {
		isDiscountsApplicable = discountsApplicable;
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
		}, DONE {
			public State nextState() {
				return DONE;
			}
			
			public State cancel() {
				return DONE;
			}
		}, CANCELED {
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

	static void discardCounter() {
		counter = 0;
	}
}
