package com.aio.allinone.dao;

import com.aio.allinone.product.VehicleProduct;
import com.aio.allinone.product.common.ProductInfo;
import com.aio.allinone.query.QueryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MongoDAOTest {

    @Autowired
    private MongoDAO dao;

    @Test
    void 자동차대여상품을_조회한_answer와_예상한_객체의_값_predict는_같다() {
        QueryBuilder qb = QueryBuilder.builder()
                .where("productInfo.sellerId")
                .is("kmjin")
                .build();
        List<?> daoResult = dao.find(qb, "VehicleProduct");
        VehicleProduct answer = (VehicleProduct) daoResult.get(0);
        VehicleProduct predict = VehicleProduct.builder()
                .productInfo(ProductInfo.builder()
                        .sellerId("kmjin")
                        .title("63빌딩에 주차한 봉고트럭 대여해줍니다.")
                        .address("63빌딩")
                        .detail("추가된 세부사항")
                        .build())
                .number("경기 9876")
                .vehicleType("트럭")
                .build();
        predict.set_id("5fe045015c3a4865f72b7949");
        assertEquals(answer, predict);
    }
}