package com.aio.allinone.space;

import lombok.Builder;
import lombok.Data;

// TODO: 방의 크기에 대한 정보를 확실히 정해야한다.
@Data
@Builder
public class RoomSize {
    private int numberOfPeople;
    private double squareMetre;
    private int pyung;
}

