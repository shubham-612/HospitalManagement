package com.cg.service;

import com.cg.entity.Doctor;
import java.util.List;
import java.util.Optional;
 
public interface IDoctorService {
    List<Doctor> findAllDoctors();
    Optional<Doctor> findDoctorById(int id);
    Doctor createDoctor(Doctor doctor);
    void deleteDoctor(int id);
    Doctor updateDoctor(int id, Doctor doctor);
    public boolean hasPermission(String token);
}