package com.kruger.app.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.kruger.app.domain.Order;

public interface OrderRepository {
	
	Optional<Order> findById(UUID id);
	void save(Order order);

}
