package com.keyur.timebirdengine.repository;

import com.keyur.timebirdengine.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}