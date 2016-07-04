package com.maven_project.pizzas.service.address;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.repository.AddressRepository;
import com.maven_project.pizzas.service.AddressService;
import com.maven_project.pizzas.service.impl.SimpleAddressService;

public class SimpleAddressServiceTest {
	
	private AddressRepository addressRepository;
	private AddressService addressService;
	
	@Before
	public void makeAddressService() {
		addressRepository = mock(AddressRepository.class);
		
		addressService = new SimpleAddressService(addressRepository);
	}

	@Test
	public void testFindAddress() {
		addressService.findAddress(5);
		
		verify(addressRepository).findOne(5);
	}

	@Test
	public void testSaveAddress() {
		Address address = new Address();
		
		addressService.saveAddress(address);
		
		verify(addressRepository).save(address);
	}

	@Test
	public void testUpdateAddress() {
		Address address = new Address();
		
		addressService.saveAddress(address);
		
		verify(addressRepository).save(address);
	}

	@Test
	public void testDeleteAddress() {
		Address address = new Address();
		
		addressService.deleteAddress(address);
		
		verify(addressRepository).delete(address);
	}

}
