package com.aio.allinone.product.space.store;

import com.aio.allinone.product.Product;
import com.aio.allinone.product.ProductInfo;
import com.aio.allinone.product.space.RoomSize;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "StoreProduct")
public class StoreProduct extends Product {
    private ProductInfo productInfo;
    private RoomSize storeSize;
}
