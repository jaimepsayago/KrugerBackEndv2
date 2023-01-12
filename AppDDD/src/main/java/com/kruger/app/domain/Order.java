package com.kruger.app.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Data
//@Document
public class Order {
	private UUID id;
	private OrderStatus status;
	private List<OrderItem> orderItems;
	private BigDecimal price;
	
	
	public Order(final UUID id,final Product product) {
		this.id = id;
		this.orderItems = new ArrayList<>(Collections.singletonList(new OrderItem(product)));
		this.status = OrderStatus.CREATED;
		this.price = product.getPrice();
	}
	public Order() {
		
	}
	
	//mensajes
	//completo la orden
	public void complete() {
		validateState();
		this.status = OrderStatus.COMPLETED;
	}
	
	//agregar una orden
	public void addOrder(final Product product) {
		validateState();
		validateProduct(product);
		orderItems.add(new OrderItem(product));
		price = price.add(product.getPrice());
	}
	
	//remover una orden
	public void removeOrder(final UUID id) {
		validateState();
		final OrderItem orderItem = getOrderItem(id);
		orderItems.remove(orderItem);
		price = price.subtract(orderItem.getPrice());
	}
	
	//obtener una orden y sus items
	
	private OrderItem getOrderItem(final UUID id) {
		return orderItems.stream()
				.filter(orderItem -> orderItem.getProductId()
						.equals(id))
				.findFirst()
				.orElseThrow(()-> new DomainException("producto with " + id + " no existe "));
	}
	
	
	private void validateState() {
		if (OrderStatus.COMPLETED.equals(status)) {
			throw new DomainException("la orden esta con estado completado");
		}
	}
	
	private void validateProduct(final Product product) {
		if (product == null) {
			throw new DomainException("el producto no puede ser nulo");
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderItems, price, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(orderItems, other.orderItems)
				&& Objects.equals(price, other.price) && status == other.status;
	}
	
	
}


