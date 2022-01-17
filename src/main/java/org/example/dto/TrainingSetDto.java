package org.example.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TrainingSetDto {
    String practice;
    @Min(1)
    int wight;
    @Min(0)
    int repeats;
}
