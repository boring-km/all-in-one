package com.aio.allinone.product.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleMongoRepository extends MongoRepository<VehicleProduct, Object> {
}
