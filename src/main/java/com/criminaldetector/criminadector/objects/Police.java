package com.criminaldetector.criminadector.objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "police")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Police{

    @Column(nullable = false, length = 255)
    private String badgeNumber;

    @Column(nullable = false, length = 255)
    private String password;

    @OneToOne( cascade = CascadeType.ALL )
    private Person person;

}
