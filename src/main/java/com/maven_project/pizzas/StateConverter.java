package com.maven_project.pizzas;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StateConverter implements AttributeConverter<State, String> {

	@Override
	public String convertToDatabaseColumn(State state) {
		return state.stateString;
	}

	@Override
	public State convertToEntityAttribute(String str) {
		return new State(str);
	}
}
