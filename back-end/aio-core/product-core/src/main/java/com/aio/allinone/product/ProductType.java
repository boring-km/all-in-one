package com.aio.allinone.product;

public enum ProductType {
    house(HouseProduct.class),
    store(StoreProduct.class),
    vehicle(VehicleProduct.class),
    none(NoneProduct.class);

    Class<?> productClass;
    ProductType(Class<?> productClass) {
        this.productClass = productClass;
    }

    public static ProductType findProduct(String type) {
        return ProductType.valueOf(type);
    }
}
