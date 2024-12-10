package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="Patient")
public class Patient {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column
	@NotEmpty(message = "Patient name cannot be empty")
	private String pname;
	
	@Column
	private long phone;
	
	@Column
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

	public Patient(int pid, String pname, long phone, String address) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.phone = phone;
		this.address = address;
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", phone=" + phone + ", address=" + address + "]";
	}
}