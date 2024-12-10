package com.cg.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@Column
	private int pid;
	
	@Column 
	private int did;
	
	@Column
	private String time;
	
	@Column
	private Date date;
	
	@Column
	private String issue;
	
	@Column
	private String status;
	
	@Column
	private int fees;

	public Appointment(int aid, int pid, int did, String time, Date date, String issue, String status, int fees) {
		super();
		this.aid = aid;
		this.pid = pid;
		this.did = did;
		this.time = time;
		this.date = date;
		this.issue = issue;
		this.status = status;
		this.fees = fees;
	}

	public Appointment() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", pid=" + pid + ", did=" + did + ", time=" + time + ", date=" + date
				+ ", issue=" + issue + ", status=" + status + ", fees=" + fees + "]";
	}
}