package com.aio.allinone.product;

import com.aio.allinone.response.ApiResponse;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

public class ProductResponse extends ApiResponse<Object> {

    @Builder
    public ProductResponse(@NonNull Object data, final List<String> errors) {
        super(data);
        this.setErrors(errors);
    }
}
