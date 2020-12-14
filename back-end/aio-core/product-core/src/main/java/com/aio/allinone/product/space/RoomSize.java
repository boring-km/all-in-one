package com.aio.allinone.product.space;

import lombok.*;

// TODO: 방의 크기에 대한 정보를 확실히 정해야한다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RoomSize {
    private int minNumberOfPeople;
    private int maxNumberOfPeople;
    private double squareMetre;
}

