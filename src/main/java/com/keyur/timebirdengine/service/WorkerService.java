package com.keyur.timebirdengine.service;


import com.keyur.timebirdengine.dto.WorkerResponseDto;
import com.keyur.timebirdengine.entity.Worker;
import com.keyur.timebirdengine.repository.WorkerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public WorkerResponseDto getWorkerById(Long workerId) {
    	Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new EntityNotFoundException("Worker Not " +
                "Found with id: " + workerId));
        return modelMapper.map(worker, WorkerResponseDto.class);
    }

    public List<WorkerResponseDto> getAllWorkers(Integer pageNumber, Integer pageSize) {
        return workerRepository.findAllWorkers(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerResponseDto.class))
                .collect(Collectors.toList());
    }
}
