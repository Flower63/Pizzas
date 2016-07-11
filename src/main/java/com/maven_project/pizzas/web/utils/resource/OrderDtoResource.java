package com.maven_project.pizzas.web.utils.resource;

import com.maven_project.pizzas.domain.Order;
import com.maven_project.pizzas.domain.Pizza;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Map;

import javax.validation.constraints.NotNull;

/*
 * @author Denys Zvarych
 *
 */
public class OrderDtoResource extends ResourceSupport {
	private Long orderId;
	
	//Customer
	@NotNull
	private Integer customerId;
	
	@NotBlank
	private String customerName;
	//Customer
	
	@NotEmpty
	private Map<Pizza, Integer> pizzas;
	
	@NotNull
	private Order.State state;
	
	//Address
	@NotNull
	private Integer addressId;
	
	@NotNull
	private Boolean isDiscountsApplicable;

	@NotNull
	private Double price;

	private Double discount;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<Pizza, Integer> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Map<Pizza, Integer> pizzas) {
		this.pizzas = pizzas;
	}

	public Order.State getState() {
		return state;
	}

	public void setState(Order.State state) {
		this.state = state;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Boolean getIsDiscountsApplicable() {
		return isDiscountsApplicable;
	}

	public void setIsDiscountsApplicable(Boolean isDiscountsApplicable) {
		this.isDiscountsApplicable = isDiscountsApplicable;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
