package com.cg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "did")
	private int did;

    @Column(name = "name")
    private String name;

    @Column(name = "qualification")
    private String qualification;

	public Doctor(int did, String name, String qualification) {
		super();
		this.did = did;
		this.name = name;
		this.qualification = qualification;
	}

	public Doctor() {
		super();
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", name=" + name + ", qualification=" + qualification + "]";
	}
}