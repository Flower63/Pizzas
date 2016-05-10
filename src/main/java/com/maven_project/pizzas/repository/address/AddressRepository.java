package com.maven_project.pizzas.repository.address;

import com.maven_project.pizzas.domain.Address;

public interface AddressRepository {
	Address findAddress(Integer id);
	
	Integer saveAddress(Address address);
	
	boolean updateAddress(Address address);
	
	boolean deleteAddress(Address address);
}
