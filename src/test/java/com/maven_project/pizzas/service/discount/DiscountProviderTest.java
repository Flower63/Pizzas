package com.maven_project.pizzas.service.discount;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.card.SimpleCardService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Denys
 *
 * on 4/11/2016.
 */
public class DiscountProviderTest {
    SimpleCardService cardService;
    Order order;

    @Before
    public void init() {
        cardService = mock(SimpleCardService.class);
        order = mock(Order.class);
    }

    @Test
    public void testPrepareDiscounts() throws Exception {
        DiscountProvider provider = new DiscountProvider(cardService);

        assertTrue(provider.getDiscounts(order).size() == 0);

        provider.prepareDiscounts();
        when(order.isDiscountsApplicable()).thenReturn(true);

        assertFalse(provider.getDiscounts(order).size() == 0);
    }

    @Test
    public void testGetDiscounts() throws Exception {
        DiscountProvider provider = new DiscountProvider(cardService);
        provider.prepareDiscounts();

        assertEquals(0, provider.getDiscounts(order).size());

        when(order.isDiscountsApplicable()).thenReturn(true);

        assertFalse(provider.getDiscounts(order).size() == 0);
    }
}