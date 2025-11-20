package com.keyur.timebirdengine.repository;

import com.keyur.timebirdengine.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Worker findByName(String name);
	/*
	 * List<Worker> findByBirthDateOrEmail(LocalDate birthDate, String email);
	 * 
	 * List<Worker> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
	 */

    List<Worker> findByNameContainingOrderByIdDesc(String query);
//
//    @Query("SELECT p FROM Worker p where p.bloodGroup = ?1")
//    List<Worker> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);
//
//    @Query("select p from Worker p where p.birthDate > :birthDate")
//    List<Worker> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);
//
//    @Query("select new com.keyur.timebirdengine.dto.BloodGroupCountResponseEntity(p.bloodGroup," +
//            " Count(p)) from Worker p group by p.bloodGroup")
////    List<Object[]> countEachBloodGroupType();
//    List<BloodGroupCountResponseEntity> countEachBloodGroupType();
//
    @Query(value = "select * from worker", nativeQuery = true)
    Page<Worker> findAllWorkers(Pageable pageable);
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE Worker p SET p.name = :name where p.id = :id")
//    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
//
//
//    //    @Query("SELECT p FROM Worker p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
//    @Query("SELECT p FROM Worker p LEFT JOIN FETCH p.appointments")
//    List<Worker> findAllWorkerWithAppointment();

}
