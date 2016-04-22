package com.maven_project.pizzas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

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
			//pizza.setId(2);
			pizza.setName("Margo");
			pizza.setType(Pizza.Type.SEA);
			pizza.setCost(120.3);
			
			em.getTransaction().begin();
			em.persist(pizza);
			em.getTransaction().commit();
			
			Address adr = new Address();
			adr.setActualy("address");
			adr.setState(new State("Some state"));
			
			Customer customer = new RegistratedCustomer();
			//customer.setId(1);
			customer.setName("Pizza man");
			customer.setAddress(adr);
			customer.setPhones(Arrays.asList("dfgdlfgk", "fdgdfg"));
			customer.setAddresses(Arrays.asList(adr, adr));
			
			adr.setCustomer(customer);
			
			em.getTransaction().begin();
			em.persist(adr);
			em.persist(customer);
			em.getTransaction().commit();
			
//			Order order = new Order(customer, Arrays.asList(pizza, pizza));
//			em.getTransaction().begin();
//			em.persist(order);
//			em.getTransaction().commit();
			
			em.clear();
			
			Pizza p = em.find(Pizza.class, 2);
			
			System.out.println(p);
			
			Customer c = em.find(Customer.class, customer.getId());
			System.out.println(c);
			
			Address a = em.find(Address.class, adr.getId());
			System.out.println(a.getCustomer());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
