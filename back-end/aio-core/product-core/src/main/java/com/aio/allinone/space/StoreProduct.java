package com.aio.allinone.space;

import com.aio.allinone.ProductInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreProduct {
    private ProductInfo productInfo;
    private RoomSize storeSize;
}
