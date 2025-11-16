package com.keyur.timebirdengine.repository;

import com.keyur.timebirdengine.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}