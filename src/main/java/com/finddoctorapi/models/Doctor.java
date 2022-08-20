package com.finddoctorapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false)
	@Size(min=3)
	private String name;
	
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private City city;
	
	@Column(unique=true)
	@Pattern(regexp= "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@Column(nullable=false)
	@Size(min=10)
	private String phoneNo;
	
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Speciality speciality;
	
	public Doctor() {};

	public Doctor(int id, @Size(min = 3) String name, City city,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String email, @Size(min = 10) String phoneNo,
			Speciality speciality) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
		this.speciality = speciality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", speciality=" + speciality + "]";
	}
	

}
