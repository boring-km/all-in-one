package com.aio.allinone.space.house;

import com.aio.allinone.product.ProductInfo;
import com.aio.allinone.space.RoomSize;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Builder
@Document(collection = "HouseProduct")
public class HouseProduct {
    private ProductInfo productInfo;
    private RoomSize houseSize;
}
