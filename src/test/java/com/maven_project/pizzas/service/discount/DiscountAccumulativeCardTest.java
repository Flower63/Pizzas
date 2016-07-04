package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.AccumulativeCard;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.impl.SimpleCardService;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Denys
 *
 * on 4/11/2016.
 */
public class DiscountAccumulativeCardTest {

    private static final double DELTA = 1e-15;

    private SimpleCardService cardService;
    private Customer customer;
    private Pizza simplePizza;
    private DiscountAccumulativeCard discount;

    @Before
    public void init() {
        cardService = mock(SimpleCardService.class);
        customer = mock(Customer.class);
        simplePizza = mock(Pizza.class);
        discount = new DiscountAccumulativeCard(cardService);

        when(simplePizza.getPrice()).thenReturn(10D);
    }

    @Test
    public void testCountDiscountNoCard() throws Exception {

        Map<Pizza, Integer> pizzas = new HashMap<>();
        pizzas.put(simplePizza, 4);

        //Order order = new Order(customer, Arrays.asList(simplePizza, simplePizza, simplePizza, simplePizza));
        Order order = new Order(customer, pizzas, null);

        // Not more than 4 pizzas, no accumulative card
        double totalDiscount = discount.countDiscount(order);

        assertEquals(0, totalDiscount, DELTA);
    }

    @Test
    public void testCountDiscountFivePizzasNoCard() throws Exception {
        Pizza expensivePizza = mock(Pizza.class);
        when(expensivePizza.getPrice()).thenReturn(100D);

        Map<Pizza, Integer> pizzas = new HashMap<>();
        pizzas.put(simplePizza, 4);
        pizzas.put(expensivePizza, 1);

        //Order order = new Order(customer, Arrays.asList(simplePizza, simplePizza, simplePizza, simplePizza, expensivePizza));
        Order order = new Order(customer, pizzas, null);

        // More than 4 pizzas, no accumulative card
        double totalDiscount = discount.countDiscount(order);

        assertEquals(0, totalDiscount, DELTA);
    }

    @Test
    public void testCountDiscountFivePizzasWithCard() throws Exception {
        AccumulativeCard card = new AccumulativeCard();
        card.setTotalAmount(100);

        when(cardService.findCardByCustomer(any(Customer.class))).thenReturn(card);

        Pizza expensivePizza = mock(Pizza.class);
        when(expensivePizza.getPrice()).thenReturn(100D);

        Map<Pizza, Integer> pizzas = new HashMap<>();
        pizzas.put(simplePizza, 4);
        pizzas.put(expensivePizza, 1);

        Order order = new Order(customer, pizzas, null);

        // More than 4 pizzas, with accumulative card
        double totalDiscount = discount.countDiscount(order);

        // Must be 10% of card amount
        assertEquals(10, totalDiscount, DELTA);

        card.setTotalAmount(1000);

        totalDiscount = discount.countDiscount(order);

        // Must not be 10% of card amount, because it's more than 30% of order price
        assertNotEquals(100, totalDiscount, DELTA);

        // Must be 30% of order price
        assertEquals(42, totalDiscount, DELTA);
    }
}