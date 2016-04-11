package com.maven_project.pizzas.service.discount;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import com.maven_project.pizzas.domain.Order;

import junit.framework.TestCase;

/**
 * Created by Dennis on 4/6/2016.
 */
public class DiscountServiceTest extends TestCase {

    public void testCountDiscount() throws Exception {
    	Discount fakeDiscount = mock(Discount.class);
    	
    	when(fakeDiscount.countDiscount(any(Order.class))).thenReturn(1d);
    	
    	DiscountProvider provider = mock(DiscountProvider.class);
    	
    	when(provider.getDiscounts(any(Order.class))).thenReturn(Arrays.asList(fakeDiscount, fakeDiscount));
    	
    	DiscountService service = new DiscountService(provider);
    	
    	assertEquals(2.0, service.countDiscount(new Order(null, null)));
    }
}