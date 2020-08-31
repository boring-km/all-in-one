package com.aio.allinone.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleMongoRepository extends MongoRepository<VehicleProduct, Object> {
}
