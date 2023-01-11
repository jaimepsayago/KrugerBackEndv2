package com.kruger.app.domain.service;

import java.util.UUID;

import com.kruger.app.domain.Product;

public interface OrderService {
	
	UUID createOrder (Product product);
	void addProduct(UUID id, Product product);
	void completeOrder(UUID id);
	void deleteProduct(UUID id, UUID product);

}
