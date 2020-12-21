package com.aio.allinone.product;

import com.aio.allinone.product.space.house.HouseProduct;
import com.aio.allinone.product.space.store.StoreProduct;
import com.aio.allinone.product.vehicle.VehicleProduct;

public enum ProductType {
    HouseProduct(HouseProduct.class),
    StoreProduct(StoreProduct.class),
    VehicleProduct(VehicleProduct.class),
    NoneProduct(NoneProduct.class);

    Class<?> productClass;
    ProductType(Class<?> productClass) {
        this.productClass = productClass;
    }

    public static ProductType findProduct(String type) {
        return ProductType.valueOf(type);
    }
}
