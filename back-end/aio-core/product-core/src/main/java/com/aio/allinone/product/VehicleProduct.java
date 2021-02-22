package com.aio.allinone.product;

import com.aio.allinone.product.common.ProductInfo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
