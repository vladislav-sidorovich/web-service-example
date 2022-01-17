package org.example.services;

import org.example.dto.TrainingDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TrainingService {
    private Map<Integer, TrainingDto> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public void add(TrainingDto dto) {
        repository.put(counter.incrementAndGet(), dto);
    }

    public Iterable<TrainingDto> all() {
        return repository.values();
    }

    public TrainingDto one(Integer id) {
        return repository.get(id);
    }
}
