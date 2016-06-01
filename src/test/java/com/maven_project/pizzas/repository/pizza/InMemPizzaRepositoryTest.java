package com.maven_project.pizzas.repository.pizza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maven_project.pizzas.domain.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by Dennis
 *
 * on 5/7/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class InMemPizzaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Test
    public void savePizza() throws Exception {
        Pizza pizza = new Pizza();
        pizza.setName("Test pizza");
        pizza.setType(Pizza.Type.REGULAR);
        pizza.setCost(200.5);

        assertNotNull(pizzaRepository.save(pizza));

        System.out.println(pizza);
    }

    @Test
    public void getPizzaByID() throws Exception {
        Pizza pizza = new Pizza();
        pizza.setName("Test pizza");
        pizza.setType(Pizza.Type.REGULAR);
        pizza.setCost(200.5);

        assertNotNull(pizzaRepository.save(pizza));

        Pizza pizza2 = pizzaRepository.findOne(pizza.getPizzaId());
        System.out.println(pizza2);
    }

    @Test
    public void deletePizza() throws Exception {

    }

    @Test
    public void updatePizza() throws Exception {

    }

}