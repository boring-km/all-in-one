package com.aio.allinone.product;

import java.util.List;

public class ProductAdapter {

    public static ProductResponse getResponse(Object result) {
        return ProductResponse.builder()
                .data(result)
                .build();
    }

    public static ProductResponse getResponse(Object result, List<String> errors) {
        return ProductResponse.builder()
                .data(result)
                .errors(errors)
                .build();
    }
}
