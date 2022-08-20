package com.finddoctorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finddoctorapi.models.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{

}
