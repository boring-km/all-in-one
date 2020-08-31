package com.aio.allinone.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RentalPeriod {
    private LocalDateTime from;
    private LocalDateTime to;
}

