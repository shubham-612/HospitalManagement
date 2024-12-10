package com.cg.controller;
 
import java.util.List;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dto.AppointmentDTO;
import com.cg.dto.DoctorDTO;
import com.cg.entity.Appointment;
import com.cg.exception.ResourceNotFound;
import com.cg.feign.DoctorFeign;
import com.cg.service.IAppointmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
 
@RequestMapping("/appointment")
@RestController

public class AppointmentController {
	
	@Autowired
	IAppointmentService as;
	
	@Autowired
	DoctorFeign df;
	
	
	// FIND ALL APPOINTMNET
	@GetMapping("/getall")    public List<Appointment> getAllAppointments() {
        return as.findAllAppointments();                
    }
	
	// FIND APPOINTMENT BY ID WITH EXCEPTION 
	@GetMapping("/{aid}")
	Optional<Appointment>findByAppointmentIdFromDBWithException(@PathVariable int aid) throws ResourceNotFound
	{	
		Optional<Appointment> appointment = as.findAppointmentByaid(aid);
    	appointment.orElseThrow(() -> new ResourceNotFound("Appointment not found for this id :: " + aid));
    	System.out.println(aid);
    	return appointment;	
	}
	
	// CREATE APPOINTMENT
	@PostMapping("/create")
		public Appointment createAppointment( @RequestBody Appointment appointment) {
        return as.createAppointment(appointment);
	}
	
	// DELETE APPOINTMENT
	@DeleteMapping("/delete/{id}")
		public void DeleteAppointment(@PathVariable int aid) {
		 as.deleteAppointment(aid);
	}
	
	// UPDATE APPOINTMENT
	@PutMapping("/update")
		public Appointment updateAppointment(@RequestBody Appointment app) throws ResourceNotFound{
		int aid = app.getAid();
		return as.updateAppointment(aid, app);
	}
	
	// CALL DOCTOR AND PATIENT DETAILS BY APPOINTMENT ID
	@GetMapping("/byid/{aid}")
		public AppointmentDTO getappAppointmentwithdoctor(@PathVariable int aid){
		return as.getAppointmentwithDoctorandPatientByaid(aid);
	}
	
	
	private static final String Doctor_Service = "DOCTOR-SERVICE";
    private int attempt = 1;
    // Fetch all doctors with fallback using Resilience4j circuit breaker and retry
    @GetMapping("/fallbackdoctors")
   @CircuitBreaker(name = Doctor_Service, fallbackMethod = "getAllDoctorsFallback")
    @Retry(name = Doctor_Service, fallbackMethod = "getAllDoctorsFallback")
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        System.out.println("Retry method called " + attempt++ + " times " + " at " + new Date());
        // Make the request to the feign client to fetch the list of doctors
        List<DoctorDTO> doctors = df.getAllDoctors();
        return ResponseEntity.ok().body(doctors);
    }
 
    // Fallback method that uses the method defined in the Feign fallback class
    public ResponseEntity<List<DoctorDTO>> getAllDoctorsFallback(Exception throwable) {
        // Log the error for debugging
        System.out.println("Fallback method triggered due to: " + throwable.getMessage());
        throwable.printStackTrace();
        
        // Return the predefined fallback list of appointments from the feign client fallback
        List<DoctorDTO> fallbackDoctors = df.getAllDoctors();
    
        return ResponseEntity.ok().body(fallbackDoctors);
    }
}