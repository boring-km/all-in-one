package com.aio.allinone.vehicle;

import com.aio.allinone.ProductInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleProduct {

    private ProductInfo productInfo;
    private String number;
    private String vehicleType;

}
