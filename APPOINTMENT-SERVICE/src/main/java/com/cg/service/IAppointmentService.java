package com.cg.service;
 
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import com.cg.dto.AppointmentDTO;
import com.cg.entity.Appointment;
 
public interface IAppointmentService {

	List<Appointment> findAllAppointments() ;
	
	public Optional<Appointment> findAppointmentByaid(int aid);
	
	public Appointment createAppointment(Appointment app);
	
	public void deleteAppointment(int aid);
	
	public Appointment updateAppointment(int aid,Appointment app);
	
	public AppointmentDTO getAppointmentwithDoctorandPatientByaid(@PathVariable int aid);
}