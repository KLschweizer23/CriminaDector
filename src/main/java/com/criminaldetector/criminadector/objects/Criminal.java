package com.criminaldetector.criminadector.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "criminals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criminal{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String lastSeen;

    @Column(nullable = false, length = 255)
    private String picturePath;

    @OneToOne( cascade = CascadeType.ALL )
    private Person person;

}
