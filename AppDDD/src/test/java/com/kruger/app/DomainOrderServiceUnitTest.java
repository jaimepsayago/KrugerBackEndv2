package com.kruger.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.UUID;

import com.kruger.app.domain.Order;
import com.kruger.app.domain.Product;
import com.kruger.app.domain.repository.OrderRepository;
import com.kruger.app.domain.service.DomainOrderService;

public class DomainOrderServiceUnitTest {
	private OrderRepository orderRepository;
	private DomainOrderService tested;
	
	@BeforeEach
	void setup() {
		orderRepository = mock(OrderRepository.class);
		tested= new DomainOrderService(orderRepository);
		
	}

	@Test
	void createOrderSave() {
		final Product product = new Product(UUID.randomUUID(), BigDecimal.TEN, "productName");
		final UUID id = tested.createOrder(product);
		verify(orderRepository).save(any(Order.class));
		assertNotNull(id);
	}
	
}
