package com.keyur.timebirdengine.repository;

import com.keyur.timebirdengine.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}