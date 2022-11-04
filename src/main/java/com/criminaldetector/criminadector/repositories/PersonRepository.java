package com.criminaldetector.criminadector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criminaldetector.criminadector.objects.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
