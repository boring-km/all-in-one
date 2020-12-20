package com.aio.allinone.product.vehicle;

import com.aio.allinone.product.Product;
import com.aio.allinone.product.ProductInfo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "VehicleProduct")
public class VehicleProduct extends Product {
    private ProductInfo productInfo;
    private String number;
    private String vehicleType;

}
