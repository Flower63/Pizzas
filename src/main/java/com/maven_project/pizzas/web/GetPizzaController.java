package com.maven_project.pizzas.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.maven_project.pizzas.repository.pizza.PizzaRepository;

@org.springframework.stereotype.Controller
public class GetPizzaController implements Controller {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			out.println(pizzaRepository.getPizzaByID(58));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
