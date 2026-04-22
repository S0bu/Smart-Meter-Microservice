package com.smartmeter.meter.service;

import com.smartmeter.meter.dto.MeterReadingRequest;
import com.smartmeter.meter.entity.MeterReading;
import com.smartmeter.meter.repository.MeterReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeterService {

    private final MeterReadingRepository repository;

    public MeterReading saveReading(MeterReadingRequest request) {

        MeterReading reading = MeterReading.builder()
                .meterId(request.getMeterId())
                .readingValue(request.getReadingValue())
                .timestamp(LocalDateTime.now())
                .build();

        return repository.save(reading);
    }

    public List<MeterReading> getReadings(String meterId) {
        return repository.findByMeterId(meterId);
    }
}