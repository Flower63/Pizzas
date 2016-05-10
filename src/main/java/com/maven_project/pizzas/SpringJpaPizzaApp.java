package com.maven_project.pizzas;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJpaPizzaApp {
	public static void main(String... args) {
		ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryPostgresContext.xml");

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, false);

        appContext.setParent(repositoryContext);
        appContext.refresh();
	}
}
