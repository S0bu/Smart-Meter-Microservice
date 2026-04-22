package com.smartmeter.meter.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class MeterReadingRequest {

    @NotNull
    private String meterId;

    @NotNull
    private Double readingValue;
}