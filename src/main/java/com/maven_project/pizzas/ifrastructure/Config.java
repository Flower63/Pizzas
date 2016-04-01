package com.maven_project.pizzas.ifrastructure;

public interface Config {
	Class<?> getImpl(String bean);
}
