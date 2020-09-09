package com.aio.allinone.space.store;

import com.aio.allinone.product.ProductInfo;
import com.aio.allinone.space.RoomSize;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Document(collection = "StoreProduct")
public class StoreProduct {
    private ProductInfo productInfo;
    private RoomSize storeSize;
}
