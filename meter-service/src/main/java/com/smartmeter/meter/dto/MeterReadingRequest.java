package com.smartmeter.meter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MeterReadingRequest {

    @NotBlank(message = "is required")
    private String meterId;

    @NotNull(message = "is required")
    private Double readingValue;
}