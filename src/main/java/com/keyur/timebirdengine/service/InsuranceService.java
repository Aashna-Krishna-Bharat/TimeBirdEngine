package com.keyur.timebirdengine.service;

import com.keyur.timebirdengine.entity.Insurance;
import com.keyur.timebirdengine.entity.Worker;
import com.keyur.timebirdengine.repository.InsuranceRepository;
import com.keyur.timebirdengine.repository.WorkerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final WorkerRepository workerRepository;

    @Transactional
    public Worker assignInsuranceToWorker(Insurance insurance, Long workerId) {
    	Worker Worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found with id: " + workerId));

        Worker.setInsurance(insurance);
        insurance.setWorker(Worker); // bidirectional consistency maintainence

        return Worker;
    }

    @Transactional
    public Worker disaccociateInsuranceFromWorker(Long WorkerId) {
    	Worker Worker = workerRepository.findById(WorkerId)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found with id: " + WorkerId));

        Worker.setInsurance(null);
        return Worker;
    }

    // HW
    //Create three appointment for a Worker and then delete Worker


}
