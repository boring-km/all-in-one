package com.aio.allinone;

import com.aio.allinone.price.PricePolicy;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class ProductInfo {

    private final String productId;
    private final String sellerId;
    @Setter private String title;
    @Setter private String address;
    @Setter private PricePolicy pricePolicy;
    @Setter private RentalPeriod rentalPeriod;
    @Setter private StatusType statusType;
    @Setter private String detail;
    @Setter private String[] pictureURLArray;

}