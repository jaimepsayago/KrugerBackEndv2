package com.kruger.app.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Order {
	private UUID id;
	private OrderStatus status;
	private List<OrderItem> orderItems;
	private BigDecimal price;
	
	
	public Order(final UUID id,final Product product) {
		this.id = id;
		this.status = OrderStatus.CREATED;
		this.orderItems = new ArrayList<>(Collections.singletonList(new OrderItem(product)));
		this.price = product.getPrice();
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
}


