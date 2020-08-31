package com.aio.allinone.price;

import com.aio.allinone.money.Won;
import lombok.Builder;
import lombok.Data;

// TODO: 가격정책에 대해서는 통일이 필요하다.
@Data
@Builder
public class PricePolicy {
    private PayTimeType payTimeType;
    private Won price;
}
