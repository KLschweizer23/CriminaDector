package com.criminaldetector.criminadector.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.criminaldetector.criminadector.details.CustomUserDetails;
import com.criminaldetector.criminadector.objects.Police;
import com.criminaldetector.criminadector.repositories.PoliceRepository;

public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private PoliceRepository policeRepository;

    @Override
    public UserDetails loadUserByUsername(String badge) throws UsernameNotFoundException {

        Police police = policeRepository.findByBadgeNumber(badge);
        
        if(police == null){
            throw new UsernameNotFoundException("User not found!");
        }

        return new CustomUserDetails(police.getPerson(), police);

    }

}