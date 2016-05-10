package com.maven_project.pizzas.repository.order;

import com.maven_project.pizzas.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dennis
 *
 * on 4/27/2016.
 */
@Repository("orderRepository")
@Transactional
public class JpaOrderRepository implements OrderRepository {
	
	@PersistenceContext
    private EntityManager manager;

    @Override
    public Long saveOrder(Order order) {
        manager.persist(order);

        return order.getId();
    }

    @Override
    public Order findOrder(Long id) {
        return manager.find(Order.class, id);
    }

	@Override
	public boolean updateOrder(Order order) {
		Order temp = manager.find(Order.class, order.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.merge(order);
		
		return true;
	}

	@Override
	public boolean deleteOrder(Order order) {
		Order temp = manager.find(Order.class, order.getId());
		
		if (temp == null) {
			return false;
		}
		
		manager.remove(temp);
		
		return true;
	}
}
