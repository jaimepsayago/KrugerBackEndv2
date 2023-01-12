package com.kruger.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.kruger.app.application.cli.CliOrderController;

@SpringBootApplication
@PropertySource(value = { "classpath:application.properties" })
public class AppDddApplication implements CommandLineRunner {

	public static void main(final String[] args) {
		//SpringApplication.run(AppDddApplication.class, args);
		SpringApplication application = new SpringApplication(AppDddApplication.class);
		application.run(args);
	}

	@Autowired
	public CliOrderController orderController;
	
	@Autowired
	public ConfigurableApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		orderController.createCompleteOrder();
		orderController.createIncompleteOrder();
		System.out.println("hola");
		
	}

}
