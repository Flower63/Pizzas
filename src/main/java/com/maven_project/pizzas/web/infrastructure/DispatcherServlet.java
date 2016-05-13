package com.maven_project.pizzas.web.infrastructure;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maven_project.pizzas.web.Controller;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	private HandlerMapping handlerMapping;
	private ConfigurableApplicationContext applicationContext;
	private ConfigurableApplicationContext repContext;
	private ConfigurableApplicationContext webContext;
	
	@Override
	public void init() {
		String contextConfigsLocation = this.getServletContext().getInitParameter("contextConfigLocation");
		String[] contextConfigs = contextConfigsLocation.split(" ");
		String webContextConfig = getInitParameter("contextConfigLocation");
		
		repContext = new ClassPathXmlApplicationContext(contextConfigs[0]);
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { contextConfigs[1] }, repContext);
		webContext =  new ClassPathXmlApplicationContext(
				new String[] { webContextConfig }, applicationContext);
		handlerMapping = new SpringUrlHandlerMapping(webContext);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String url = req.getRequestURI();
		String controllerName = getControllerName(url);
		Controller controller = handlerMapping.getController(controllerName);
		controller.handleRequest(req, resp);
	}
	
	@Override
	public void destroy() {
		webContext.close();
		applicationContext.close();
		repContext.close();
	}

	private String getControllerName(String url) {
		return url.substring(url.lastIndexOf("/"));
	}
}
