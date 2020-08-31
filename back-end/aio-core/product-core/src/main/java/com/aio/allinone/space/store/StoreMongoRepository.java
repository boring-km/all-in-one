package com.aio.allinone.space.store;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreMongoRepository extends MongoRepository<StoreProduct, Object> {
}
