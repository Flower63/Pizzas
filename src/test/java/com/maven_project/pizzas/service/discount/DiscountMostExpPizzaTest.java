package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.card.SimpleCardService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Denys
 *
 * on 4/11/2016.
 */
public class DiscountMostExpPizzaTest {

    private static final double DELTA = 1e-15;

    private Customer customer;
    private Pizza simplePizza;
    private Discount discount;

    @Before
    public void init() {
        customer = mock(Customer.class);
        simplePizza = mock(Pizza.class);
        discount = new DiscountMostExpPizza();

        when(simplePizza.getCost()).thenReturn(10D);
    }

    @Test
    public void testCountDiscountFourPizzas() throws Exception {
        Map<Pizza, Integer> pizzas = new HashMap<>();
        pizzas.put(simplePizza, 4);

        //Order order = new Order(customer, Arrays.asList(simplePizza, simplePizza, simplePizza, simplePizza));
        Order order = new Order(customer, pizzas);

        // Not more than 4 pizzas, no accumulative card
        double totalDiscount = discount.countDiscount(order);

        assertEquals(0, totalDiscount, DELTA);
    }

    @Test
    public void testCountDiscountFivePizzas() throws Exception {
        Pizza expensivePizza = mock(Pizza.class);
        when(expensivePizza.getCost()).thenReturn(100D);

        Map<Pizza, Integer> pizzas = new HashMap<>();
        pizzas.put(simplePizza, 4);
        pizzas.put(expensivePizza, 1);

        //Order order = new Order(customer, Arrays.asList(simplePizza, simplePizza, simplePizza, simplePizza, expensivePizza));
        Order order = new Order(customer, pizzas);

        // More than 4 pizzas, discount 30% for most expensive pizza, no accumulative card
        double totalDiscount = discount.countDiscount(order);

        assertEquals(30, totalDiscount, DELTA);
    }
}