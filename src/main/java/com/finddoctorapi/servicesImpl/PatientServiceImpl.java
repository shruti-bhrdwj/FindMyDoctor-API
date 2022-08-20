package com.finddoctorapi.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finddoctorapi.models.Patient;
import com.finddoctorapi.models.Symptoms;
import com.finddoctorapi.repos.PatientRepo;
import com.finddoctorapi.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public Patient findPatientById(int id) {
		return patientRepo.findById(id).get();
	}

	@Override
	public Patient updatePatient(int id, String city, String email, String phoneNo, Symptoms symptom) {
		Patient pa= null;
		if(patientRepo.existsById(id)) {
			pa = patientRepo.findById(id).get();
			pa.setCity(city);
			pa.setEmail(email);
			pa.setPhoneNo(phoneNo);
			pa.setSymptoms(symptom);
		}
		return pa;
	}

	@Override
	public void deletePatientById(int id) {
		patientRepo.deleteById(id);
	}

}
