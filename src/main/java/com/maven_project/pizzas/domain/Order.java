package com.maven_project.pizzas.domain;

import java.util.List;

public class Order {
	
	private static long counter;
	
	private Long id;
	private Customer customer;
	private List<Pizza> pizzas;
	private State state;

	public Order(Customer customer, List<Pizza> pizzas) {
		this.customer = customer;
		this.pizzas = pizzas;
		this.state = State.NEW;
		this.id = ++counter;
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
	
	public static enum State {
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
}
