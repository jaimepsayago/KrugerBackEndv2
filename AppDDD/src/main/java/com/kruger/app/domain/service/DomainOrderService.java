package com.kruger.app.domain.service;

import java.util.UUID;

import com.kruger.app.domain.Order;
import com.kruger.app.domain.Product;
import com.kruger.app.domain.repository.OrderRepository;

public class DomainOrderService implements OrderService {
	
	private final OrderRepository orderRepository;
	
	public DomainOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public UUID createOrder(final Product product) {
		final Order order = new Order(UUID.randomUUID(), product);
		orderRepository.save(order);
		return order.getId();
	}

	@Override
	public void addProduct(UUID id, Product product) {
		final Order order = getOrder(id);
		order.addOrder(product);
		orderRepository.save(order);
		
	}

	@Override
	public void completeOrder(final UUID id) {
		final Order order = getOrder(id);
		order.complete();
		orderRepository.save(order);
		
	}

	@Override
	public void deleteProduct(UUID id, UUID productId) {
		final Order order = getOrder(id);
		order.removeOrder(productId);
		orderRepository.save(order);
		
	}
	
	private Order getOrder(UUID id) {
		return orderRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("order no existe"));
	}

}
