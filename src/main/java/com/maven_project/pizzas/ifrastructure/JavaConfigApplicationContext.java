package com.maven_project.pizzas.ifrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
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
		builder.createBeanProxy(); //@BanchMark annotation -Method, (active = true/false)
		builder.callPostConstructMethod();
		builder.callInitMethod();
		bean = builder.build();

		context.put(beanName, bean);
		
		return bean;
	}

	public static class BeanBuilder {
		private final Class<?> clazz;
		private Object bean;
		private ApplicationContext context;

		public BeanBuilder(Class<?> clazz, ApplicationContext context) {
			this.clazz = clazz;
			this.context = context;
		}

		public Object build() {
			return bean;
		}

		public void callInitMethod() throws Exception {
			Method[] methods = clazz.getMethods();
			
			for (Method m : methods) {
				if (m.getName() == "init") {
					m.invoke(bean);
				}
			}
		}

		public void callPostConstructMethod() throws Exception {
			Method[] methods = clazz.getMethods();
			
			for (Method m : methods) {
				if (m.getAnnotation(PostConstruct.class) != null) {
					m.invoke(bean);
				}
			}
		}

		public Object createBeanProxy() {
			// TODO Auto-generated method stub
			// Proxy.newProxyInstance
			
			Method[] methods = clazz.getMethods();
			
			for (Method m : methods) {
				if (m.getAnnotation(Benchmark.class) != null && m.getAnnotation(Benchmark.class).active()) {
					return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new BeanProxy(bean));
				}
			}
			
			return bean;
		}

		public void createBean() throws Exception {
			Constructor<?> constructor = clazz.getConstructors()[0];
			Class<?>[] params = constructor.getParameterTypes();
			
			if (params.length == 0) {
				bean = clazz.newInstance();
			} else {
				bean = createNewInstanceWithParams(constructor, params);
			}
			
		}
		
		private Object createNewInstanceWithParams(Constructor<?> constructor, Class<?>[] params)
				throws Exception {
			Object cache;
			Object[] paramBeans = new Object[params.length];
			
			for (int i = 0; i < params.length; i++) {
				String paramName = getBeanNameByType(params, paramBeans, i);
				paramBeans[i] = context.getBean(paramName);
			}
			
			cache = constructor.newInstance(paramBeans);
			return cache;
		}
		
		private String getBeanNameByType(Class<?>[] params, Object[] paramBeans, int i) throws Exception {
			String name = params[i].getSimpleName();
			String paramName = changeFirstLetterToLowerCase(name);
			return paramName;
		}

		private String changeFirstLetterToLowerCase(String name) {
			String paramName = Character.toLowerCase(name.charAt(0)) + name.substring(1);
			return paramName;
		}
		
	}
	
	public static class BeanProxy implements InvocationHandler {
		Object obj;

		public BeanProxy(Object obj) {
			this.obj = obj;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("proxy method");
			return method.invoke(obj, args);
		}
		
	}
}
