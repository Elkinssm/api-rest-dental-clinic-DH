package com.dh.apiDentalClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@NonNull
@Setter
@Getter
@Entity
@Table(name = "turns")

@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})

public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id",referencedColumnName = "id")
    @ToString.Exclude
    private Dentist dentist;


    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ToString.Exclude
    private Patient patient;


    private String date;

}
