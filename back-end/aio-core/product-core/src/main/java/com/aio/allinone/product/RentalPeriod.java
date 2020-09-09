package com.aio.allinone.product;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RentalPeriod {
    private LocalDateTime from;
    private LocalDateTime to;
}
