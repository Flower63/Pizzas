package com.maven_project.pizzas.ifrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BenchmarkProxyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		Method[] methods = bean.getClass().getMethods();
		
		for(Method m : methods) {
			if (m.isAnnotationPresent(Benchmark.class) && m.getAnnotation(Benchmark.class).active()) {
				return createProxy(bean);
			}
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		return bean;
	}

	private Object createProxy(Object target) {
		Class<?> clazz = target.getClass();
		ClassLoader classLoader = clazz.getClassLoader();
		Class<?>[] interfaces = findInterfaces(clazz);
		InvocationHandler handler = new BeanProxy(target);

		return Proxy.newProxyInstance(classLoader, interfaces, handler);
	}

	private Class<?>[] findInterfaces(Class<?> clazz) {
		List<Class<?>> result = new ArrayList<>();

		while (!clazz.equals(Object.class)) {
			result.addAll(Arrays.asList(clazz.getInterfaces()));
			clazz = clazz.getSuperclass();
		}

		return result.toArray(new Class<?>[0]);
	}

	private static class BeanProxy implements InvocationHandler {
		Object obj;

		public BeanProxy(Object obj) {
			this.obj = obj;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (obj.getClass().getMethod(method.getName(), method.getParameterTypes())
					.isAnnotationPresent(Benchmark.class)) {
				long before = System.nanoTime();
				Object result = method.invoke(obj, args);
				long after = System.nanoTime();

				System.out.println(method.getName() + " " + (after - before) / 1000000d);

				return result;
			}

			return method.invoke(obj, args);
		}
	}
}
