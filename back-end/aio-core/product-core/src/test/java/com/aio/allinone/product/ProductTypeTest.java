package com.aio.allinone.product;

import com.aio.allinone.product.space.house.HouseProduct;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTypeTest {
    @Test
    void findProductTest() {
        assertThat(ProductType.findProduct("house")).isEqualTo(HouseProduct.class);
    }

}