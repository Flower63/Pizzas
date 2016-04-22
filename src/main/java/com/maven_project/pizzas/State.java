package com.maven_project.pizzas;

public class State {
	public final String stateString;

	public State(String stateString) {
		this.stateString = stateString;
	}

	public State() {
		this.stateString = "default state";
	}
}