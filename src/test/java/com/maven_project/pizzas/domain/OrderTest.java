package com.maven_project.pizzas.domain;

import junit.framework.TestCase;

import java.util.ArrayList;

public class OrderTest extends TestCase {

    public void testSetPizzas() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getPizzas() == null);

        assertTrue(order.setPizzas(new ArrayList<>()));

        assertFalse(order.getPizzas() == null);

        order.proceedOrder();

        assertFalse(order.setPizzas(null));

        assertFalse(order.getPizzas() == null);

        Order.discardCounter();
    }

    public void testProceedOrder() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getState() == Order.State.NEW);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.IN_PROGRESS);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.DONE);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.DONE);

        Order.discardCounter();
    }

    public void testCancelOrder() throws Exception {
        Order order = new Order(null, null);

        assertTrue(order.getState() == Order.State.NEW);

        order.cancelOrder();

        assertTrue(order.getState() == Order.State.CANCELED);

        order.proceedOrder();

        assertTrue(order.getState() == Order.State.CANCELED);

        Order.discardCounter();
    }
}