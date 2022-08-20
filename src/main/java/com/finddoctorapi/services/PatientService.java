package com.finddoctorapi.services;

import com.finddoctorapi.models.Patient;
import com.finddoctorapi.models.Symptoms;


public interface PatientService {
	    
	    //add Patient
	    Patient addPatient(Patient patient);
		
		//get Patient details
		Patient findPatientById(int id);
		
		//delete Patient data
		void deletePatientById(int id);

		//update Patient details
		Patient updatePatient(int id, String city, String email, String phoneNo, Symptoms symptom);
}
