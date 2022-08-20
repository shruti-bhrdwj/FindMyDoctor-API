package com.finddoctorapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finddoctorapi.models.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{

}
