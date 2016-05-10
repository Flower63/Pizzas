package com.maven_project.pizzas.repository.card;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.maven_project.pizzas.domain.AccumulativeCard;

@Repository(value="inMemCardRepository")
public class InMemCardRepository implements CardRepository {
	
	private final Map<Integer, AccumulativeCard> storage = new HashMap<>();

	@PostConstruct
	public void initCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccumulativeCard findCard(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveCard(AccumulativeCard card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCard(AccumulativeCard card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCard(AccumulativeCard card) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccumulativeCard findCardByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
