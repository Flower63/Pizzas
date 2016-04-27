package com.maven_project.pizzas.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    @Test
    public void testSetPizzas() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getPizzas() == null);

        assertTrue(order.changeOrder(new HashMap<>()));

        assertFalse(order.getPizzas() == null);

        order.proceedOrder();

        assertFalse(order.changeOrder(null));

        assertFalse(order.getPizzas() == null);
    }

    @Test
    public void testProceedOrder() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getState() == Order.State.NEW);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.IN_PROGRESS);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.DONE);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.DONE);
    }

    @Test
    public void testCancelOrder() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getState() == Order.State.NEW);

        order.cancelOrder();

        assertTrue(order.getState() == Order.State.CANCELED);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.CANCELED);
    }
}