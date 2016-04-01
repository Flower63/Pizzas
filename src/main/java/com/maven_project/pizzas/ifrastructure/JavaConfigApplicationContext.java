package com.maven_project.pizzas.ifrastructure;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {

	private final Config config = new JavaConfig();
	private final Map<String, Object> context = new HashMap<>();
	
	@Override
	public Object getBean(String bean) throws Exception {
		Object cache;
		
		if (context.containsKey(bean)) {
			return context.get(bean);
		}
		
		Class<?> clazz = config.getImpl(bean);
		
		Constructor<?> constructor = clazz.getConstructors()[0];
		Class<?>[] params = constructor.getParameterTypes();
		//Object[] paramBeans = new Object[params.length];
		
		if (params.length == 0) {
			cache = clazz.newInstance();
		} else {
			Object[] paramBeans = new Object[params.length];
			
			for (int i = 0; i < params.length; i++) {
				String paramName = null;
				String name = params[i].getSimpleName();
				paramName = Character.toLowerCase(name.charAt(0)) + name.substring(1);
				paramBeans[i] = getBean(paramName);
			}
			
			cache = constructor.newInstance(paramBeans);
		}
		
		//cache = clazz.newInstance();
		context.put(bean, cache);
		
		return cache;
	}

}
