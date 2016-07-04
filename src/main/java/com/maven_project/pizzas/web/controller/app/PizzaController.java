package com.maven_project.pizzas.web.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maven_project.pizzas.domain.Pizza;
import com.maven_project.pizzas.service.PizzaService;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {
	
	private final PizzaService pizzaService;

	@Autowired
	public PizzaController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}
	
	@RequestMapping(value = "/")
	public String showMain() {
		return "main";
	}
	
	@RequestMapping(value = "/all")
	public ModelAndView showAll() {
		ModelAndView result = new ModelAndView();
		
		Iterable<Pizza> pizzas = pizzaService.getAll();
		
		result.addObject("pizzas", pizzas);
		result.setViewName("all");
		
		return result;
	}
	
	@RequestMapping(value = "/new")
	public ModelAndView addNew() {
		ModelAndView result = new ModelAndView();
		
		result.addObject("types", Pizza.Type.values());
		result.setViewName("pizza");
		
		return result;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView edit(@RequestParam Integer id) {
		Pizza pizza = pizzaService.getPizzaByID(id);
		ModelAndView result = new ModelAndView();
		
		result.addObject("pizza", pizza);
		result.addObject("types", Pizza.Type.values());
		result.setViewName("pizza");
		
		return result;
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView delete(@RequestParam Integer id) {
		pizzaService.deletePizza(id);
		
		return showAll();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Pizza pizza) {
		if (pizza != null) {
			pizzaService.savePizza(pizza);
		}
		
		return showAll();
	}
}
