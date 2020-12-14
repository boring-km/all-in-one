package com.aio.allinone.product;

import com.aio.allinone.product.space.house.HouseProduct;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTypeTest {
    @Test
    void productTest() {
        assertThat(ProductType.findProduct("HouseProduct")).isEqualTo(HouseProduct.class);
    }
}