package com.smartmeter.meter.controller;

import com.smartmeter.meter.dto.MeterReadingRequest;
import com.smartmeter.meter.entity.MeterReading;
import com.smartmeter.meter.service.MeterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/meters")
@RequiredArgsConstructor
public class MeterController {

    private final MeterService meterService;

    @PostMapping("/reading")
    public MeterReading addReading(@Valid @RequestBody MeterReadingRequest request) {
        return meterService.saveReading(request);
    }

    @GetMapping("/{meterId}")
    public List<MeterReading> getReadings(@PathVariable String meterId) {
        return meterService.getReadings(meterId);
    }
}