package com.maven_project.pizzas.repository.address;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.repository.AddressRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Dennis
 *
 * on 5/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:repositoryH2Context.xml"})
public class JpaAddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    private Address address;

    @Before
    public void makeAddress() {
        address = new Address("City", "Street", "Apprtmnt");
    }

    @Test
    public void findAddress() throws Exception {
        addressRepository.save(address);

        assertNotNull(addressRepository.findOne(address.getId()));
    }

    @Test
    public void saveAddress() throws Exception {
        assertNull(address.getId());

        addressRepository.save(address);

        assertNotNull(address.getId());

        assertNotNull(addressRepository.findOne(address.getId()));
    }

    @Test
    public void updateAddress() throws Exception {
        addressRepository.save(address);

        address.setCity("New York");

        addressRepository.save(address);

        Address temp = addressRepository.findOne(address.getId());

        assertEquals("New York", temp.getCity());
    }

    @Test
    public void deleteAddress() throws Exception {
        addressRepository.save(address);

        assertNotNull(addressRepository.findOne(address.getId()));

        addressRepository.delete(address);

        assertNull(addressRepository.findOne(address.getId()));
    }

}