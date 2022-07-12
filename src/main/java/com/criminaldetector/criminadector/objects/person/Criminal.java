package com.criminaldetector.criminadector.objects.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.criminaldetector.criminadector.objects.person.extensibleClass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "criminals")
@EqualsAndHashCode(callSuper = false)
public @Data class Criminal extends Person{
    
    public Criminal(Long id, String name, String sex, Long age, String role, String description, String lastSeen, String picturePath){
        super(id, name, sex, age, role);
        this.description = description;
        this.lastSeen = lastSeen;
        this.picturePath = picturePath;
    }

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String lastSeen;

    @Column(nullable = false, length = 255)
    private String picturePath;

}
