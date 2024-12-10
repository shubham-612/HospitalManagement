package com.cg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cg.dto.PatientDTO;
import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "PATIENT-SERVICE",url="http://localhost:9002")
public interface PatientFeign {
	
@GetMapping("/patient/{pid}")
PatientDTO getPatientById(@PathVariable int pid);
}