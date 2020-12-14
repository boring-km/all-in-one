package com.aio.allinone.product.space.house;

import com.aio.allinone.product.space.house.HouseMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HouseMongoRepositoryTest {

    @Autowired
    private HouseMongoRepository houseMongoRepository;

    @Test
    void HouseDB테스트() {
        System.out.println(houseMongoRepository.findAll());
    }
}