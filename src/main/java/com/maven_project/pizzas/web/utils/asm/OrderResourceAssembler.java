package com.maven_project.pizzas.web.utils.asm;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.service.AddressService;
import com.maven_project.pizzas.service.CustomerService;
import com.maven_project.pizzas.web.controller.app.OrderController;
import com.maven_project.pizzas.web.controller.rest.OrderRestController;
import com.maven_project.pizzas.web.utils.resource.OrderDtoResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/*
 * @author Denys Zvarych
 *
 */
@Component
public class OrderResourceAssembler extends ResourceAssemblerSupport<Order, OrderDtoResource> {

	private final CustomerService customerService;
	private final AddressService addressService;
	
	/**
	 * @param controllerClass
	 * @param resourceType
	 */
	@Autowired
	public OrderResourceAssembler(CustomerService customerService, AddressService addressService) {
		super(OrderController.class, OrderDtoResource.class);
		
		this.customerService = customerService;
		this.addressService = addressService;
	}

	/*
	 * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
	 */
	@Override
	public OrderDtoResource toResource(Order entity) {
		OrderDtoResource resource = super.createResourceWithId(entity.getOrderId(), entity);
		
		resource.setCustomerId(entity.getCustomer().getCustomerId());
		resource.setCustomerName(entity.getCustomer().getName());
		resource.setPizzas(entity.getPizzas());
		resource.setState(entity.getState());
		resource.setAddressId(entity.getAddress().getId());
		resource.setIsDiscountsApplicable(entity.isDiscountsApplicable());
		resource.setPrice(entity.getPrice());
		resource.setDiscount(entity.getDiscount());
		
		//resource.add(linkTo(methodOn(OrderRestController.class).getAll()).withRel("all"));
		
		return resource;
	}

	public Order toEntity(OrderDtoResource resource) {
		Order order = new Order();
		
		order.setOrderId(resource.getOrderId());
		order.setCustomer(customerService.findCustomer(resource.getCustomerId()));
		order.setPizzas(resource.getPizzas());
		order.setAddress(addressService.findAddress(resource.getAddressId()));
		order.setDiscountsApplicable(resource.getIsDiscountsApplicable());
		order.setPrice(resource.getPrice());
		order.setDiscount(resource.getDiscount());
		
		return order;
	}
}
