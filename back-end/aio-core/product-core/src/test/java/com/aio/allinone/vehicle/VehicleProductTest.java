package com.aio.allinone.vehicle;

import com.aio.allinone.ProductInfo;
import com.aio.allinone.RentalPeriod;
import com.aio.allinone.StatusType;
import com.aio.allinone.money.Won;
import com.aio.allinone.price.PayTimeType;
import com.aio.allinone.price.PricePolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleProductTest {
    private VehicleProduct vehicleProduct;

    @BeforeEach
    public void setVehicleProduct() {

        vehicleProduct = VehicleProduct.builder()
                .productInfo(ProductInfo.builder()
                        .productId("자동생성되는 ID")
                        .sellerId("kmjin")
                        .title("포터 대여합니다")
                        .address("서울시 동작구")
                        .pricePolicy(PricePolicy.builder()
                                .payTimeType(PayTimeType.PAY_PER_1_HOUR)
                                .price(new Won(5000L)).build())
                        .detail("자동차 파손 시 수수료 있음")
                        .rentalPeriod(RentalPeriod.builder()
                                .start(LocalDateTime.now())
                                .end(LocalDateTime.of(2020,11,30,22,0)).build())
                        .statusType(StatusType.사용가능)
                        .pictureURLArray(new String[]{"PictureUrl1", "PictureUrl2"})
                        .build())
                .number("서울 12345")
                .vehicleType("트럭")
                .build();
    }

    @Test
    public void vehicleProduct의_제품정보에서_가격정책을_가져오면_1시간에_5000원인_가격정책과_같다() {
        assertThat(vehicleProduct.getProductInfo().getPricePolicy())
                .isEqualTo(PricePolicy.builder()
                        .payTimeType(PayTimeType.PAY_PER_1_HOUR)
                        .price(new Won(5000L)).build());
    }

}