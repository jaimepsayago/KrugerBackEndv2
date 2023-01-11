package com.kruger.app.application.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.app.application.request.AddProductRequest;
import com.kruger.app.application.request.CreateOrderRequest;
import com.kruger.app.application.response.CreateOrderResponse;
import com.kruger.app.domain.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//crear una orden
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest ) {
		final UUID id = orderService.createOrder(createOrderRequest.getProduct());
		return new CreateOrderResponse(id);
	}
	
	//agregar un product
	@PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
	void addProduct(@PathVariable final UUID id, @RequestBody final AddProductRequest addProductRequest) {
		orderService.addProduct(id, addProductRequest.getProduct());
	}
	
	//borrar el producto
	@DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
	void deleteProduct(@PathVariable final UUID id, @RequestParam final UUID productId) {
		orderService.deleteProduct(id, productId);
	}
	
	
	//completar la orden
	@PostMapping("/{id}/complete")
	void completeOrder(@PathVariable final UUID id) {
		orderService.completeOrder(id);
	}
	
	

	
	

}
