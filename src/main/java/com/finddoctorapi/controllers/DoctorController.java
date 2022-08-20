package com.finddoctorapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finddoctorapi.models.City;
import com.finddoctorapi.models.Doctor;
import com.finddoctorapi.services.DoctorService;
import com.finddoctorapi.services.PatientService;

@RestController 
@RequestMapping("/api/v1/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService docService;
	
	@Autowired
	private PatientService pService;
	    
	    //add doctor 
	    @PostMapping("/add")
	    public ResponseEntity<?> addDoctor(@RequestBody Doctor doc) {
			try {
				Doctor doctor = this.docService.addDoc(doc);
			    return new ResponseEntity<>(doctor,HttpStatus.CREATED);
			}catch (Exception e) {
				return new ResponseEntity<String>("Some error occurred", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
			}
		}
	
	
	    //get doctor details by id
		@GetMapping("/{id}")
		public ResponseEntity<?> getDoctorData(@PathVariable("id") int id) {
			try {
				Doctor doc = this.docService.findDoctorById(id);
			    return new ResponseEntity<>(doc,HttpStatus.FOUND);
			}catch (Exception e) {
				return new ResponseEntity<String>("Unable to fetch doctor data with given id", new HttpHeaders(), HttpStatus.NOT_FOUND); 
			}
		}
		
		//delete doc by id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delDoctorData(@PathVariable("id") int id) {
			try {
				this.docService.deleteDoctorById(id);
			    return new ResponseEntity<String>("Deleted successfully!",HttpStatus.ACCEPTED);
			}catch (Exception e) {
				return new ResponseEntity<String>("Unable to fetch doctor data with given id", new HttpHeaders(), HttpStatus.NOT_FOUND); 
			}
		}
		
		//update doctor details
		@PatchMapping("/update/{id}")
		public ResponseEntity<?> updateDoctorData(@PathVariable("id") int id, @RequestParam City city, @RequestParam String email,@RequestParam String phoneNo) {
			try {
			    Doctor doc = this.docService.updateDoc(id, city, email, phoneNo);
			    return new ResponseEntity<>(doc,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Some error occurred", new HttpHeaders(), HttpStatus.NOT_MODIFIED); 	
			}
		}
		
		//get doc for patient
		@GetMapping("/find/{pid}")
		public ResponseEntity<?> FindMyDoctor(@PathVariable("pid") int pid) {
			String docCities = "DelhiNoidaFaridabad";
			String city = this.pService.findPatientById(pid).getCity();
			
			List<Doctor> doc = this.docService.findDoctor(pid);
			if(!doc.isEmpty()) {
				return new ResponseEntity<>(doc,HttpStatus.OK);
			}
			else if (docCities.contains(city)) {
				return new ResponseEntity<String>("There isn’t any doctor present at your location for your symptom",HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<String>("We are still waiting to expand to your location",HttpStatus.NOT_FOUND);
			}
		}

}
