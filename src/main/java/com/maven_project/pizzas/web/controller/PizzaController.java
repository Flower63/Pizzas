package com.maven_project.pizzas.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;
import com.maven_project.pizzas.rest.PizzaResource;
import com.maven_project.pizzas.rest.asm.PizzaResourceAssembler;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
//	@Autowired
//	private ConversionService conversionService;
	
	@Autowired
	private PizzaResourceAssembler pizzaAssembler;
	
	@Secured(value = "ABC")
	@RequestMapping(value="/pizza", method=RequestMethod.GET)
	@ResponseBody
	public String getPizzaById(@RequestParam("pizzaId") Integer id) {
		return pizzaRepository.findOne(id).toString();
	}
	
	@RequestMapping(value="/")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value="/addNew", method=RequestMethod.POST)
	public String add(@ModelAttribute Pizza pizza) {
		System.out.println(pizza);
		pizzaRepository.save(pizza);
		return "redirect:pizzas";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "newpizza";
	}
	
	@Secured(value = "ROLE_USER")
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public ModelAndView showPizzas() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(auth.getName());
		
		ModelAndView result = new ModelAndView();
		
		result.setViewName("pizzas");
		
		result.addObject("pizzas", pizzaRepository.findAll());
		
		return result;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public /*ResponseEntity<*/List<PizzaResource>/*>*/ allPizzas() {
		
		List<PizzaResource> resources = pizzaAssembler.toResources(pizzaRepository.findAll());
		
		//return new ResponseEntity<List<PizzaResource>>(resources, HttpStatus.OK);
		return resources;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		SecurityContext context = SecurityContextHolder.getContext();
		
		context.setAuthentication(null);
		
		//SecurityContextHolder.clearContext();
		
		//request.getSession(false).invalidate();
//	    Cookie[] cookies = request.getCookies();
//	    
//	    for(Cookie c : cookies) {
//	    	c.setMaxAge(0);
//	    	response.addCookie(c);
//	    }
		request.logout();
		
		new SecurityContextLogoutHandler().logout(request, response, auth);
		new CookieClearingLogoutHandler("JSESSIONID").logout(request, response, auth);
		
//		auth.setAuthenticated(false);
//		System.out.println(auth.isAuthenticated());
		
		return "index";
	}
}
