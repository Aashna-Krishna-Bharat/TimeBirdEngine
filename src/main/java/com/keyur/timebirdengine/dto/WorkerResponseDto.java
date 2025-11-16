package com.keyur.timebirdengine.dto;

import com.keyur.timebirdengine.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkerResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}
