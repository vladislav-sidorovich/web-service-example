package org.example.web;

import org.example.dto.TrainingDto;
import org.example.services.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/trainings")
public class TrainController {
    private static final Logger log = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private TrainingService trainingService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<TrainingDto> all() {
        return trainingService.all();
    }

    @GetMapping("{id}")
    public TrainingDto one(@PathVariable Integer id) {
        return trainingService.one(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody TrainingDto dto) {
        log.info("Received training to add {} ", dto);

        trainingService.add(dto);
    }
}
