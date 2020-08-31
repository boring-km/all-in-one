package com.aio.allinone.space.store;

import com.aio.allinone.product.ProductInfo;
import com.aio.allinone.space.RoomSize;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Builder
@Document(collection = "StoreProduct")
public class StoreProduct {
    private ProductInfo productInfo;
    private RoomSize storeSize;
}
