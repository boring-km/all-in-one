package com.aio.allinone.product;

import com.aio.allinone.product.common.ProductInfo;
import com.aio.allinone.product.common.RoomSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "HouseProduct")
public class HouseProduct extends Product {
    private ProductInfo productInfo;
    private RoomSize houseSize;
}