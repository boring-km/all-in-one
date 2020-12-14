package com.aio.allinone.product;

import com.aio.allinone.product.space.RoomSize;
import com.aio.allinone.product.space.house.HouseProduct;
import com.aio.allinone.product.space.store.StoreProduct;
import com.aio.allinone.product.vehicle.VehicleProduct;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductControllerTest {

    private ProductController controller;

    @Before
    void 컨트롤러_초기화() {
        this.controller = new ProductController();
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void findVehicleSellerId() {
        System.out.println(
                ((VehicleProduct) mongoTemplate.findAll(
                        Objects.requireNonNull(ProductType.findProduct("VehicleProduct")))
                        .get(0)).getProductInfo().getSellerId());
    }

    @Test
    void findVehicleBySellerId() {
        String sellerId = "kmjin";
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        VehicleProduct vehicleProduct = (VehicleProduct) mongoTemplate.find(query, Objects.requireNonNull(ProductType.findProduct("VehicleProduct"))).get(0);
        assertThat(vehicleProduct.getProductInfo().getSellerId()).isEqualTo(sellerId);
    }

    @Test
    void getProductList() {
        controller.getProductList("StoreProduct");
    }

    @Test
    void findProductBy() {
        controller.findProductBy("VehicleProduct", "kmjin");
    }

    @Test
    void registerHouseProduct() {
        mongoTemplate.insert(
                HouseProduct.builder()
                        .productInfo(ProductInfo.builder()
                                .sellerId("kmjin")
                                .address("주소주소")
                                .detail("세부사항")
                                .title("제목")
                                .build())
                        .houseSize(RoomSize.builder()
                                .maxNumberOfPeople(12)
                                .minNumberOfPeople(0)
                                .squareMetre(400).build())
                        .build());
    }

    @Test
    void registerStoreProduct() {
        mongoTemplate.insert(
                StoreProduct.builder()
                        .productInfo(ProductInfo.builder()
                                .sellerId("kmjin")
                                .address("가게주소")
                                .detail("세부사항")
                                .title("가게이름")
                                .build())
                        .storeSize(RoomSize.builder()
                                .maxNumberOfPeople(24)
                                .minNumberOfPeople(0)
                                .squareMetre(800).build())
                        .build());
    }

    @Test
    void registerVehicleProduct() {
        mongoTemplate.insert(
                VehicleProduct.builder()
                        .productInfo(ProductInfo.builder()
                                .sellerId("kmjin")
                                .address("63빌딩")
                                .detail("세부사항")
                                .title("63빌딩에 주차한 승용차 대여해줍니다.")
                                .build())
                        .number("서울 9999")
                        .vehicleType("승용차")
                        .build());
    }
}