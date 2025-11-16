package com.keyur.timebirdengine.controller;

import com.keyur.timebirdengine.dto.AppointmentResponseDto;
import com.keyur.timebirdengine.dto.CreateAppointmentRequestDto;
import com.keyur.timebirdengine.dto.WorkerResponseDto;
import com.keyur.timebirdengine.service.AppointmentService;
import com.keyur.timebirdengine.service.WorkerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<WorkerResponseDto> getWorkerProfile() {
        Long WorkerId = 4L;
        return ResponseEntity.ok(workerService.getWorkerById(WorkerId));
    }

}
