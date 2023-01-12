package com.kruger.app.infraestructe.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.kruger.app.infraestructure.repository.mongodb.SpringDataMongoOrderRepository;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDbConfiguration {

}
