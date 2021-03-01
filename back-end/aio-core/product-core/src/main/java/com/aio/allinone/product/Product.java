package com.aio.allinone.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class Product {
    private String _id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(_id, product._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}

