package com.cg.dto;


public class DoctorDTO {
	private int did;
    private String name;
    private String qualification;
    
    
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

	public DoctorDTO(int did, String name, String qualification) {
		super();
		this.did = did;
		this.name = name;
		this.qualification = qualification;
	}
	public DoctorDTO() {
		super();
	}
}
