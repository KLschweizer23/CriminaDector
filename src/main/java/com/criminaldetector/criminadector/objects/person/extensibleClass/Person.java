package com.criminaldetector.criminadector.objects.person.extensibleClass;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
public @Data class Person {
    
    public Person(Long id, String name, String sex, Long age, String role) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String sex;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false, length = 255)
    private String role;

}
