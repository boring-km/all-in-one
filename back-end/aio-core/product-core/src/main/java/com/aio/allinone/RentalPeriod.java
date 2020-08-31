package com.aio.allinone;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RentalPeriod {
    private LocalDateTime start;
    private LocalDateTime end;
}

