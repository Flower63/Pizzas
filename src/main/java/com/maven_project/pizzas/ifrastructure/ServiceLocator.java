package com.maven_project.pizzas.ifrastructure;

public class ServiceLocator {
	
	private final static ServiceLocator INSTANCE = new ServiceLocator();
	
	private Config config = new JavaConfig();
	
	private ServiceLocator() {}
	
	public static ServiceLocator getInstance() {
		return INSTANCE;
	}
	
	public Object lookup(String bean) {
		Class<?> clazz = config.getImpl(bean);
		
		if (clazz == null) {
			throw new RuntimeException("Bean not found");
		}
		
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
