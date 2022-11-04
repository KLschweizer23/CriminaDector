package com.criminaldetector.criminadector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criminaldetector.criminadector.objects.Police;

public interface PoliceRepository extends JpaRepository<Police, Long>{
    
}
