package com.aio.allinone.money;

import lombok.Getter;

import java.util.Objects;

public class Won {
    @Getter
    private final Long price;
    private static final Won ZERO = new Won(0L);

    public Won(Long price) {
        this.price = price;
    }

    public Won plus(Won won) {
        return new Won(this.price + won.price);
    }

    public Won minus(Won won) {
        return new Won(this.price - won.price);
    }

    public Won multiply(Won won) {
        return new Won(this.price * won.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Won won = (Won) o;
        return Objects.equals(price, won.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
