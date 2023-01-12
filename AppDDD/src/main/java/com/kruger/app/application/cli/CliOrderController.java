package com.kruger.app.application.cli;


import java.math.BigDecimal;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kruger.app.domain.Product;
import com.kruger.app.domain.service.OrderService;


@Component
public class CliOrderController {
	private static final Logger LOG = LoggerFactory.getLogger(CliOrderController.class);
	private final OrderService orderService;
	
	@Autowired
	public CliOrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	//crear complete order
	public void createCompleteOrder() {
		LOG.info("create complete order");
		UUID orderId = createOrder();
		orderService.completeOrder(orderId);
		
	}
	
	//complete order
	public void createIncompleteOrder() {
		LOG.info("create INCOMPLETE order");
		UUID orderId=createOrder();
	}
	
	//crear order
	private UUID createOrder() {
		LOG.info("agregar una orden nueva con dos productos");
		Product mobile = new Product(UUID.randomUUID(), BigDecimal.valueOf(200),"mobile");
		Product razor = new Product(UUID.randomUUID(), BigDecimal.valueOf(25),"razor");
		LOG.info("creados dos productos");
		UUID orderId= orderService.createOrder(mobile);
		LOG.info("crea orden con un mobile");
		orderService.addProduct(orderId,razor);
		LOG.info("agregado razon con la orden");
		return orderId;
	}
	


}
