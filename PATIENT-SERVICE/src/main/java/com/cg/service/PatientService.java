package com.cg.service;
 

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Patient;
import com.cg.repository.PatientRepository;
 
@Service
public class PatientService implements IPatientService{
	
	@Autowired
	PatientRepository prd;
	
	@Override
	public List<Patient> findAllPatients() {
		return prd.findAll();
	}
	
	@Override
	public Patient createPatient(Patient pat) {
		// TODO Auto-generated method stub
		return prd.save(pat);
	}

	public void deletePatient(int pid) {
		// TODO Auto-generated method stub
		prd.deleteById(pid);
	}

	@Override
	public Patient updatePatient(int pid,Patient pat) {
		// TODO Auto-generated method stub
		 Optional<Patient> p= findPatientBypid(pid);
		 Patient patient= p.get();
		 patient.setPid(pat.getPid());
		 patient.setPname(pat.getPname());
		 patient.setPhone(pat.getPhone());
		 patient.setAddress(pat.getAddress());
		 return prd.save(pat);
	}

//	@Override
//	public int getCountBypname(String pname) {
//		// TODO Auto-generated method stub
//		return prd.getCountBypname(pname);
//	}

	@Override
	public Optional<Patient> findPatientBypid(int pid) {
		// TODO Auto-generated method stub
		return prd.findById(pid);
	}

	@Override
	public Optional<Patient> getPatientByName(String pname) {
		// TODO Auto-generated method stub
		return prd.findByName(pname);
	}

//	@Override
//	public List<Patient> getPatientBypname(String pname) {
//		// TODO Auto-generated method stub
//		return prd.findAllBypname(pname);
//	}
	
	

}