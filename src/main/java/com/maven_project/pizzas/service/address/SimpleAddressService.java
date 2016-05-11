package com.maven_project.pizzas.service.address;

import com.maven_project.pizzas.domain.Address;
import com.maven_project.pizzas.repository.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dennis
 *
 * on 5/11/2016.
 */
@Service("addressService")
public class SimpleAddressService implements AddressService {

    private AddressRepository repository;

    @Autowired
    public SimpleAddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address findAddress(Integer id) {
        return repository.findAddress(id);
    }

    @Override
    public Integer saveAddress(Address address) {
        return repository.saveAddress(address);
    }

    @Override
    public boolean updateAddress(Address address) {
        return repository.updateAddress(address);
    }

    @Override
    public boolean deleteAddress(Address address) {
        return repository.deleteAddress(address);
    }
}
