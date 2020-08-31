package com.aio.allinone.space;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: 방의 크기에 대한 정보를 확실히 정해야한다.
@NoArgsConstructor
@Builder
public class RoomSize {
    private int minNumberOfPeople;
    private int maxNumberOfPeople;
    private double squareMetre;
}

