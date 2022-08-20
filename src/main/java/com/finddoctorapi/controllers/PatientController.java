package com.finddoctorapi.controllers;

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

import com.finddoctorapi.models.Patient;
import com.finddoctorapi.models.Symptoms;
import com.finddoctorapi.services.PatientService;


@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	@Autowired
	private PatientService pService;
	    
	    //add patient 
	    @PostMapping("/add")
	    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
			try {
				Patient p = this.pService.addPatient(patient);
			    return new ResponseEntity<>(p,HttpStatus.CREATED);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Some error occurred", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
			}
		}

	
	
	    //get patient details by id
		@GetMapping("/{id}")
		public ResponseEntity<?> getPatientData(@PathVariable("id") int id) {
			try {
				Patient p  = this.pService.findPatientById(id);
			    return new ResponseEntity<>(p,HttpStatus.FOUND);
			}catch (Exception e) {
				return new ResponseEntity<String>("Unable to fetch patient data with given id", new HttpHeaders(), HttpStatus.NOT_FOUND); 
			}
		}
		
		//delete patient by id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delPatientData(@PathVariable("id") int id) {
			try {
				this.pService.deletePatientById(id);
			    return new ResponseEntity<String>("Deleted successfully!",HttpStatus.ACCEPTED);
			}catch (Exception e) {
				return new ResponseEntity<String>("Unable to fetch patient data with given id", new HttpHeaders(), HttpStatus.NOT_FOUND); 
			}
		}
		
		//update patient details
		@PatchMapping("/update/{id}")
		public ResponseEntity<?> updatePatientData(@PathVariable("id") int id,@RequestParam String city, @RequestParam String email,@RequestParam String phoneNo, @RequestParam Symptoms symptom) {
			try {
			    Patient p = this.pService.updatePatient(id, city, email, phoneNo, symptom);
			    return new ResponseEntity<>(p,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Some error occurred", new HttpHeaders(), HttpStatus.NOT_MODIFIED); 	
			
		    }
		}


}
