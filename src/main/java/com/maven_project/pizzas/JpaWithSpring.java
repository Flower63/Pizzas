package com.maven_project.pizzas;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dennis
 *
 * on 5/4/2016.
 */
public class JpaWithSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryPostgresContext.xml");

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, false);

        appContext.setParent(repositoryContext);
        appContext.refresh();

        PizzaRepository pizzaRepository = (PizzaRepository) appContext.getBean("pizzaRepository");

        Pizza p = pizzaRepository.getPizzaByID(58);

        System.out.println(p);

        Pizza newPizza = new Pizza();
        newPizza.setName("New pizza");
        newPizza.setCost(15.5);
        newPizza.setType(Pizza.Type.VEGETERIAN);

        int id = pizzaRepository.savePizza(newPizza);

        System.out.println(id);

        pizzaRepository.deletePizza(newPizza);
    }
}
