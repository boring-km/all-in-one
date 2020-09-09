package com.aio.allinone.price;

import com.aio.allinone.money.Won;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

// TODO: 가격정책에 대해서도 좀 아이디어를 코드로 써보세요.
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PricePolicy {
    private PayTimeType payTimeType;
    private Won price;
}
