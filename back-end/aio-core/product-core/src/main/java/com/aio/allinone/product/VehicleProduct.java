package com.aio.allinone.product;

import com.aio.allinone.product.common.ProductInfo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Document(collection = "VehicleProduct")
public class VehicleProduct extends Product {
    private ProductInfo productInfo;
    private String number;
    private String vehicleType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehicleProduct product = (VehicleProduct) o;
        return Objects.equals(productInfo, product.productInfo) && Objects.equals(number, product.number) && Objects.equals(vehicleType, product.vehicleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productInfo, number, vehicleType);
    }
}
