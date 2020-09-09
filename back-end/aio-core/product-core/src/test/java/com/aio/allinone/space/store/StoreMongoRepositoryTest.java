package com.aio.allinone.space.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreMongoRepositoryTest {

    @Autowired
    private StoreMongoRepository storeMongoRepository;

    @Test
    void StoreDB_테스트() {
        System.out.println(storeMongoRepository.findAll());
    }
}