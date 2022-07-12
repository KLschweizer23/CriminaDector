package com.criminaldetector.criminadector.objects.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.criminaldetector.criminadector.objects.person.extensibleClass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public @Data class User extends Person{
    
    @Column(nullable = false, length = 255)
    private String badgeNumber;

    @Column(nullable = false, length = 255)
    private String password;

}
