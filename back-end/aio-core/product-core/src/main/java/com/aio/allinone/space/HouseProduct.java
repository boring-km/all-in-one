package com.aio.allinone.space;

import com.aio.allinone.ProductInfo;
import lombok.*;

@Data
@Builder
public class HouseProduct {
    private ProductInfo productInfo;
    private RoomSize houseSize;
}
