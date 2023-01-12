package com.kruger.app.infraestructe.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kruger.app.AppDddApplication;
import com.kruger.app.domain.repository.OrderRepository;
import com.kruger.app.domain.service.DomainOrderService;
import com.kruger.app.domain.service.OrderService;

@Configuration
@ComponentScan(basePackageClasses = AppDddApplication.class)
public class BeanConfiguration {
	@Bean
	OrderService orderService(final OrderRepository orderRepository) {
		return new DomainOrderService(orderRepository);
	}
}
