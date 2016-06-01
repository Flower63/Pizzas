package com.maven_project.pizzas.repository.pizza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer> {}
