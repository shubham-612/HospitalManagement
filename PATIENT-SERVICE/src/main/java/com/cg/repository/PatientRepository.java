package com.cg.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Patient;



@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query("SELECT p FROM Patient p WHERE p.pname = :pname")
    Optional<Patient> findByName(String pname);
	
}
