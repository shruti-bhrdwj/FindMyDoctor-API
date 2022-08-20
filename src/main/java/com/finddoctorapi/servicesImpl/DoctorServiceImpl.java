package com.finddoctorapi.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finddoctorapi.models.City;
import com.finddoctorapi.models.Doctor;
import com.finddoctorapi.models.Patient;
import com.finddoctorapi.repos.DoctorRepo;
import com.finddoctorapi.repos.PatientRepo;
import com.finddoctorapi.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepo dRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Override
	public Doctor addDoc(Doctor doctor) {
		return dRepo.save(doctor);
	}

	@Override
	public Doctor findDoctorById(int id) {
		return dRepo.findById(id).get();
	}

	@Override
	public void deleteDoctorById(int id) {
		dRepo.deleteById(id);
	}

	@Override
	public List<Doctor> findDoctor(int pid) {
		
		Patient patient = patientRepo.findById(pid).get(); 
		List<Doctor> docsList = new ArrayList<>(); 
		int n = patient.getSymptoms().ordinal();
		
		switch(n) {
		
		case 0,1,2 : for(Doctor doc : dRepo.findAll()){
			if (doc.getSpeciality().ordinal()==0 && patient.getCity().equals(doc.getCity().name())) {
				docsList.add(doc);
			}
		};
		break;
		case 3 : for(Doctor doc : dRepo.findAll()){
			if (doc.getSpeciality().ordinal()==1 && patient.getCity().equals(doc.getCity().name())) {
				docsList.add(doc);
			}
		};
		break;
		case 4,5 : for(Doctor doc : dRepo.findAll()){
			if (doc.getSpeciality().ordinal()==2 && patient.getCity().equals(doc.getCity().name())) {
				docsList.add(doc);
			}
		};
		break;
		case 6 : for(Doctor doc : dRepo.findAll()){
			if (doc.getSpeciality().ordinal()==3 && patient.getCity().equals(doc.getCity().name())) {
				docsList.add(doc);
			}
		};
		break;
		}	
		return docsList;
	}

	@Override
	public Doctor updateDoc(int id, City city, String email, String phoneNo) {
		Doctor doc = null;
		if(dRepo.existsById(id)) {
			doc = dRepo.findById(id).get();
			doc.setCity(city);
			doc.setEmail(email);
			doc.setPhoneNo(phoneNo);
		}
		return doc;
	}

}
