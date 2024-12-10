package com.cg.service;
 

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.AppointmentDTO;
import com.cg.dto.DoctorDTO;
import com.cg.dto.PatientDTO;
import com.cg.entity.Appointment;
import com.cg.feign.DoctorFeign;
import com.cg.feign.PatientFeign;
import com.cg.repository.AppointmentRepository;
 
@Service
public class AppointmentService implements IAppointmentService{
	
	@Autowired
	AppointmentRepository ard;

	@Autowired
	DoctorFeign dc;
	
	@Autowired
	PatientFeign pf;
	
	@Override
	public List<Appointment> findAllAppointments() {
		return ard.findAll();
	}
	
	@Override
	public Optional<Appointment> findAppointmentByaid(int aid) {
		// TODO Auto-generated method stub
		return ard.findById(aid);
	}
	
	@Override
	public Appointment createAppointment(Appointment app) {
		// TODO Auto-generated method stub
		return ard.save(app);
	}

	public void deleteAppointment(int aid) {
		// TODO Auto-generated method stub
		ard.deleteById(aid);
	}

	@Override
	public Appointment updateAppointment(int aid,Appointment app) {
		// TODO Auto-generated method stub
		 Optional<Appointment> a= findAppointmentByaid(aid);
		 Appointment appointment= a.get();
		 appointment.setAid(app.getAid());
		 appointment.setPid(app.getPid());
		 appointment.setDid(app.getDid());
		 appointment.setTime(app.getTime());
		 appointment.setDate(app.getDate());
		 appointment.setIssue(app.getIssue());
		 appointment.setStatus(app.getStatus());
		 appointment.setFees(app.getFees());
		 
		 return ard.save(app);
	}

	@Override
	public AppointmentDTO getAppointmentwithDoctorandPatientByaid(int aid) {
		
		Appointment app = ard.findById(aid)
				.orElseThrow(() -> new RuntimeException("Appointment not found with id " + aid));
		
		DoctorDTO doctor = dc.getDoctorById(app.getDid());
		PatientDTO patient = pf.getPatientById(app.getPid());
		
		AppointmentDTO adto = new AppointmentDTO();
		adto.setAid(app.getAid());
		adto.setTime(app.getTime());
		adto.setDate(app.getDate());
		adto.setIssue(app.getIssue());
		adto.setStatus(app.getStatus());
		adto.setFees(app.getFees());
		adto.setDoctor(doctor);
		adto.setPatient(patient);
		return adto;
	}



	
}
