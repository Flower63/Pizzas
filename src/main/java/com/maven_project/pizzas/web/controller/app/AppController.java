package com.maven_project.pizzas.web.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Flower
 *
 */
@Controller
public class AppController {
	@RequestMapping(value = "/")
	public String showMain() {
		return "main";
	}
}
