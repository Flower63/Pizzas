package com.maven_project.pizzas.web.utils.security;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class PizzaServiceAuthentication implements AuthenticationProvider {
	
	private final CustomerService customerService;

	@Autowired
	public PizzaServiceAuthentication(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		Customer customer = customerService.findCustomer(email);
		
		if (customer == null || !password.equals(customer.getPassword())) {
			return null;
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(customer.getRole()));
		
		return new UsernamePasswordAuthenticationToken(email, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
