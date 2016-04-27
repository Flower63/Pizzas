package com.maven_project.pizzas.repository.order;

import com.maven_project.pizzas.domain.Order;

import javax.persistence.EntityManager;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
public class JpaOrderRepository implements OrderRepository {
    private final EntityManager manager;

    public JpaOrderRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Long saveOrder(Order order) {
        manager.getTransaction().begin();
        manager.persist(order);
        manager.getTransaction().commit();

        return order.getId();
    }

    public Order findOrder(Long id) {
        return manager.find(Order.class, id);
    }
}
