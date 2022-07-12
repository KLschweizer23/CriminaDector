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
    
    public User(Long id, String name, String sex, Long age, String role, String badgeNumber, String password) {
        super(id, name, sex, age, role);
        this.badgeNumber = badgeNumber;
        this.password = password;
    }

    @Column(nullable = false, length = 255)
    private String badgeNumber;

    @Column(nullable = false, length = 255)
    private String password;

}
