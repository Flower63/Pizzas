package com.maven_project.pizzas.ifrastructure;

public interface ApplicationContext {
	Object getBean(String bean) throws Exception;
}
