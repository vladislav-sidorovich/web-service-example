package org.example.web;

import org.example.dto.TrainingDto;
import org.example.dto.TrainingSetDto;
import org.example.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/trainings/{trainingId}/sets")
public class TrainingSetController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<TrainingSetDto> all(@PathVariable("trainingId") Integer trainingId) {
        TrainingDto one = trainingService.one(trainingId);
        if (one == null) {
            return Collections.emptyList();
        }
        return one.getTrainingSets();
    }

    @PostMapping
    public Object add(@PathVariable("trainingId") Integer trainingId,
                                      @RequestBody TrainingSetDto setDto) {
        TrainingDto one = trainingService.one(trainingId);
        if (one == null) {
            return new ResponseEntity<Object>(Map.of("training", trainingId), HttpStatus.NOT_FOUND);
        }
        one.getTrainingSets().add(setDto);
        return ResponseEntity.of(Optional.of("42"));
    }
}
