package com.kruger.app.infraestructure.repository.mongodb;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.kruger.app.domain.Order;
import com.kruger.app.domain.repository.OrderRepository;

@Component
@Primary
public class MongoDbOrderRepository implements OrderRepository {
	
	private final SpringDataMongoOrderRepository orderRepository;

	@Autowired
	public MongoDbOrderRepository(final SpringDataMongoOrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	
	@Override
	public Optional<Order> findById(final UUID id) {
		return orderRepository.findById(id);
	}

	@Override
	public void save(final Order order) {
		orderRepository.save(order);
				
	}
	

}
