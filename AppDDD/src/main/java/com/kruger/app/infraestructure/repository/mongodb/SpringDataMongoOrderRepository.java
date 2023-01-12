package com.kruger.app.infraestructure.repository.mongodb;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kruger.app.domain.Order;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {

}
