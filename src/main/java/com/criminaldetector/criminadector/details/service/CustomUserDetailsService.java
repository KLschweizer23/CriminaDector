package com.criminaldetector.criminadector.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.criminaldetector.criminadector.objects.Person;
import com.criminaldetector.criminadector.objects.Police;
import com.criminaldetector.criminadector.repositories.PersonRepository;

public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Police police = personRepository.findByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        return new CustomUserDetails(user);

    }

}