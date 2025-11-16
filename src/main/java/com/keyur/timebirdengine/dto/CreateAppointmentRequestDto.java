package com.keyur.timebirdengine.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentRequestDto {
    private Long doctorId;
    private Long WorkerId;
    private LocalDateTime appointmentTime;
    private String reason;
}
