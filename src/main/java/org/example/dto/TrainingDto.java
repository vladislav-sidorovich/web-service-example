package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDto {
    Date trainingDate;
    long duration;
    String notes;

    List<TrainingSetDto> trainingSets = new ArrayList<>();
}
