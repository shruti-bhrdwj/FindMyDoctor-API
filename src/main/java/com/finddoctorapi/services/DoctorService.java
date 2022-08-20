package com.finddoctorapi.services;

import java.util.List;

import com.finddoctorapi.models.City;
import com.finddoctorapi.models.Doctor;

public interface DoctorService {

	//add doctor
	Doctor addDoc(Doctor doctor);
	
	//get doctor details
	Doctor findDoctorById(int id);
	
	//update doctor details
	Doctor updateDoc(int id, City city, String email, String phoneNo);
	
	//delete doctor data
	void deleteDoctorById(int id);
	
	//Suggest doctor for patient
	List<Doctor> findDoctor(int pid);

}
