package com.aio.allinone.product;

import com.aio.allinone.price.PricePolicy;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductInfo {

    private String productId;
    private String sellerId;
    private String title;
    private String address;
    private PricePolicy pricePolicy;
    private RentalPeriod[] rentalPeriod;
    private StatusType statusType;
    private String detail;
    private String[] pictureURLArray;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}