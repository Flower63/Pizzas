package com.maven_project.pizzas.web.infrastructure;

import com.maven_project.pizzas.web.Controller;

public interface HandlerMapping {

	Controller getController(String controllerName);

}
