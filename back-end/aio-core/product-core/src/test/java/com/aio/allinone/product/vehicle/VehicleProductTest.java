package com.aio.allinone.product.vehicle;

import com.aio.allinone.money.Won;
import com.aio.allinone.price.PayTimeType;
import com.aio.allinone.price.PricePolicy;
import com.aio.allinone.product.ProductInfo;
import com.aio.allinone.product.RentalPeriod;
import com.aio.allinone.product.StatusType;
import com.aio.allinone.product.vehicle.VehicleMongoRepository;
import com.aio.allinone.product.vehicle.VehicleProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VehicleProductTest {

    @Autowired
    private VehicleMongoRepository vehicleMongoRepository;
    private VehicleProduct vehicleProduct;
    private PricePolicy oneHourPolicy;

    @BeforeEach
    public void 초기화() {

        vehicleProduct = VehicleProduct.builder()
                .productInfo(ProductInfo.builder()
                        .sellerId("kmjin")
                        .title("포터 대여합니다")
                        .address("서울시 동작구")
                        .pricePolicy(PricePolicy.builder()
                                .payTimeType(PayTimeType.PAY_PER_1_HOUR)
                                .price(new Won(5000L)).build())
                        .detail("자동차 파손 시 수수료 있음")
                        .rentalPeriod(
                                new RentalPeriod[]{RentalPeriod.builder()
                                .from(LocalDateTime.now())
                                .to(LocalDateTime.of(2020,11,30,22,0)).build()})
                        .statusType(StatusType.POSSIBLE)
                        .pictureURLArray(new String[]{"PictureUrl1", "PictureUrl2"})
                        .build())
                .number("서울 12345")
                .vehicleType("트럭")
                .build();
        oneHourPolicy = PricePolicy.builder()
                .payTimeType(PayTimeType.PAY_PER_1_HOUR)
                .price(new Won(5000L)).build();

    }

    @Test
    void insertTestVehicle() {
        vehicleMongoRepository.insert(vehicleProduct);
    }

    @Test
    void printTestVehicle() {
        System.out.println(vehicleMongoRepository.findAll().get(0).toString());
    }

    @Test
    void 테스트_차량_제품의_차량_타입은_트럭이다() {
        assertThat(vehicleMongoRepository.findAll().get(0).getVehicleType()).isEqualTo("트럭");
    }

    @Test
    public void vehicleProduct의_제품정보에서_가격정책을_가져오면_1시간에_5000원인_가격정책과_같다() {
        assertThat(vehicleProduct.getProductInfo().getPricePolicy())
                .isEqualTo(oneHourPolicy);
    }

}