package com.maven_project.pizzas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.AccumulativeCard;

@Repository
public interface CardRepository extends PagingAndSortingRepository<AccumulativeCard, Integer> {
}
