package com.aio.allinone.product;

import com.aio.allinone.product.space.house.HouseProduct;
import com.aio.allinone.product.space.store.StoreProduct;
import com.aio.allinone.product.vehicle.VehicleProduct;

public enum ProductType {
    house(HouseProduct.class),
    store(StoreProduct.class),
    vehicle(VehicleProduct.class),
    none(NoneProduct.class);

    Class<?> productClass;
    ProductType(Class<?> productClass) {
        this.productClass = productClass;
    }

    public static Class<?> findProduct(String type) {
        return ProductType.valueOf(type).productClass;
    }
}
