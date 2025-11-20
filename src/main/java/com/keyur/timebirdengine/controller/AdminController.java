package com.keyur.timebirdengine.controller;

import com.keyur.timebirdengine.dto.WorkerResponseDto;
import com.keyur.timebirdengine.service.WorkerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final WorkerService workerService;

    @GetMapping("/workers")
    public ResponseEntity<List<WorkerResponseDto>> getAllWorkers(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(workerService.getAllWorkers(pageNumber, pageSize));
    }

}
