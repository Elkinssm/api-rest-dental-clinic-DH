package com.dh.apiDentalClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name = "dentists")

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String registrationNumber;

}
