package com.maven_project.pizzas.repository.customer;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.repository.AddressRepository;
import com.maven_project.pizzas.repository.CustomerRepository;

import org.hibernate.annotations.Table;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class JpaCustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Customer customer;

    @Before
    public void makeCustomer() {
        Address address = new Address("City", "Street", "Apprtmnt");

        addressRepository.save(address);

        customer = new Customer("Sergey", Arrays.asList(address));
    }

    @Test
    public void findCustomer() throws Exception {
        customerRepository.save(customer);

        assertNotNull(customerRepository.findOne(customer.getCustomerId()));
    }

    @Test
    public void saveCustomer() throws Exception {
        assertNull(customer.getCustomerId());

        customerRepository.save(customer);

        assertNotNull(customer.getCustomerId());
    }

    @Test
    public void updateCustomer() throws Exception {
        customerRepository.save(customer);

        customer.setName("Andrey");

        customerRepository.save(customer);

        Customer temp = customerRepository.findOne(customer.getCustomerId());

        assertEquals("Andrey", temp.getName());
    }

    @Test
    public void deleteCustomer() throws Exception {
        customerRepository.save(customer);

        assertNotNull(customerRepository.findOne(customer.getCustomerId()));

        customerRepository.delete(customer);

        assertNull(customerRepository.findOne(customer.getCustomerId()));
    }

    @Test
    public void getCustomerAddress() {
        customerRepository.save(customer);

        Customer temp = customerRepository.findOne(customer.getCustomerId());

        assertEquals(1, temp.getAddresses().size());

        Object address = temp.getAddresses().get(0);

        assertTrue(address instanceof Address);
    }
}