package com.maven_project.pizzas.ifrastructure;

import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {

	private final Config config = new JavaConfig();
	private final Map<String, Object> context = new HashMap<>();
	
	@Override
	public Object getBean(String beanName) throws Exception {
		Object bean = context.get(beanName);
		
		if (bean != null) {
			return bean;
		}
		
		Class<?> clazz = config.getImpl(beanName);
		
		BeanBuilder builder = new BeanBuilder(clazz, this);
		builder.createBean();
		builder.createBeanProxy();
		builder.callPostConstructMethod();
		builder.callInitMethod();
		bean = builder.build();

		context.put(beanName, bean);
		
		return bean;
	}
}
