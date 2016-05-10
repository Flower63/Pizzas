package com.maven_project.pizzas.repository.card;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maven_project.pizzas.domain.AccumulativeCard;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
@Repository("cardRepository")
@Transactional
public class JpaCardRepository implements CardRepository {
	
	@PersistenceContext
    private EntityManager manager;

    @Override
    public AccumulativeCard findCard(Integer id) {
        return manager.find(AccumulativeCard.class, id);
    }

    @Override
    public Integer saveCard(AccumulativeCard card) {
        manager.persist(card);
        
		return card.getId();
    }

	@Override
	public boolean deleteCard(AccumulativeCard card) {
		AccumulativeCard temp = manager.find(AccumulativeCard.class, card.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.remove(temp);
		
		return true;
	}

	@Override
	public boolean updateCard(AccumulativeCard card) {
		AccumulativeCard temp = manager.find(AccumulativeCard.class, card.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.merge(card);
		
		return true;
	}

	@Override
	public AccumulativeCard findCardByCustomerId(Integer customerId) {
		String query = "SELECT id FROM accumulativecard WHERE customer_id = " + customerId;
		
		Integer cardId = (Integer) manager.createNativeQuery(query).getResultList().get(0);
		
		return manager.find(AccumulativeCard.class, cardId);
	}
}
