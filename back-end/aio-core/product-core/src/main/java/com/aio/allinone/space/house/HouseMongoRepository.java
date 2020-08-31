package com.aio.allinone.space.house;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseMongoRepository extends MongoRepository<HouseProduct, Object> {
}
