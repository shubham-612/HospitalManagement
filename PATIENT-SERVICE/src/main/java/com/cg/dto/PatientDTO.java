package com.cg.dto;

import com.cg.entity.Patient;

public class PatientDTO {
	
	private int pid;
	
	private String pname;
	
	private long phone;
	
	private String address;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PatientDTO(int pid, String pname, long phone, String address) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.phone = phone;
		this.address = address;
	}

	public PatientDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", phone=" + phone + ", address=" + address + "]";
	}
	//to convert product entity to dto object
	public static PatientDTO fromEntity(Patient patient) {
		return new PatientDTO(patient.getPid(), patient.getPname(), patient.getPhone(), patient.getAddress());
	}
	//to convert from dto object to product entity
	public  Patient toEntity() {
		return new Patient(this.pid, this.pname, this.phone, this.address);
	}
}
