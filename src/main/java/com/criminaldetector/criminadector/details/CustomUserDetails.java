package com.criminaldetector.criminadector.details;

import com.criminaldetector.criminadector.objects.Person;
import com.criminaldetector.criminadector.objects.Police;

public class CustomUserDetails extends AbstractDetails{

    private Police police;
    private Person person;

    public CustomUserDetails(Person person, Police police){
        this.person = person;
        this.police = police;
    }

    @Override
    public String getPassword() {
        return police.getPassword();
    }

    @Override
    public String getBadge() {
        return police.getBadgeNumber();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public String getSex() {
        return person.getSex();
    }

    @Override
    public Long getAge() {
        return person.getAge();
    }

    @Override
    public String getRole() {
        return person.getRole();
    }

    @Override
    public Long getId() {
        return person.getId();
    }

    
    
}
