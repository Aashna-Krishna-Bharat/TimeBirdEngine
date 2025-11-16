package com.keyur.timebirdengine.dto;

import lombok.Data;

@Data
public class OnboardDoctorRequestDto {
    private Long userId;
    private String userRole;
    private String name;
}
