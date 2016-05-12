package com.maven_project.pizzas.repository.address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven_project.pizzas.domain.Address;

@Repository("addressRepository")
@Transactional
public class JpaAddressRepository implements AddressRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Address findAddress(Integer id) {
		return manager.find(Address.class, id);
	}

	@Override
	public Integer saveAddress(Address address) {
		manager.persist(address);
		
		return address.getId();
	}

	@Override
	public boolean updateAddress(Address address) {
		Address temp = manager.find(Address.class, address.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.merge(address);
		
		return true;
	}

	@Override
	public boolean deleteAddress(Address address) {
		Address temp = manager.find(Address.class, address.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.remove(temp);
		
		return true;
	}

}
