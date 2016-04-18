package com.maven_project.pizzas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaWithoutSpring {

	public static void main(String[] args) {
		EntityManagerFactory emf = null; 
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("jpa");
			em = emf.createEntityManager();
		
			Pizza pizza = new Pizza();
			pizza.setId(2);
			pizza.setName("Margo");
			pizza.setType(Pizza.Type.SEA);
			pizza.setCost(120.3);
			
//			em.getTransaction().begin();
//			em.persist(pizza);
//			em.getTransaction().commit();
			
			Pizza p = em.find(Pizza.class, 2);
			System.out.println(p);
		} finally {
			em.close();
			emf.close();
		}
	}
}
