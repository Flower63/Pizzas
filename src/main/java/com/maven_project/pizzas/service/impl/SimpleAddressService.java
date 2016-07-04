package com.maven_project.pizzas.service.impl;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.repository.AddressRepository;
import com.maven_project.pizzas.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dennis
 *
 * on 5/11/2016.
 */
@Service
public class SimpleAddressService implements AddressService {

    private AddressRepository repository;

    @Autowired
    public SimpleAddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address findAddress(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Integer saveAddress(Address address) {
        return repository.save(address).getId();
    }

    @Override
    public boolean deleteAddress(Address address) {
        repository.delete(address);
        
        return true;
    }
}
