package com.maven_project.pizzas.web.controller.rest;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.rest.PizzaResource;
import com.maven_project.pizzas.rest.asm.PizzaResourceAssembler;

@RestController
@RequestMapping(value = "/pizza/")
public class RestPizzaController {
	
	private final PizzaRepository pizzaRepository;
	private final PizzaResourceAssembler pizzaResourceAssembler;
	
	@Autowired
	public RestPizzaController(PizzaRepository pizzaRepository, PizzaResourceAssembler pizzaResourceAssembler) {
		this.pizzaRepository = pizzaRepository;
		this.pizzaResourceAssembler = pizzaResourceAssembler;
	}
	
	@RequestMapping(value = "/user")
	public Principal getUser(Principal principal) {
		return principal;
	}
	
	//@Secured("USER")
	@RequestMapping(value = "/token")
	public CsrfToken csrf(CsrfToken token) {
		return token;
	}
	
	@RequestMapping(value = "{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public ResponseEntity<PizzaResource> getPizzaById(@PathVariable Integer id) {
		Pizza pizza = pizzaRepository.findOne(id);
		
		if (pizza == null) {
			return new ResponseEntity<PizzaResource>(HttpStatus.NOT_FOUND);
		}
		
		PizzaResource pr = pizzaResourceAssembler.toResource(pizza);
		
		return new ResponseEntity<PizzaResource>(pr, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<PizzaResource>> allPizzas(CsrfToken token, UriComponentsBuilder builder) {
		
		List<PizzaResource> resources = pizzaResourceAssembler.toResources(pizzaRepository.findAll());
		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/pizza/save")
//							.buildAndExpand(savedPizza.getPizzaId())
//							.toUri());
//		headers.set("_csrf", token);
		
		System.out.println(token.getToken());
		
		return new ResponseEntity<List<PizzaResource>>(resources, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, 
			consumes = "application/json")
	public ResponseEntity<Void> add(@RequestBody Pizza pizza, UriComponentsBuilder builder) {
		Pizza savedPizza = pizzaRepository.save(pizza);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/pizza/save")
							.buildAndExpand(savedPizza.getPizzaId())
							.toUri());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/error")
	public ResponseEntity<String> error() {
		return new ResponseEntity<>("Unauthorised", HttpStatus.I_AM_A_TEAPOT);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    
	    
	    return "logging out...";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
