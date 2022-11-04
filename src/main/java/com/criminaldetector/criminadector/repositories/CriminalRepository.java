package com.criminaldetector.criminadector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criminaldetector.criminadector.objects.Criminal;

public interface CriminalRepository extends JpaRepository<Criminal, Long>{
    
}
