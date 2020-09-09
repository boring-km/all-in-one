package com.aio.allinone.vehicle;

import com.aio.allinone.product.ProductInfo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "VehicleProduct")
public class VehicleProduct {

    private ProductInfo productInfo;
    private String number;
    private String vehicleType;

}
