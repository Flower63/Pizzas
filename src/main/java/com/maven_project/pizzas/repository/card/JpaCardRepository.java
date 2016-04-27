package com.maven_project.pizzas.repository.card;

import com.maven_project.pizzas.domain.Customer;
import com.maven_project.pizzas.service.card.AccumulativeCard;

import javax.persistence.EntityManager;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
public class JpaCardRepository implements CardRepository {
    private final EntityManager manager;

    public JpaCardRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void initCards() {

    }

    @Override
    public AccumulativeCard findCard(Customer customer) {
        return manager.find(AccumulativeCard.class, customer.getId());
    }

    public void saveCard(AccumulativeCard card) {
        manager.getTransaction().begin();
        manager.persist(card);
        manager.getTransaction().commit();
    }
}
