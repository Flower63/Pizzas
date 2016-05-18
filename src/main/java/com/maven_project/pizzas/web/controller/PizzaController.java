package com.maven_project.pizzas.web.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven_project.pizzas.Pizza;
import com.maven_project.pizzas.repository.pizza.PizzaRepository;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@RequestMapping(value="/pizza", method=RequestMethod.GET)
	@ResponseBody
	public String getPizzaById(@RequestParam("pizzaId") Integer id) {
		return pizzaRepository.getPizzaByID(id).toString();
	}
	
	@RequestMapping(value="/addNew", method=RequestMethod.POST)
	public String add(@ModelAttribute Pizza pizza) {
		System.out.println(pizza);
		pizzaRepository.savePizza(pizza);
		return "redirect:pizzas";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "newpizza";
	}
}
