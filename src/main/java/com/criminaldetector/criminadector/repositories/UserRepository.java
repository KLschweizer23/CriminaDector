package com.criminaldetector.criminadector.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criminaldetector.criminadector.objects.person.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
