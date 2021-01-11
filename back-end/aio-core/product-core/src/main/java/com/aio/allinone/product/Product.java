package com.aio.allinone.product;

import com.aio.allinone.product.common.ProductInfo;
import com.aio.allinone.product.common.RoomSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
public abstract class Product {
    private String _id;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "HouseProduct")
class HouseProduct extends Product {
    private ProductInfo productInfo;
    private RoomSize houseSize;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "StoreProduct")
class StoreProduct extends Product {
    private ProductInfo productInfo;
    private RoomSize storeSize;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "VehicleProduct")
class VehicleProduct extends Product {
    private ProductInfo productInfo;
    private String number;
    private String vehicleType;

}
