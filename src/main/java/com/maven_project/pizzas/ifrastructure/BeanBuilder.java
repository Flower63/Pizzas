package com.maven_project.pizzas.ifrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Dennis
 *
 * on 4/4/2016.
 */
public class BeanBuilder {
    private final Class<?> clazz;
    private Object bean;
	private Object beanProxy;
    private ApplicationContext context;

	private final static String INIT_METH_NAME = "init";

    public BeanBuilder(Class<?> clazz, ApplicationContext context) {
        this.clazz = clazz;
        this.context = context;
    }

    public Object build() {
        return beanProxy;
    }

    public void callInitMethod() throws Exception {
		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
            if (INIT_METH_NAME.equals(m.getName())) {
				beanProxy.getClass().getMethod(INIT_METH_NAME).invoke(beanProxy);
				break;
            }
        }
    }

    public void callPostConstructMethod() throws Exception {
		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
            if (m.getAnnotation(PostConstruct.class) != null) {
				beanProxy.getClass().getMethod(m.getName()).invoke(beanProxy);
            }
        }
    }

    public void createBeanProxy() {
		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
            if (m.getAnnotation(Benchmark.class) != null && m.getAnnotation(Benchmark.class).active()) {
				beanProxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new BeanProxy(bean));
                break;
            }
        }
    }

    public void createBean() throws Exception {
        Constructor<?> constructor = clazz.getConstructors()[0];
        Class<?>[] params = constructor.getParameterTypes();

		if (params.length == 0) {
            bean = clazz.newInstance();
        } else {
            bean = createNewInstanceWithParams(constructor, params);
        }

		beanProxy = bean;
	}

	private Object createNewInstanceWithParams(Constructor<?> constructor, Class<?>[] params)
            throws Exception {
        Object cache;
        Object[] paramBeans = new Object[params.length];

		for (int i = 0; i < params.length; i++) {
            String paramName = getBeanNameByType(params, i);
            paramBeans[i] = context.getBean(paramName);
        }

		cache = constructor.newInstance(paramBeans);
        return cache;
    }

	private String getBeanNameByType(Class<?>[] params, int i) throws Exception {
        String name = params[i].getSimpleName();
        String paramName = changeFirstLetterToLowerCase(name);
        return paramName;
    }

    private String changeFirstLetterToLowerCase(String name) {
        String paramName = Character.toLowerCase(name.charAt(0)) + name.substring(1);
        return paramName;
    }

	public static class BeanProxy implements InvocationHandler {
		Object obj;

		public BeanProxy(Object obj) {
			this.obj = obj;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (method.getAnnotation(Benchmark.class) != null) {
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
