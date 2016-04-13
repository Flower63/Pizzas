package com.maven_project.pizzas.ifrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BenchmarkProxyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		Method[] methods = bean.getClass().getMethods();
		
		for(Method m : methods) {
			if (m.isAnnotationPresent(Benchmark.class) && m.getAnnotation(Benchmark.class).active()) {
				System.out.println(Arrays.toString(bean.getClass().getInterfaces()));
				return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getSuperclass().getInterfaces(), new BeanProxy(bean));	
			}
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		return bean;
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

				System.out.println((after - before) / 1000000d);

				return result;
			}

			return method.invoke(obj, args);
		}
	}
}
