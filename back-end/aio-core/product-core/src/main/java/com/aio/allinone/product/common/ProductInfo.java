package com.aio.allinone.product.common;

import com.aio.allinone.price.PricePolicy;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProductInfo {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return Objects.equals(sellerId, that.sellerId) && Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(pricePolicy, that.pricePolicy) && Arrays.equals(rentalPeriod, that.rentalPeriod) && statusType == that.statusType && Objects.equals(detail, that.detail) && Arrays.equals(pictureURLArray, that.pictureURLArray) && Objects.equals(createdAt, that.createdAt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(updatedBy, that.updatedBy);
    }
}