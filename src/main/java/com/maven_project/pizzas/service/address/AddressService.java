package com.maven_project.pizzas.service.address;

import com.maven_project.pizzas.domain.Address;

/**
 * Created by Dennis
 *
 * on 5/11/2016.
 */
public interface AddressService {
    Address findAddress(Integer id);

    Integer saveAddress(Address address);

    boolean updateAddress(Address address);

    boolean deleteAddress(Address address);
}
